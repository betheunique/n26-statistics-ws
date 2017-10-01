package com.n26.ws.controllers;

import javax.validation.Valid;

import com.n26.ws.domains.Transaction;
import com.n26.ws.services.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    private final StatisticsService statisticsService;

    @Autowired
    public TransactionsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }


    @RequestMapping("/transactions")
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void recordTransaction(@Valid @RequestBody Transaction transaction) {
        statisticsService.record(transaction);
    }
}
