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

@RestController
@RequestMapping("/wallet")
public class WalletController {

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
