package com.chapur.services.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chapur.services.exception.GenericException;
import com.chapur.services.models.*;
import com.chapur.services.service.IWalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
@Slf4j
public class WalletController {

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
     * <p>
     * Método para realizar la eliminación
     * </p>
     * 
     * @param id del servicio
     * @return un mensaje inidicando el estatus
     * @since 1.0
     */
    @GetMapping(value = "/get-all-services", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CreateServiceDTO>> getAllServicesApp() throws Exception {
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    /**
     * <p>
     * Método para realizar la eliminación
     * </p>
     * 
     * @param id del servicio
     * @return un mensaje inidicando el estatus
     * @since 1.0
     */
    @PostMapping("/add-service")
    private ResponseEntity<HttpResponse> createServiceApp(@RequestBody CreateServiceDTO entity) {
        return response(HttpStatus.OK, "Agregado con exito");
    }

    /**
     * <p>
     * Método para realizar la eliminación
     * </p>
     * 
     * @param id del servicio
     * @return un mensaje inidicando el estatus
     * @since 1.0
     */
    @PutMapping("/update-service/{id}")
    public ResponseEntity<HttpResponse> updateServiceApp(@PathVariable(value = "id") String id,
            @RequestBody CreateServiceDTO entity) {
        return response(HttpStatus.OK, "Actualizado con exito");
    }

    /**
     * <p>
     * Método para realizar la eliminación
     * </p>
     * 
     * @param id del servicio
     * @return un mensaje inidicando el estatus
     * @since 1.0
     */
    @DeleteMapping("/delete-service/{id}")
    public ResponseEntity<HttpResponse> deleteServiceApp(@PathVariable(value = "id") String id) {
        return response(HttpStatus.OK, "Actualizado con exito");
    }

    /**
     * Método para editar el tipo de producto.
     *
     * @param productTypeId id del tipo de producto
     * @param productTypeRequest   informacion del tipo de producto
     * @return mensaje indicando el estatus
     * @throws GenericException the generic exception
     */
    @PostMapping(value= "/edit-product-type/{productTypeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpResponse> editProductType(@PathVariable("productTypeId") Integer productTypeId, @RequestBody ProductTypeDTO productTypeRequest) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.editProductType(productTypeId, productTypeRequest.getTypeProduct(), productTypeRequest.getConfig().getShowProductName(),
                productTypeRequest.getConfig().getShowImage(), productTypeRequest.getConfig().getShowColor(), productTypeRequest.getConfig().getShowFolio(),
                productTypeRequest.getConfig().getShowBalance(), productTypeRequest.getConfig().getShowCode(), productTypeRequest.getConfig().getShowCountDownTimer(),
                productTypeRequest.getConfig().getShowResumeAccount(), productTypeRequest.getConfig().getShowvigency(), productTypeRequest.getConfig().getShowMovement());
    }

    /**
     * Obtener todos los tipos de productos.
     *
     * @return Lista con todos los tipos de productos
     * @throws GenericException the generic exception
     */
    @GetMapping(value = "/list-all-product-types/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductTypeDTO>> getAllProductTypes() throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.getAllProductTypes();
    }

    /**
     * Gets product.
     *
     * @param productId id del prodcuto
     * @return la informacion de producto
     * @throws GenericException the generic exception
     */
    @GetMapping(value = "/get-product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO getProduct(@PathVariable("productId") Integer productId) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.getProduct(productId);
    }

    /**
     * Add product string.
     *
     * @param product la información del producto
     * @return mensaje indicando el estatus del proceso
     * @throws GenericException the generic exception
     */
    @PostMapping(value= "/add-product/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpResponse> addProduct(@RequestBody ProductDTO product) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.addProduct(product.getName(),product.getDescription(), product.getTypeProduct(),
                product.getImage(), product.getReferenceColor());
    }

    /**
     * Edita la información de un producto.
     *
     * @param productId id del producto
     * @param product   informacion del producto a editar
     * @return mensaje indicando el estatus del proceso
     * @throws GenericException the generic exception
     */
    @PostMapping(value= "/edit-product/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpResponse> editProduct(@PathVariable("productId") Integer productId, @RequestBody ProductDTO product) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.editProduct(productId, product.getName(),product.getDescription(), product.getTypeProduct(),
                product.getImage(), product.getReferenceColor());
    }

    /**
     * Elimina un producto.
     *
     * @param productId id del producto
     * @return mensaje indicando el estatus del proceso
     * @throws GenericException the generic exception
     */
    @DeleteMapping(value = "/delete-product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpResponse> deleteProduct(@PathVariable("productId") Integer productId) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.deleteProduct(productId);
    }

    /**
     * Obtener la lista de productos del cliente.
     *
     * @param clientId id del cliente
     * @return lista de productos del cliente
     * @throws GenericException the generic exception
     */
    @GetMapping(value = "/products-list/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDTO>> getProductsList(@PathVariable("clientId") Integer clientId) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.getProductsList(clientId);
    }

    /**
     * Obtener el detalle de producto.
     *
     * @param clientId    id del cliente
     * @param productId   id del producto
     * @param productType tipo de producto
     * @return detalle del producto especificado
     * @throws GenericException the generic exception
     */
    @GetMapping(value = "/product-detail/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO getProductDetail(@RequestBody Integer clientId, @RequestBody Integer productId, @RequestBody String productType) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.getProductDetail(clientId, productId, productType);
    }

    /**
     * Obtener los códigos de identidad del producto.
     *
     * @param clientId    id del cliente
     * @param productId   id del producto
     * @param productType tipo de producto
     * @return los códigos de identificación del producto
     * @throws GenericException the generic exception
     */
    @GetMapping(value = "/product-identity/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductIdentityResponse getProductIdentity(@RequestBody Integer clientId, @RequestBody Integer productId, @RequestBody String productType) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.getProductIdentity(clientId, productId, productType);
    }

    /**
     * <p>
     * Método para realizar la eliminación
     * </p>
     * 
     * @param id del servicio
     * @return un mensaje inidicando el estatus
     * @since 1.0
     */
    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(new Date(), httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),
                        message),
                httpStatus);
    }
}
