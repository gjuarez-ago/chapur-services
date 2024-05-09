package com.chapur.services.service.impl;

import com.chapur.services.models.HttpResponse;
import com.chapur.services.models.ProductDTO;
import com.chapur.services.models.ProductIdentityResponse;
import com.chapur.services.models.ProductTypeDTO;
import com.chapur.services.service.IWalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Wallet service.
 */
@Service
@Slf4j
public class WalletServiceImpl implements IWalletService {

    private final int STACK_TRACE_METHOD_INDEX = 1;

    /**
     * The Method name.
     */
    String methodName;

    @Override
    public ResponseEntity<HttpResponse> editProductType(Integer productTypeId, String typeProduct, Boolean showProductName,
                                                        Boolean showImage, Boolean showColor, Boolean showFolio, Boolean showBalance,
                                                        Boolean showCode, Boolean showCountDownTimer, Boolean showResumeAccount,
                                                        Boolean showvigency, Boolean showMovement){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return response(HttpStatus.OK, "Tipo de producto editado con exito");
    }

    @Override
    public ResponseEntity<List<ProductTypeDTO>> getAllProductTypes(){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return new ResponseEntity<>(new ArrayList<ProductTypeDTO>(), HttpStatus.OK);
    }

    @Override
    public ProductDTO getProduct(Integer productId){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        ProductDTO product = new ProductDTO();
        return product;
    }

    @Override
    public ResponseEntity<HttpResponse> addProduct(String name, String description, String typeProduct, String image, String referenceColor){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return response(HttpStatus.OK, "Producto agregado con exito");
    }

    @Override
    public ResponseEntity<HttpResponse> editProduct(Integer productId, String name, String description, String typeProduct, String image, String referenceColor){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return response(HttpStatus.OK, "Producto editado con exito");
    }

    @Override
    public ResponseEntity<HttpResponse> deleteProduct(Integer productId){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return response(HttpStatus.OK, "Producto eliminado con exito");
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getProductsList(Integer clientId){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return new ResponseEntity<>(new ArrayList<ProductDTO>(), HttpStatus.OK);
    }

    @Override
    public ProductDTO getProductDetail(Integer clientId, Integer productId, String productType){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        ProductDTO product = new ProductDTO();
        return product;
    }

    @Override
    public ProductIdentityResponse getProductIdentity(Integer clientId, Integer productId, String productType){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        ProductIdentityResponse productIdentity = new ProductIdentityResponse();
        return productIdentity;
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(new Date(), httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),
                        message),
                httpStatus);
    }
}
