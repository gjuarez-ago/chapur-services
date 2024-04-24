package com.chapur.services.controller;

import java.io.IOException;
import java.util.Map;

import com.chapur.services.exception.GenericException;
import com.chapur.services.models.migration.DetOperacion;
import com.chapur.services.models.migration.ReqBody;
import com.chapur.services.service.IChapurService;
import com.chapur.services.service.IRoutingService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/WS/App/Servicio")
public class PccreMigrationController {

    @Autowired
    IChapurService chapurServicio;

    @Autowired
    IRoutingService routingService;

    @Async
    @PostMapping(value = "/Login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String generalLogin(@Validated @RequestBody DetOperacion detOperacion,
            @RequestHeader Map<String, String> headers)
            throws GenericException, IOException {
        String respuesta = "entered detalle tarjeta";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String nombreMetodo = stackTrace[1].getMethodName();
        ReqBody reqBody = detOperacion.getDetOperacionList().get(0);
        headers.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
        return routingService.actionChoiceLogin(reqBody);

    }

}