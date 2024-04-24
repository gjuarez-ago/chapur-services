package com.chapur.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chapur.services.service.IChapurService;
import com.chapur.services.service.IRoutingService;

import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.util.Map;

import com.chapur.services.exception.GenericException;
import com.chapur.services.models.migration.ReqBody;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.ContentType;
import org.springframework.scheduling.annotation.Async;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Slf4j
public class RoutingService implements IRoutingService {

    @Autowired
    IChapurService chapurServicio;

    @Async
    @Override
    public String redirectPost(Map<String, String> headers, ReqBody reqBody, String URI)
            throws JsonProcessingException {
        String response = "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String nombreMetodo = stackTrace[1].getMethodName();

        log.info(nombreMetodo);
        Request request = Request.post(URI);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonDetOperacion = objectMapper.writeValueAsString(reqBody);

        request.bodyString(jsonDetOperacion, ContentType.APPLICATION_JSON);

        request.addHeader("testauth", headers.get("testauth"));

        try {

            response = request.execute().returnContent().asString();

        }

        catch (IOException e) {
            String errorMessage = "Error en ChapurServicio. Metodo: " + nombreMetodo + " Error: " + e.getMessage();
            System.out.println(errorMessage);
            response = errorMessage;
        }

        return response;
    }

    @Override
    public String actionChoiceLogin(ReqBody reqBody) throws GenericException, IOException {
        String respuesta = "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String nombreMetodo = stackTrace[1].getMethodName();
        log.info(nombreMetodo);
        if (reqBody.getSOperacion() == null || reqBody.getSOperacion().isEmpty()) {
            throw new GenericException("sOperacion es nulo");
        }

        else {
            switch (reqBody.getSOperacion()) {
                case "recupera_cont":
                    respuesta = chapurServicio.getPassword(reqBody);
                    break;
                default:
                    break;
            }
        }

        return respuesta;
    }

}