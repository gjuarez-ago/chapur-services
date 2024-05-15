package com.chapur.services.models;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;


import java.io.IOException;

public class ResponseClient implements HttpClientResponseHandler<String> {
    @Override
    public String handleResponse(ClassicHttpResponse classicHttpResponse) throws HttpException, IOException {
        int status = classicHttpResponse.getCode();
        if (status >= 200 && status < 300) {

            return EntityUtils.toString(classicHttpResponse.getEntity());
        } else {
            throw new IOException("Unexpected response status: " + status);
        }
    }
}
