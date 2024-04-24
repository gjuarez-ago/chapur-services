package com.chapur.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chapur.services.entity.UserInfo;
import com.chapur.services.repository.UserInfoRepository;
import com.chapur.services.service.IAuthService;

@Service
public class AuthServiceServiceImpl implements IAuthService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }

}