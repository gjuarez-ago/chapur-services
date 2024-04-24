package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class HttpResponse {

    private final Logger logger = LoggerFactory.getLogger(HttpResponse.class);
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss", timezone = "America/New_York")
    private Date timeStamp;

    private int httpStatusCode; // 200, 201, 400, 500
    private HttpStatus httpStatus;
    private String reason;
    private String message;

}