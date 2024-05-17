package com.chapur.services.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chapur.services.entity.RefreshToken;
import com.chapur.services.exception.GenericException;
import com.chapur.services.models.LoginComplementResponse;
import com.chapur.services.repository.RefreshTokenRepository;
import com.chapur.services.repository.UserInfoRepository;
import com.chapur.services.service.IRefreshTokenService;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    public RefreshToken createRefreshToken(int userId) {
        RefreshToken refreshToken = RefreshToken.builder()
                .userInfo(userId)
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(600000))// 10
                .build();
        return refreshTokenRepository.save(refreshToken);
    }

    public List<RefreshToken> getAllTokens() {
        return refreshTokenRepository.findAll();
    }

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public void verifyExpiration(String token) throws GenericException {

        Optional<RefreshToken> entity = Optional.ofNullable(refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new GenericException("Refresh token is not in database!")));

        if (entity.get().getExpiryDate().compareTo(Instant.now()) < 0) {

            refreshTokenRepository.deleteByToken(token);
            // refreshTokenRepository.findByToken(token.getToken());

            throw new RuntimeException(
                    token + " Refresh token was expired. Please make a new signin request");
        }
    }

}
