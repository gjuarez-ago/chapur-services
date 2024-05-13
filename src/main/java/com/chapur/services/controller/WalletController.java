package com.chapur.services.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

import com.chapur.services.models.CreateServiceDTO;
import com.chapur.services.models.HttpResponse;

/**
 * The type Wallet controller.
 */
@RestController
@RequestMapping("/wallet")
public class WalletController {


    /**
     * Gets all services app.
     *
     * @return the all services app
     * @throws Exception the exception
     */
    @GetMapping(value = "/get-all-services", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CreateServiceDTO>> getAllServicesApp() throws Exception {
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }


    @PostMapping("/add-service")
    private ResponseEntity<HttpResponse> createServiceApp(@RequestBody CreateServiceDTO entity) {
        return response(HttpStatus.OK, "Agregado con exito");
    }


    /**
     * Update service app response entity.
     *
     * @param id     the id
     * @param entity the entity
     * @return the response entity
     */
    @PutMapping("/update-service/{id}")
    public ResponseEntity<HttpResponse> updateServiceApp(@PathVariable(value = "id") String id,
            @RequestBody CreateServiceDTO entity) {
        return response(HttpStatus.OK, "Actualizado con exito");
    }


    /**
     * Delete service app response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/delete-service/{id}")
    public ResponseEntity<HttpResponse> deleteServiceApp(@PathVariable(value = "id") String id) {
        return response(HttpStatus.OK, "Actualizado con exito");
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(new Date(), httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),
                        message),
                httpStatus);
    }

}
