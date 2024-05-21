package com.chapur.services.service.impl;

import java.io.IOException;

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
import com.chapur.services.models.RefreshTokenDTO;
import com.chapur.services.models.RefreshTokenResponse;
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
        public LoginResponse login(UserCredentials userCredentials)
                        throws IOException, ParseException, GenericException {

                String urlD = "http://10.2.91.22:8080/WSRF.PCCRE_DEV/WS/Servicio/Rest/WS/App/Servicio/Login";

                CloseableHttpClient httpclient = HttpClients.createDefault();
                HttpPost httpPost = new HttpPost(urlD);

                // Convertir el objeto a JSON
                ObjectMapper objectMapper = new ObjectMapper();

                String json = "{\r\n" +
                                "\t\"DetOperacion\": [\r\n" +
                                "\t\t{\r\n" +
                                "\t\t\t\"sOperacion\": \"Login\",\r\n" +
                                "\t\t\t\"sTipoDatos\": \"Datos\",\r\n" +
                                "\t\t\t\"sUsername\": \"" + userCredentials.getUsername() + "\",\r\n" +
                                "\t\t\t\"sPassword\": \"" + userCredentials.getPassword() + "\",\r\n" +
                                "\t\t\t\"sToken\": \"nHESFdOtAFGUEki9P8bF7A==\"\r\n" +
                                "\t\t}\r\n" +
                                "\t]\r\n" +
                                "}";

                objectMapper.writeValueAsString(userCredentials);

                // Establecer el cuerpo de la solicitud
                httpPost.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
                httpPost.setHeader("Authorization", "nHESFdOtAFGUEki9P8bF7A==");

                CloseableHttpResponse response = httpclient.execute(httpPost);

                System.err.println(response.getCode());

                HttpEntity entity = response.getEntity();
                String jsonResponse = EntityUtils.toString(entity);
                LoginResponse apiResponse = objectMapper.readValue(jsonResponse,
                                LoginResponse.class);

                System.out.println("Estatus: " + response.getCode());
                System.out.println("Resultado: " + apiResponse.toString());

                return apiResponse;
        }

        @Override
        public RefreshTokenResponse refreshToken(RefreshTokenDTO userCredentials)
                        throws IOException, ParseException, GenericException {

                String urlD = "http://10.2.91.22:8080/WSRF.PCCRE_DEV/WS/Servicio/Rest/WS/App/Servicio/jwt/refreshToken";

                CloseableHttpClient httpclient = HttpClients.createDefault();
                HttpPost httpPost = new HttpPost(urlD);

                // Convertir el objeto a JSON
                ObjectMapper objectMapper = new ObjectMapper();

                String json = "{\r\n" +
                                "\t\"DetOperacion\": [\r\n" +
                                "\t\t{\r\n" +
                                "\t\t\t\"isRefreshToken\": \"true\",\r\n" +
                                "\t\t\t\"email\": \"" + userCredentials.getEmail() + "\"\r\n" +
                                "\t\t}\r\n" +
                                "\t]\r\n" +
                                "}";

                objectMapper.writeValueAsString(userCredentials);

                // Establecer el cuerpo de la solicitud
                httpPost.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
                httpPost.setHeader("Authorization", "Bearer " + userCredentials.getToken());

                CloseableHttpResponse response = httpclient.execute(httpPost);

                if (response.getCode() >= 400 && response.getCode() < 500) {
                        throw new GenericException("Ha ocurrido un problema al consumir el servicio.");
                }

                if (response.getCode() >= 500 && response.getCode() < 600) {
                        throw new GenericException("Error en el servicio de consuo de la API.");
                }

                HttpEntity entity = response.getEntity();
                String jsonResponse = EntityUtils.toString(entity);
                RefreshTokenResponse apiResponse = objectMapper.readValue(jsonResponse,
                                RefreshTokenResponse.class);

                System.out.println("Estatus: " + response.getCode());
                System.out.println("Resultado: " + apiResponse.toString());

                return apiResponse;
        }

}