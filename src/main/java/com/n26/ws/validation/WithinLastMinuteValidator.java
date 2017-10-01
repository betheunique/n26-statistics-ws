package com.n26.ws.validation;

import java.time.Duration;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author abhishekrai
 * @since 0.0.1
 */
public class WithinLastMinuteValidator implements ConstraintValidator<WithinLast, Long> {

    private static Supplier<Long> CURRENT_MILLIS = System::currentTimeMillis;

    private WithinLast annotation;

    @Override
    public void initialize(WithinLast annotation) {
        this.annotation = annotation;
    }

    @Override
    public boolean isValid(@Nullable Long value, ConstraintValidatorContext context) {
        Duration age = Duration.of(annotation.duration(), annotation.unit());
        return value == null || CURRENT_MILLIS.get() - value <= age.toMillis();
    }
}
