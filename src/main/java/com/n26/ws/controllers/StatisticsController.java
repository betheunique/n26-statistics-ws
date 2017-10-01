package com.n26.ws.controllers;

import java.util.DoubleSummaryStatistics;

import com.n26.ws.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @RequestMapping("/statistics")
    @GetMapping(produces = "application/json")
    public DoubleSummaryStatistics getTransactionStatistics() {
        return statisticsService.getTransactionStatistics();
    }
}
