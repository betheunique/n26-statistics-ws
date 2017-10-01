package com.n26.ws.controllers;

import com.n26.ws.domains.TransactionStatistic;
import com.n26.ws.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author abhishekrai
 *
 * @since 0.0.1
 */
@RestController
public class StatisticsController {

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET, produces = "application/json")
    public TransactionStatistic getTransactionStatistics() {
        return statisticsService.getTransactionStatistics();
    }
}
