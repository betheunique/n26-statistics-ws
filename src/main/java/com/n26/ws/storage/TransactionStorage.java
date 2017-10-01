package com.n26.ws.storage;

import java.util.DoubleSummaryStatistics;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import com.n26.ws.domains.TransactionStatistic;

/**
 *
 * @author abhishekrai
 *
 * @since 0.0.1
 */
public interface TransactionStorage<T> {
    void update(long timestamp, UnaryOperator<T> updater);

    T getStatistics(BinaryOperator<T> reducer);

}
