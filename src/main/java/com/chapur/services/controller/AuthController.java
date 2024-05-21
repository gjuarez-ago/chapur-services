package com.chapur.services.controller;

import java.io.IOException;
import java.util.List;

import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chapur.services.entity.RefreshToken;
import com.chapur.services.exception.GenericException;
import com.chapur.services.models.JwtResponse;
import com.chapur.services.models.LoginResponse;
import com.chapur.services.models.RefreshTokenDTO;
import com.chapur.services.models.RefreshTokenResponse;
import com.chapur.services.models.UserCredentials;
import com.chapur.services.service.IAuthService;
import com.chapur.services.service.IRefreshTokenService;
import com.chapur.services.service.JwtService;

@RestController
@RequestMapping("/api")
public class AuthController {

	@Autowired
	private IAuthService service;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private IRefreshTokenService refreshTokenService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/all-tokens")
	public List<RefreshToken> getAllTokens() {
		return refreshTokenService.getAllTokens();
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login2(@RequestBody UserCredentials userCredentials)
			throws ParseException, IOException, GenericException {

		// Authentication authentication = authenticationManager.authenticate(
		// new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
		// authRequest.getPassword()));

		LoginResponse response = service.login(userCredentials);

		if (response.getEstatus() == 0) {
			throw new GenericException(response.getResultado());
		}

		JwtResponse s = JwtResponse.builder()
				.accessToken(jwtService.generateToken(response.getDatos().getEmail()))
				.token(refreshTokenService.createRefreshToken(response.getDatos().getNumiden()).getToken()).build();

		response.setTokenSpring(s.getAccessToken());
		response.setRefreshTokenSpring(s.getToken());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/refreshToken")
	public ResponseEntity<RefreshTokenResponse> refreshToken(@RequestBody RefreshTokenDTO refreshTokenRequest)
			throws ParseException, IOException, GenericException {

		RefreshTokenResponse response = service.refreshToken(refreshTokenRequest);
		refreshTokenService.verifyExpiration(refreshTokenRequest.getTokenSpring());

		JwtResponse s = JwtResponse.builder()
				.accessToken(jwtService.generateToken(refreshTokenRequest.getEmail()))
				.token(refreshTokenService.createRefreshToken(refreshTokenRequest.getUserId()).getToken()).build();

		response.setTokenSpring(s.getAccessToken());
		response.setRefreshTokenSpring(s.getToken());

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
