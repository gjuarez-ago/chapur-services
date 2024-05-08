package com.chapur.services.controller;

import com.chapur.services.exception.GenericException;
import com.chapur.services.models.Product;
import com.chapur.services.models.ProductType;
import com.chapur.services.models.ProductTypesList;
import com.chapur.services.models.ProductsList;
import com.chapur.services.service.IWalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * The type Product type controller.
 */
@RestController
@RequestMapping("/wallet")
@Slf4j
public class ProductTypeController {

    /**
     * The Wallet service.
     */
    @Autowired
    IWalletService walletService;

    private final int STACK_TRACE_METHOD_INDEX = 1;
    /**
     * The Method name.
     */
    String methodName;

    /**
     * Edit product type string.
     *
     * @param productTypeId the product type id
     * @param productType   the product type
     * @return the string
     * @throws GenericException the generic exception
     */
    @PostMapping(value= "/edit-product-type/{productTypeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String editProductType(@PathVariable("productTypeId") Integer productTypeId, @RequestBody ProductType productType) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.editProductType(productTypeId, productType.getTypeProduct(), productType.getConfig().getShowProductName(),
                productType.getConfig().getShowImage(), productType.getConfig().getShowColor(), productType.getConfig().getShowFolio(),
                productType.getConfig().getShowBalance(), productType.getConfig().getShowCode(), productType.getConfig().getShowCountDownTimer(),
                productType.getConfig().getShowResumeAccount(), productType.getConfig().getShowvigency(), productType.getConfig().getShowMovement());
    }

    /**
     * Gets all product types.
     *
     * @return the all product types
     * @throws GenericException the generic exception
     */
    @GetMapping(value = "/list-all-product-types/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductTypesList getAllProductTypes() throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.getAllProductTypes();
    }

    /**
     * Gets product.
     *
     * @param productId the product id
     * @return the product
     * @throws GenericException the generic exception
     */
    @GetMapping(value = "/get-product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable("productId") Integer productId) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.getProduct(productId);
    }

    /**
     * Add product string.
     *
     * @param product the product
     * @return the string
     * @throws GenericException the generic exception
     */
    @PostMapping(value= "/add-product/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addProduct(@RequestBody Product product) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.addProduct(product.getName(),product.getDescription(), product.getTypeProduct(),
                product.getImage(), product.getReferenceColor());
    }

    /**
     * Edit product string.
     *
     * @param productId the product id
     * @param product   the product
     * @return the string
     * @throws GenericException the generic exception
     */
    @PostMapping(value= "/edit-product/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String editProduct(@PathVariable("productId") Integer productId, @RequestBody Product product) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.editProduct(productId, product.getName(),product.getDescription(), product.getTypeProduct(),
                product.getImage(), product.getReferenceColor());
    }

    /**
     * Delete product string.
     *
     * @param productId the product id
     * @return the string
     * @throws GenericException the generic exception
     */
    @DeleteMapping(value = "/delete-product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteProduct(@PathVariable("productId") Integer productId) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.deleteProduct(productId);
    }

    /**
     * Gets products list.
     *
     * @param clientId the client id
     * @return the products list
     * @throws GenericException the generic exception
     */
    @GetMapping(value = "/products-list/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductsList getProductsList(@PathVariable("clientId") Integer clientId) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.getProductsList(clientId);
    }

    /**
     * Gets product detail.
     *
     * @param clientId    the client id
     * @param productId   the product id
     * @param productType the product type
     * @return the product detail
     * @throws GenericException the generic exception
     */
    @GetMapping(value = "/product-detail/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProductDetail(@RequestBody Integer clientId, @RequestBody Integer productId, @RequestBody String productType) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.getProductDetail(clientId, productId, productType);
    }

    /**
     * Gets product identity.
     *
     * @param clientId    the client id
     * @param productId   the product id
     * @param productType the product type
     * @return the product identity
     * @throws GenericException the generic exception
     */
    @GetMapping(value = "/product-identity/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getProductIdentity(@RequestBody Integer clientId, @RequestBody Integer productId, @RequestBody String productType) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.getProductIdentity(clientId, productId, productType);
    }
}
