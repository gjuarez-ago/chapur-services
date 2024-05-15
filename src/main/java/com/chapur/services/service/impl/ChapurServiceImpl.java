package com.chapur.services.service.impl;

import com.chapur.services.exception.GenericException;
import com.chapur.services.models.migration.ReqBody;
import com.chapur.services.service.IChapurService;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.ContentType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChapurServiceImpl implements IChapurService {

    @Async
    @Override
    public String getPassword(ReqBody reqBody) throws GenericException, IOException {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String nombreMetodo = stackTrace[1].getMethodName();
        log.info(nombreMetodo);
        Request request = Request.post("http://10.2.91.67:8090/servicios-rest-dev7/");
        // POST Body
        String sDatosPeticion = "{\"codigo_tarjeta\":\"" + reqBody.getSTarjeta()
                + "\",\"fechaCorte\":\""
                + reqBody.getFcorte() + "\"}";
        request.bodyString(sDatosPeticion, ContentType.APPLICATION_JSON);

        if (reqBody.getFcorte().isEmpty() || reqBody.getSTarjeta().isEmpty()) {
            throw new GenericException("Uno de los parametros de entrada es nulo o incorrecto");
        }

        return request.execute().returnContent().asString();
    }

}

