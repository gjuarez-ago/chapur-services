package com.chapur.services.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chapur.services.exception.GenericException;
import com.chapur.services.models.HttpResponse;
import com.chapur.services.models.CreateServiceDTO;
import com.chapur.services.models.ProductTypeDTO;
import com.chapur.services.models.ProductDTO;
import com.chapur.services.models.ProductIdentityResponse;
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
     * Método para obtener todos los servicios Chapur
     * </p>
     *
     * @return un mensaje indicando el estatus
     * @since 1.0
     */
    @GetMapping(value = "/get-all-services", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CreateServiceDTO>> getAllServicesApp() throws Exception {
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    /**
     * <p>
     * Método para realizar la actualización de un servicio Chapur
     * </p>
     * 
     * @param id del servicio
     * @return un mensaje indicando el estatus
     * @since 1.0
     */
    @PutMapping("/update-service/{id}")
    public ResponseEntity<HttpResponse> updateServiceApp(@PathVariable(value = "id") String id,
            @RequestBody CreateServiceDTO entity) {
        return response(HttpStatus.OK, "Actualizado con exito");
    }

    /**
     * <p>
     * Método para obtener un servicio de acuerdo al id
     * </p>
     *
     * @param id del servicio
     * @return un mensaje indicando el estatus
     * @since 1.0
     */
    @GetMapping(value = "/get-service/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateServiceDTO> getServiceWeb(@PathVariable(value = "id") String id) throws Exception {
        return new ResponseEntity<>(new CreateServiceDTO(), HttpStatus.OK);
    }

    /**
     * Método para editar el tipo de producto.
     *
     * @param productTypeId id del tipo de producto
     * @param productType   informacion del tipo de producto
     * @return mensaje indicando el estatus
     * @throws GenericException the generic exception
     */
    @PutMapping(value= "/update-product-type/{productTypeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpResponse> updateProductTypeWeb(@PathVariable("productTypeId") Integer productTypeId,
             @RequestBody ProductTypeDTO productType) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.updateProductTypeWeb(productType);
    }

    /**
     * Obtener todos los tipos de productos.
     *
     * @return Lista con todos los tipos de productos
     * @throws GenericException the generic exception
     */
    @GetMapping(value = "/list-all-product-types/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductTypeDTO>> getAllProductTypesWeb() throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.getAllProductTypesWeb();
    }

    /**
     * Gets product.
     *
     * @param productId id del prodcuto
     * @return la informacion de producto
     * @throws GenericException the generic exception
     */
    @GetMapping(value = "/get-product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO getProductWeb(@PathVariable("productId") Integer productId) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.getProductWeb(productId);
    }

    /**
     * Add product string.
     *
     * @param product la información del producto
     * @return mensaje indicando el estatus del proceso
     * @throws GenericException the generic exception
     */
    @PostMapping(value= "/add-product/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpResponse> addProductWeb(@RequestBody ProductDTO product) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.addProductWeb(product);
    }

    /**
     * Edita la información de un producto.
     *
     * @param productId id del producto
     * @param product   informacion del producto a editar
     * @return mensaje indicando el estatus del proceso
     * @throws GenericException the generic exception
     */
    @PutMapping(value= "/update-product/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpResponse> updateProductWeb(@PathVariable("productId") Integer productId,
             @RequestBody ProductDTO product) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.updateProductWeb(product);
    }

    /**
     * Elimina un producto.
     *
     * @param productId id del producto
     * @return mensaje indicando el estatus del proceso
     * @throws GenericException the generic exception
     */
    @DeleteMapping(value = "/delete-product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpResponse> deleteProductWeb(@PathVariable("productId") Integer productId) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.deleteProductWeb(productId);
    }

    /**
     * Obtener la lista de productos del cliente.
     *
     * @param clientId id del cliente
     * @return lista de productos del cliente
     * @throws GenericException the generic exception
     */
    @GetMapping(value = "/products-list/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDTO>> getProductsListApp(@PathVariable("clientId") Integer clientId) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.getProductsListApp(clientId);
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
    public ProductDTO getProductDetailApp(@RequestBody Integer clientId, @RequestBody Integer productId,
            @RequestBody String productType) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.getProductDetailApp(clientId, productId, productType);
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
    public ProductIdentityResponse getProductIdentityApp(@RequestBody Integer clientId,
             @RequestBody Integer productId, @RequestBody String productType) throws GenericException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return walletService.getProductIdentityApp(clientId, productId, productType);
    }

    /**
     * <p>
     * Método para formar respuestas de los servicios
     * </p>
     *
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
