package com.chapur.services.service;

import com.chapur.services.exception.GenericException;
import com.chapur.services.models.migration.ReqBody;

import java.io.IOException;

public interface IChapurService {

    String getPassword(ReqBody reqBody) throws GenericException, IOException;

}