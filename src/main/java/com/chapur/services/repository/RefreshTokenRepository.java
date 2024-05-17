package com.chapur.services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chapur.services.entity.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {

    Optional<RefreshToken> findByToken(String token);

    void deleteByToken(String token);
}
