package com.chapur.services.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
import com.chapur.services.models.RefreshTokenRequest;
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

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> enviarPost(@RequestBody UserCredentials userCredentials)
			throws ParseException, IOException, GenericException {

		String url = "http://10.2.91.67:8090/servicios-rest-dev7/usuario/valida_login";

		LoginResponse response = service.login(url, userCredentials);
		JwtResponse s = JwtResponse.builder()
				.accessToken(jwtService.generateToken(response.getDatos().getEmail()))
				.token(UUID.randomUUID().toString()).build();
		refreshTokenService.createRefreshToken(response.getDatos());
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@GetMapping("/all-tokens")
	public List<RefreshToken> getAllTokens() {
		return refreshTokenService.getAllTokens();
	}

	// @PostMapping("/login")
	// public JwtResponse authenticateAndGetToken(@RequestBody AuthRequest
	// authRequest) {
	// Authentication authentication = authenticationManager.authenticate(
	// new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
	// authRequest.getPassword()));
	// if (authentication.isAuthenticated()) {
	// RefreshToken refreshToken = refreshTokenService.createRefreshToken(
	// new LoginComplementResponse());
	// return JwtResponse.builder()
	// .accessToken(jwtService.generateToken(authRequest.getUsername()))
	// .token(refreshToken.getToken()).build();
	// } else {
	// throw new UsernameNotFoundException("invalid user request !");
	// }
	// }

	@PostMapping("/refreshToken")
	public JwtResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
		return refreshTokenService.findByToken(refreshTokenRequest.getToken())
				.map(refreshTokenService::verifyExpiration)
				.map(RefreshToken::getUserInfo)
				.map(userInfo -> {
					String accessToken = jwtService.generateToken("string");
					return JwtResponse.builder()
							.accessToken(accessToken)
							.token(refreshTokenRequest.getToken())
							.build();
				}).orElseThrow(() -> new RuntimeException(
						"Refresh token is not in database!"));
	}

}
