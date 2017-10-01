package com.n26.ws.services;

import java.util.DoubleSummaryStatistics;

import com.n26.ws.domains.Transaction;
import com.n26.ws.domains.TransactionStatistic;

/**
 * @author abhishekrai
 *
 * @since 0.0.1
 */
public interface StatisticsService {
    void record(Transaction transaction);

    TransactionStatistic getTransactionStatistics();
}
