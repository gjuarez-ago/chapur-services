package com.chapur.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chapur.services.entity.RefreshToken;
import com.chapur.services.entity.UserInfo;
import com.chapur.services.models.AuthRequest;
import com.chapur.services.models.JwtResponse;
import com.chapur.services.models.RefreshTokenRequest;
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

	@PostMapping("/signUp")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		return service.addUser(userInfo);
	}

	@GetMapping("/all-tokens")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<RefreshToken> getAllTokens() {
		return refreshTokenService.getAllTokens();
	}

	@PostMapping("/login")
	public JwtResponse authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			RefreshToken refreshToken = refreshTokenService.createRefreshToken(authRequest.getUsername());
			return JwtResponse.builder()
					.accessToken(jwtService.generateToken(authRequest.getUsername()))
					.token(refreshToken.getToken()).build();
		} else {
			throw new UsernameNotFoundException("invalid user request !");
		}
	}

	@PostMapping("/refreshToken")
	public JwtResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
		return refreshTokenService.findByToken(refreshTokenRequest.getToken())
				.map(refreshTokenService::verifyExpiration)
				.map(RefreshToken::getUserInfo)
				.map(userInfo -> {
					String accessToken = jwtService.generateToken(userInfo.getName());
					return JwtResponse.builder()
							.accessToken(accessToken)
							.token(refreshTokenRequest.getToken())
							.build();
				}).orElseThrow(() -> new RuntimeException(
						"Refresh token is not in database!"));
	}

}
