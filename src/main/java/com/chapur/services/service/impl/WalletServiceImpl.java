package com.chapur.services.service.impl;

import com.chapur.services.models.HttpResponse;
import com.chapur.services.models.ProductTypeDTO;
import com.chapur.services.models.ProductDTO;
import com.chapur.services.models.ProductIdentityResponse;
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

    /**
     * Edita un tipo de producto para la página web.
     *
     * @param productType el tipo de producto
     * @return mensaje indicando el estatus
     */
    @Override
    public ResponseEntity<HttpResponse> updateProductTypeWeb(ProductTypeDTO productType){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return response(HttpStatus.OK, "Tipo de producto editado con exito");
    }

    /**
     * Obtiene todos los tipos de productos para la página web.
     *
     * @return todos los tipos de productos
     */
    @Override
    public ResponseEntity<List<ProductTypeDTO>> getAllProductTypesWeb(){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return new ResponseEntity<>(new ArrayList<ProductTypeDTO>(), HttpStatus.OK);
    }

    /**
     * Obtiene un solo producto para desplegarlo en la página web.
     *
     * @param productId el id del producto
     * @return el producto
     */
    @Override
    public ProductDTO getProductWeb(Integer productId){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        ProductDTO product = new ProductDTO();
        return product;
    }

    /**
     * Agrega un producto a través de la página web.
     *
     * @param product the product
     * @return mensaje indicando el estatus
     */
    @Override
    public ResponseEntity<HttpResponse> addProductWeb(ProductDTO product){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return response(HttpStatus.OK, "Producto agregado con exito");
    }

    /**
     * Edita un producto a través de la página web.
     *
     * @param product the product
     * @return mensaje indicando el estatus
     */
    @Override
    public ResponseEntity<HttpResponse> updateProductWeb(ProductDTO product){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return response(HttpStatus.OK, "Producto editado con exito");
    }

    /**
     * Elimina un producto a través de la página web.
     *
     * @param productId el id del producto
     * @return mensaje indicando el estatus
     */
    @Override
    public ResponseEntity<HttpResponse> deleteProductWeb(Integer productId){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return response(HttpStatus.OK, "Producto eliminado con exito");
    }

    /**
     * Obtiene la lista de productos por cliente para desplegar en la app.
     *
     * @param clientId el id del cliente
     * @return la lista de productos del cliente
     */
    @Override
    public ResponseEntity<List<ProductDTO>> getProductsListApp(Integer clientId){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return new ResponseEntity<>(new ArrayList<ProductDTO>(), HttpStatus.OK);
    }

    /**
     * Obtiene el detalle de producto para desplegar en la app.
     *
     * @param clientId    el id del cliente
     * @param productId   el id del producto
     * @param productType el tipo de producto
     * @return detalle del producto
     */
    @Override
    public ProductDTO getProductDetailApp(Integer clientId, Integer productId, String productType){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        ProductDTO product = new ProductDTO();
        return product;
    }

    /**
     * Obtiene los códigos del producto para desplegar en la app.
     *
     * @param clientId    el id del cliente
     * @param productId   el id del producto
     * @param productType el tipo de producto
     * @return los códigos de identidad del producto
     */
    @Override
    public ProductIdentityResponse getProductIdentityApp(Integer clientId, Integer productId, String productType){
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
