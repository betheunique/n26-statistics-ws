package com.n26.ws.services.impl;

import java.util.DoubleSummaryStatistics;

import com.n26.ws.domains.Transaction;
import com.n26.ws.services.StatisticsService;
import com.n26.ws.storage.AtomicTransactionStorage;
import com.n26.ws.storage.TransactionStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * implementation of {@link StatisticsService}
 *
 * @author abhishekrai
 *
 * @since 0.0.1
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final TransactionStorage<Double> transactions;

    @Autowired
    public StatisticsServiceImpl() {
        this(AtomicTransactionStorage.initialize(() -> 0.0));
    }

    protected StatisticsServiceImpl(TransactionStorage<Double> transactions) {
        this.transactions = transactions;
    }

    @Override
    public void record(Transaction transaction) {
        transactions.update(transaction.getTimestamp(),
                            (t) -> transaction.getAmount());
    }

    @Override
    public DoubleSummaryStatistics getTransactionStatistics() {
        return transactions.getStatistics();
    }
}
