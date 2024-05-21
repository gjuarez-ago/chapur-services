package com.chapur.services.service.impl;

import com.chapur.services.models.HttpResponse;
import com.chapur.services.models.ProductTypeDTO;
import com.chapur.services.models.ProductDTO;
import com.chapur.services.models.ProductIdentityResponse;
import com.chapur.services.models.ProductMovementsResponse;
import com.chapur.services.models.ProductSummaryResponse;
import com.chapur.services.models.ProductTypeConfigDTO;
import com.chapur.services.service.IWalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
    public ResponseEntity<HttpResponse> updateProductTypeWeb(ProductTypeDTO productType) {
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
    public ResponseEntity<List<ProductTypeDTO>> getAllProductTypesWeb() {
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
    public ProductDTO getProductWeb(Integer productId) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);

        ProductDTO product = new ProductDTO();

        ProductDTO product1 = new ProductDTO();
        product1.setProductId(1);
        product1.setName("Product A");
        product1.setDescription("Description of Product A");
        product1.setProductType("Type 1");
        product1.setProductFolio("FolioA123");
        product1.setSubType("SubType A");
        product1.setImage("imageA.jpg");
        product1.setReferenceColor("Red");
        product1.setBalance(10.5f);
        product1.setCurrency(1.0f);
        product1.setVigency(365);
        product1.setExpedition(new Date());
        product1.setOrder(1);
        product1.setConfig(createDummyConfig());
        product1.setSummary(createDummySummary());
        product1.setMovements(Arrays.asList(createDummyMovement()));

        return product1;
    }

    /**
     * Agrega un producto a través de la página web.
     *
     * @param product the product
     * @return mensaje indicando el estatus
     */
    @Override
    public ResponseEntity<HttpResponse> addProductWeb(ProductDTO product) {
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
    public ResponseEntity<HttpResponse> updateProductWeb(ProductDTO product) {
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
    public ResponseEntity<HttpResponse> deleteProductWeb(Integer productId) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return response(HttpStatus.OK, "Producto eliminado con exito");
    }

    /**
     * Obtiene la lista de todos los productos del sistema para desplegar en la web.
     *
     * @return la lista de productos del cliente
     */
    @Override
    public ResponseEntity<List<ProductDTO>> getAllProductsWeb() {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        List<ProductDTO> list = getDummyProductList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Obtiene la lista de productos por cliente para desplegar en la app.
     *
     * @param clientId el id del cliente
     * @return la lista de productos del cliente
     */
    @Override
    public ResponseEntity<List<ProductDTO>> getProductsListApp(Integer clientId) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);

        List<ProductDTO> list = getDummyProductList();

        return new ResponseEntity<>(list, HttpStatus.OK);
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
    public ProductDTO getProductDetailApp(Integer clientId, Integer productId, String productType) {
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
    public ProductIdentityResponse getProductIdentityApp(Integer clientId, Integer productId, String productType) {
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

    private static ProductMovementsResponse createDummyMovement() {
        ProductMovementsResponse movement = new ProductMovementsResponse();
        movement.setFolio("Folio123");
        movement.setTotal(100.0f);
        movement.setQuantity(5);
        movement.setDescription("Sample Movement");
        return movement;
    }

    public static List<ProductDTO> getDummyProductList() {
        ProductDTO product1 = new ProductDTO();
        product1.setProductId(1);
        product1.setName("Product A");
        product1.setDescription("Description of Product A");
        product1.setProductType("Type 1");
        product1.setProductFolio("FolioA123");
        product1.setSubType("SubType A");
        product1.setImage("imageA.jpg");
        product1.setReferenceColor("Red");
        product1.setBalance(10.5f);
        product1.setCurrency(1.0f);
        product1.setVigency(365);
        product1.setExpedition(new Date());
        product1.setOrder(1);
        product1.setConfig(createDummyConfig());
        product1.setSummary(createDummySummary());
        product1.setMovements(Arrays.asList(createDummyMovement()));

        ProductDTO product2 = new ProductDTO();
        product2.setProductId(2);
        product2.setName("Product B");
        product2.setDescription("Description of Product B");
        product2.setProductType("Type 2");
        product2.setProductFolio("FolioB456");
        product2.setSubType("SubType B");
        product2.setImage("imageB.jpg");
        product2.setReferenceColor("Blue");
        product2.setBalance(20.0f);
        product2.setCurrency(1.0f);
        product2.setVigency(180);
        product2.setExpedition(new Date());
        product2.setOrder(2);
        product2.setConfig(createDummyConfig());
        product2.setSummary(createDummySummary());
        product2.setMovements(Arrays.asList(createDummyMovement()));

        ProductDTO product3 = new ProductDTO();
        product3.setProductId(3);
        product3.setName("Product C");
        product3.setDescription("Description of Product C");
        product3.setProductType("Type 3");
        product3.setProductFolio("FolioC789");
        product3.setSubType("SubType C");
        product3.setImage("imageC.jpg");
        product3.setReferenceColor("Green");
        product3.setBalance(30.0f);
        product3.setCurrency(1.0f);
        product3.setVigency(90);
        product3.setExpedition(new Date());
        product3.setOrder(3);
        product3.setConfig(createDummyConfig());
        product3.setSummary(createDummySummary());
        product3.setMovements(Arrays.asList(createDummyMovement()));

        return Arrays.asList(product1, product2, product3);
    }

    private static ProductTypeConfigDTO createDummyConfig() {
        ProductTypeConfigDTO config = new ProductTypeConfigDTO();
        config.setShowProductName(true);
        config.setShowImage(true);
        config.setShowColor(true);
        config.setShowFolio(true);
        config.setShowBalance(true);
        config.setShowCode(true);
        config.setShowCountDownTimer(true);
        config.setShowResumeAccount(true);
        config.setShowVigency(true);
        config.setShowMovement(true);
        return config;
    }

    private static ProductSummaryResponse createDummySummary() {
        ProductSummaryResponse summary = new ProductSummaryResponse();
        summary.setProductId(1);
        summary.setProductType("SummaryType");
        summary.setPreviousBalance(50.0f);
        summary.setBalanceReturn(10.0f);
        summary.setSpent(40.0f);
        summary.setBalance(20.0f);
        return summary;
    }

}
