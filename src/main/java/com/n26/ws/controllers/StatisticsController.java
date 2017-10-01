package com.n26.ws.controllers;

import java.util.DoubleSummaryStatistics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author abhishekrai
 *
 * @since 0.0.1
 */
@RestController
@RequestMapping("/v1")
public class StatisticsController {

    @RequestMapping("/statistics")
    @GetMapping(produces = "application/json")
    public DoubleSummaryStatistics getTransactionStatistics() {
        // TODO :: implementation
        return new DoubleSummaryStatistics();
    }
}
