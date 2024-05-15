package com.chapur.services.service.impl;

import java.io.IOException;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chapur.services.entity.UserInfo;
import com.chapur.services.exception.GenericException;
import com.chapur.services.models.LoginResponse;
import com.chapur.services.models.UserCredentials;
import com.chapur.services.repository.UserInfoRepository;
import com.chapur.services.service.IAuthService;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    @Override
    public LoginResponse login(String url, UserCredentials userCredentials)
            throws IOException, ParseException, GenericException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        // Convertir el objeto a JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(userCredentials);

        // Establecer el cuerpo de la solicitud
        httpPost.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        CloseableHttpResponse response = httpclient.execute(httpPost);

        HttpEntity entity = response.getEntity();
        String jsonResponse = EntityUtils.toString(entity);
        LoginResponse apiResponse = objectMapper.readValue(jsonResponse,
                LoginResponse.class);

        System.out.println("Estatus: " + response.getCode());
        System.out.println("Resultado: " + apiResponse.getResultado());

        if (apiResponse.getEstatus() == 0) {
            throw new GenericException(apiResponse.getResultado());
        }

        return apiResponse;

    }

}