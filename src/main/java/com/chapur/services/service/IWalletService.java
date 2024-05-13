package com.chapur.services.service;

import com.chapur.services.models.HttpResponse;
import com.chapur.services.models.ProductTypeDTO;
import com.chapur.services.models.ProductDTO;
import com.chapur.services.models.ProductIdentityResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Wallet service.
 */
@Component
public interface IWalletService {
    /**
     * Edita un tipo de producto para la página web.
     *
     * @param productType el tipo de producto
     * @return mensaje indicando el estatus
     */
    ResponseEntity<HttpResponse> updateProductTypeWeb(ProductTypeDTO productType);

    /**
     * Obtiene todos los tipos de productos para la página web.
     *
     * @return todos los tipos de productos
     */
    ResponseEntity<List<ProductTypeDTO>> getAllProductTypesWeb();

    /**
     * Obtiene un solo producto para desplegarlo en la página web.
     *
     * @param productId el id del producto
     * @return el producto
     */
    ProductDTO getProductWeb(Integer productId);

    /**
     * Agrega un producto a través de la página web.
     *
     * @param product the product
     * @return mensaje indicando el estatus
     */
    ResponseEntity<HttpResponse> addProductWeb(ProductDTO product);

    /**
     * Edita un producto a través de la página web.
     *
     * @param product the product
     * @return mensaje indicando el estatus
     */
    ResponseEntity<HttpResponse> updateProductWeb(ProductDTO product);

    /**
     * Elimina un producto a través de la página web.
     *
     * @param productId el id del producto
     * @return mensaje indicando el estatus
     */
    ResponseEntity<HttpResponse> deleteProductWeb(Integer productId);

    /**
     * Obtiene la lista de todos los productos del sistema para desplegar en la web.
     *
     * @return la lista de productos del cliente
     */
    ResponseEntity<List<ProductDTO>> getAllProductsWeb();

    /**
     * Obtiene la lista de productos por cliente para desplegar en la app.
     *
     * @param clientId el id del cliente
     * @return la lista de productos del cliente
     */
    ResponseEntity<List<ProductDTO>> getProductsListApp(Integer clientId);

    /**
     * Obtiene el detalle de producto para desplegar en la app.
     *
     * @param clientId    el id del cliente
     * @param productId   el id del producto
     * @param productType el tipo de producto
     * @return detalle del producto
     */
    ProductDTO getProductDetailApp(Integer clientId, Integer productId, String productType);

    /**
     * Obtiene los códigos del producto para desplegar en la app.
     *
     * @param clientId    el id del cliente
     * @param productId   el id del producto
     * @param productType el tipo de producto
     * @return los códigos de identidad del producto
     */
    ProductIdentityResponse getProductIdentityApp(Integer clientId, Integer productId, String productType);
}