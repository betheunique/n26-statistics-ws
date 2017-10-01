package com.n26.ws.domains;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.n26.ws.utils.JsonSnakeStretegy;
import com.n26.ws.validation.WithinLast;
import org.immutables.value.Value;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author abhishekrai
 *
 * @since 0.0.1
 */
@Value.Immutable
@JsonSnakeStretegy
@JsonSerialize(as = ImmutableTransaction.class)
@JsonDeserialize(as = ImmutableTransaction.class)
public interface Transaction {

    @Min(0)
    @Value.Parameter
    double getAmount();

    @Value.Parameter
    @WithinLast(duration = 60, unit = SECONDS)
    long getTimestamp();
}
