package com.chapur.services.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
 public  class ChapurEndPoint {

    @Value("${url.security.base}")
    private  String baseUrl;
    @Value("${url.security.get}")
    private  String getUrl;
    @Value("${url.security.post}")
    private  String postUrl;

    //Endpoints for the security service
    @Value("${url.security.getClientBeneficiaries}")
    private  String getClientBeneficiaries;
    @Value("${url.security.generateVerificationCode}")
    private  String generateVerificationCode;
    @Value("${url.security.sendMessage}")
    private  String sendMessage;
    @Value("${url.security.validateVerificationCode}")
    private  String validateVerificationCode;
    @Value("${url.security.assignPin}")
    private  String assignPin;
    @Value("${url.security.validatePin}")
    private  String validatePin;
    @Value("${url.security.getPin}")
    private  String getPin;
    @Value("${url.security.editPin}")
    private  String editPin;
    @Value("${url.security.addPinLog}")
    private  String addPinLog;

   //Endpoints for the wallet service
    @Value("${url.wallet.ProductTypeWeb}")
    private String ProductTypeWeb;
    @Value("${url.wallet.getAllProductTypesWeb}")
    private String getAllProductTypesWeb;
    @Value("${url.wallet.getProductWeb}")
    private String getProductWeb;
    @Value("${url.wallet.addProductWeb}")
    private String addProductWeb;
    @Value("${url.wallet.updateProductWeb}")
    private String updateProductWeb;
    @Value("${url.wallet.deleteProductWeb}")
    private String deleteProductWeb;
    @Value("${url.wallet.getAllProductsWeb}")
    private String getAllProductsWeb;
    @Value("${url.wallet.getProductsListApp}")
    private String getProductsListApp;
    @Value("${url.wallet.getProductDetailApp}")
    private String getProductDetailApp;
    @Value("${url.wallet.getProductIdentityApp}")
    private String getProductIdentityApp;








}

