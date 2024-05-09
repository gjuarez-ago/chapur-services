package com.chapur.services.service;

import com.chapur.services.models.HttpResponse;
import com.chapur.services.models.ProductDTO;
import com.chapur.services.models.ProductIdentityResponse;
import com.chapur.services.models.ProductTypeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IWalletService {
    ResponseEntity<HttpResponse> editProductType(Integer productTypeId, String typeProduct, Boolean showProductName,
                                                 Boolean showImage, Boolean showColor, Boolean showFolio, Boolean showBalance,
                                                 Boolean showCode, Boolean showCountDownTimer, Boolean showResumeAccount,
                                                 Boolean showvigency, Boolean showMovement);

    ResponseEntity<List<ProductTypeDTO>> getAllProductTypes();

    ProductDTO getProduct(Integer productId);

    ResponseEntity<HttpResponse> addProduct(String name, String description, String typeProduct, String image, String referenceColor);

    ResponseEntity<HttpResponse> editProduct(Integer productId, String name, String description, String typeProduct, String image, String referenceColor);

    ResponseEntity<HttpResponse> deleteProduct(Integer productId);

    ResponseEntity<List<ProductDTO>> getProductsList(Integer clientId);

    ProductDTO getProductDetail(Integer clientId, Integer productId, String productType);

    ProductIdentityResponse getProductIdentity(Integer clientId, Integer productId, String productType);
}