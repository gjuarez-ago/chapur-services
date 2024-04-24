package com.chapur.services.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAll() {
        try {
            List<String> items = new ArrayList<String>();

            items.add("Lista 1");
            items.add("Lista 2");
            items.add("Lista 3");
            items.add("Lista 4");

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
