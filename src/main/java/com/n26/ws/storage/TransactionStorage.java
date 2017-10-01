package com.n26.ws.storage;

import java.util.DoubleSummaryStatistics;
import java.util.function.UnaryOperator;

/**
 *
 * @author abhishekrai
 *
 * @since 0.0.1
 */
public interface TransactionStorage<T> {
    void update(long timestamp, UnaryOperator<T> updater);

    DoubleSummaryStatistics getStatistics();

}
