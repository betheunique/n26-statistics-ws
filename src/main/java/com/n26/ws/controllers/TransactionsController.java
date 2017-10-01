package com.n26.ws.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * End point for each transaction
 * @author abhishekrai
 * @since 0.0.1
 */
@RestController
@RequestMapping("/v1")
public class TransactionsController {


    @RequestMapping("/transaction")
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void recordTransaction() {

    }
}
