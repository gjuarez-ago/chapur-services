package com.chapur.services.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.chapur.services.entity.RefreshToken;
import com.chapur.services.exception.GenericException;

@Component
public interface IRefreshTokenService {

    public RefreshToken createRefreshToken(int datos);

    public List<RefreshToken> getAllTokens();

    public Optional<RefreshToken> findByToken(String token);

    public void verifyExpiration(String token) throws GenericException;

}
