package com.chapur.services.service;

import java.io.IOException;
import java.util.Map;

import com.chapur.services.exception.GenericException;
import com.chapur.services.models.migration.ReqBody;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface IRoutingService {

    String redirectPost(Map<String, String> headers, ReqBody reqBody, String URI) throws JsonProcessingException;

    String actionChoiceLogin(ReqBody reqBody) throws GenericException, IOException;

}
