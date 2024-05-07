package com.chapur.services.controller;

import com.chapur.services.exception.GenericException;
import com.chapur.services.models.ReqBodySecurity;
import com.chapur.services.models.migration.DetOperacion;
import com.chapur.services.models.migration.ReqBody;
import com.chapur.services.service.impl.ChapurServiceImpl;
import com.chapur.services.service.impl.SecurityServiceImpl;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/api/security")
@Slf4j
public class SecurityController {


    @Autowired
    SecurityServiceImpl securityService;

    private final int STACK_TRACE_METHOD_INDEX=1;
    String methodName ;
    /**
     * Detalle tarjeta string.
     *
     * @param clientId Parametro que almacena el id del cliente
     * @return response regresa el objeto de respuesta
     * @throws GenericException regresa un json string con la informacion del error en caso de que se genera alguna exception
     */

    @GetMapping(value="/client-beneficiaries/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getClientBeneficiaries(@PathVariable("clientId") String clientId) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return securityService.getClientBeneficiaries(clientId);

    }


    @PostMapping(value="/generate-verification-code/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String generateVerificationCode(@PathVariable("clientId") String clientId) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return securityService.generateVerificationCode(clientId);
    }

    @PostMapping(value="/send-message/{clientId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendMessage(@PathVariable("clientId") String clientId, @RequestBody ReqBodySecurity reqBodySecurity) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return securityService.sendMessage(reqBodySecurity.getClientId(), reqBodySecurity.getContactMethod(),
                                            reqBodySecurity.getMessageType(),reqBodySecurity.getMessageContent());
    }

    @PostMapping(value="/validate-verification-code", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String validateVerificationCode(@RequestBody ReqBodySecurity reqBodySecurity) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return  securityService.validateVerificationCode(reqBodySecurity.getVerificationCode());
    }

    @PostMapping(value="/assign-pin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String assignPin(@RequestBody ReqBodySecurity reqBodySecurity) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return securityService.assignPin(reqBodySecurity.getPin(),reqBodySecurity.getClientId(),reqBodySecurity.getCardId());
    }

    @PostMapping(value="/validate-pin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String validatePin(@RequestBody ReqBodySecurity reqBodySecurity) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return  securityService.validatePin(reqBodySecurity.getPin(),reqBodySecurity.getClientId(),reqBodySecurity.getCardId());
    }

//    @PostMapping(value="/get-pin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public String getPin(@RequestBody ReqBodySecurity reqBodySecurity) throws GenericException {
//        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
//        log.info("Executing endpoint method: "+methodName+" from class: "+getClass().getName());
//        String response = methodName;
//        return  response;
//    }

    @PostMapping(value="/edit-pin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String editPin(@RequestBody ReqBodySecurity reqBodySecurity) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return securityService.editPin(reqBodySecurity.getPin(),reqBodySecurity.getClientId(),reqBodySecurity.getCardId());
    }

    @PostMapping(value="/add-pin-log", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addPinLog(@RequestBody ReqBodySecurity reqBodySecurity) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        String response = "{\"methodName\":\""+methodName+"\"}";
        return  securityService.addPinLog(reqBodySecurity.getClientId(),
                                            reqBodySecurity.getCardId(),
                                            reqBodySecurity.getMovementType(),
                                            LocalDateTime.now(),
                                            reqBodySecurity.getUser(),
                                            reqBodySecurity.getSource());
    }


}