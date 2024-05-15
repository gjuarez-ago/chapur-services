package com.chapur.services.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.chapur.services.entity.RefreshToken;
import com.chapur.services.models.LoginComplementResponse;

@Component
public interface IRefreshTokenService {

    public RefreshToken createRefreshToken(LoginComplementResponse datos);

    public List<RefreshToken> getAllTokens();

    public Optional<RefreshToken> findByToken(String token);

    public RefreshToken verifyExpiration(RefreshToken token);

}
