package com.chapur.services.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chapur.services.exception.GenericException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/wallet")
@Slf4j
public class WalletController {

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAll() throws Exception {
            List<String> items = new ArrayList<String>();

            items.add("Lista 1");
            items.add("Lista 2");
            items.add("Lista 3");
            items.add("Lista 4");

            //Integer.parseInt("null");

            if (!items.isEmpty())
                throw new GenericException("Test");
                // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(items, HttpStatus.OK);
       
    }

    @PostMapping("/PostWallet")
    private ResponseEntity<String> response(@RequestBody String message) {
        log.info("Post wallet " + message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/put-wallet/{id}")
    public ResponseEntity<String> putMethodName(@PathVariable String id, @RequestBody String entity) {
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMethodName(@PathVariable String id) {
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
