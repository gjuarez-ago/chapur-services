package com.chapur.services.service;

import java.io.IOException;

import org.springframework.stereotype.Component;
import com.chapur.services.entity.UserInfo;
import com.chapur.services.models.LoginResponse;
import com.chapur.services.models.UserCredentials;
import org.apache.hc.core5.http.ParseException;

@Component
public interface IAuthService {

    String addUser(UserInfo userInfo);

    LoginResponse login2(String url, UserCredentials userCredentials) throws IOException, ParseException;

}