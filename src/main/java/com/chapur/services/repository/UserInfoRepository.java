package com.chapur.services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chapur.services.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByName(String username);
}

