package com.chapur.services.service.impl;

import com.chapur.services.models.ResponseClient;
import com.chapur.services.service.ISecurityService;
import com.chapur.services.utils.ChapurEndPoint;
import com.chapur.services.utils.twitterTestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.protocol.HttpClientContext;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

/**
 * The type Security service.
 */
@Service
@Slf4j
public class SecurityServiceImpl implements ISecurityService {

    private final int STACK_TRACE_METHOD_INDEX = 1;
    @Autowired
    ChapurEndPoint chapurEndPoint;

    /**
     * The Method name.
     */
    String methodName;
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpClientContext httpClientContext = HttpClientContext.create();
    HttpPost httpPost = null;
    HttpGet httpGet = null;
    ObjectMapper objectMapper = new ObjectMapper();
    URIBuilder uriBuilder = null;



    @Override
    public String getClientBeneficiaries(String clientId) throws URISyntaxException, IOException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        String logMessage = "Executing Method: " + methodName;
        log.info(logMessage);
        uriBuilder = new URIBuilder(chapurEndPoint.getBaseUrl()+chapurEndPoint.getGetUrl());
        uriBuilder.setParameter("user_id","96479162");
        uriBuilder.setParameter("limit","40");
        httpGet = new HttpGet( uriBuilder.build());
        httpGet.setHeader("X-RapidAPI-Key","dc4d6c3056mshd90cf356187019ap1f84a1jsn455b9363e4ba");
        httpGet.setHeader("X-RapidAPI-Host","twitter154.p.rapidapi.com");
        System.out.println(uriBuilder.build().toString());
        return  httpclient.execute(httpGet, httpClientContext, new ResponseClient());
    }

    @Override
    public String getPin(String clientId, String lastFourDigits) throws URISyntaxException, IOException  {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        String logMessage = "Executing Method: " + methodName;
        log.info(logMessage);
        uriBuilder = new URIBuilder(chapurEndPoint.getBaseUrl()+chapurEndPoint.getGetPin());
        uriBuilder.setParameter("user_id","96479162");
        uriBuilder.setParameter("limit","40");
        httpGet = new HttpGet( uriBuilder.build());
        httpGet.setHeader("X-RapidAPI-Key","dc4d6c3056mshd90cf356187019ap1f84a1jsn455b9363e4ba");
        httpGet.setHeader("X-RapidAPI-Host","twitter154.p.rapidapi.com");
        System.out.println(uriBuilder.build().toString());
        return  httpclient.execute(httpGet, httpClientContext, new ResponseClient());
    }

    @Override
    public String editPin(String newPin, String clientId, String cardId)  throws URISyntaxException, IOException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        String logMessage = "Executing Method: " + methodName;
        log.info(logMessage);
        return "{\"methodName\":\"" + methodName + "\"}";
    }

    @Override
    public String generateVerificationCode(String clientId)  throws URISyntaxException, IOException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        String logMessage = "Executing Method: " + methodName;
        log.info(logMessage);
        uriBuilder = new URIBuilder(chapurEndPoint.getBaseUrl()+chapurEndPoint.getGenerateVerificationCode());
        httpPost = new HttpPost( uriBuilder.build());
        httpPost.setHeader("X-RapidAPI-Key","dc4d6c3056mshd90cf356187019ap1f84a1jsn455b9363e4ba");
        httpPost.setHeader("X-RapidAPI-Host","twitter154.p.rapidapi.com");
        httpPost.setHeader("Content-Type", "application/json");
        twitterTestData testData = new twitterTestData("omarmhaimdat","96479162");
        String jsonBody = objectMapper.writeValueAsString(testData);
        httpPost.setEntity(new StringEntity(jsonBody));
        return  httpclient.execute(httpPost, httpClientContext, new ResponseClient());
    }

    @Override
    public String sendMessage(String clientId, String contactMethod, String messageType, String messageContent)  throws URISyntaxException, IOException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        String logMessage = "Executing Method: " + methodName;
        log.info(logMessage);
        uriBuilder = new URIBuilder(chapurEndPoint.getBaseUrl()+chapurEndPoint.getSendMessage());
        httpPost = new HttpPost( uriBuilder.build());
        httpPost.setHeader("X-RapidAPI-Key","dc4d6c3056mshd90cf356187019ap1f84a1jsn455b9363e4ba");
        httpPost.setHeader("X-RapidAPI-Host","twitter154.p.rapidapi.com");
        httpPost.setHeader("Content-Type", "application/json");
        twitterTestData testData = new twitterTestData("omarmhaimdat","96479162");
        String jsonBody = objectMapper.writeValueAsString(testData);
        httpPost.setEntity(new StringEntity(jsonBody));
        return  httpclient.execute(httpPost, httpClientContext, new ResponseClient());
    }

    @Override
    public String validateVerificationCode(String clientId,String verificationCode)  throws URISyntaxException, IOException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        String logMessage = "Executing Method: " + methodName;
        log.info(logMessage);
        uriBuilder = new URIBuilder(chapurEndPoint.getBaseUrl()+chapurEndPoint.getValidateVerificationCode());
        httpPost = new HttpPost( uriBuilder.build());
        httpPost.setHeader("X-RapidAPI-Key","dc4d6c3056mshd90cf356187019ap1f84a1jsn455b9363e4ba");
        httpPost.setHeader("X-RapidAPI-Host","twitter154.p.rapidapi.com");
        httpPost.setHeader("Content-Type", "application/json");
        twitterTestData testData = new twitterTestData("omarmhaimdat","96479162");
        String jsonBody = objectMapper.writeValueAsString(testData);
        httpPost.setEntity(new StringEntity(jsonBody));
        return  httpclient.execute(httpPost, httpClientContext, new ResponseClient());
    }

    @Override
    public String assignPin(String pin, String clientId, String cardId) throws URISyntaxException, IOException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        String logMessage = "Executing Method: " + methodName;
        log.info(logMessage);
        uriBuilder = new URIBuilder(chapurEndPoint.getBaseUrl()+chapurEndPoint.getAssignPin());
        httpPost = new HttpPost( uriBuilder.build());
        httpPost.setHeader("X-RapidAPI-Key","dc4d6c3056mshd90cf356187019ap1f84a1jsn455b9363e4ba");
        httpPost.setHeader("X-RapidAPI-Host","twitter154.p.rapidapi.com");
        httpPost.setHeader("Content-Type", "application/json");
        twitterTestData testData = new twitterTestData("omarmhaimdat","96479162");
        String jsonBody = objectMapper.writeValueAsString(testData);
        httpPost.setEntity(new StringEntity(jsonBody));
        return  httpclient.execute(httpPost, httpClientContext, new ResponseClient());
    }

    @Override
    public String validatePin(String pin, String clientId, String cardId) throws URISyntaxException, IOException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        String logMessage = "Executing Method: " + methodName;
        log.info(logMessage);
        uriBuilder = new URIBuilder(chapurEndPoint.getBaseUrl()+chapurEndPoint.getValidatePin());
        httpPost = new HttpPost( uriBuilder.build());
        httpPost.setHeader("X-RapidAPI-Key","dc4d6c3056mshd90cf356187019ap1f84a1jsn455b9363e4ba");
        httpPost.setHeader("X-RapidAPI-Host","twitter154.p.rapidapi.com");
        httpPost.setHeader("Content-Type", "application/json");
        twitterTestData testData = new twitterTestData("omarmhaimdat","96479162");
        String jsonBody = objectMapper.writeValueAsString(testData);
        httpPost.setEntity(new StringEntity(jsonBody));
        return  httpclient.execute(httpPost, httpClientContext, new ResponseClient());
    }



    @Override
    public String addPinLog(String clientId, String cardId, String movementType, LocalDateTime date, String user,
            String source) throws URISyntaxException, IOException  {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        String logMessage = "Executing Method: " + methodName;
        log.info(logMessage);
        uriBuilder = new URIBuilder(chapurEndPoint.getBaseUrl()+chapurEndPoint.getAddPinLog());
        httpPost = new HttpPost( uriBuilder.build());
        httpPost.setHeader("X-RapidAPI-Key","dc4d6c3056mshd90cf356187019ap1f84a1jsn455b9363e4ba");
        httpPost.setHeader("X-RapidAPI-Host","twitter154.p.rapidapi.com");
        httpPost.setHeader("Content-Type", "application/json");
        twitterTestData testData = new twitterTestData("omarmhaimdat","96479162");
        String jsonBody = objectMapper.writeValueAsString(testData);
        httpPost.setEntity(new StringEntity(jsonBody));
        return  httpclient.execute(httpPost, httpClientContext, new ResponseClient());
    }
}
