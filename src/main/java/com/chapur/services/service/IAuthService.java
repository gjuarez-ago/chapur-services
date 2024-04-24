package com.chapur.services.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.chapur.services.entity.UserInfo;

@Component
public interface IAuthService {

    String addUser(UserInfo userInfo);

}