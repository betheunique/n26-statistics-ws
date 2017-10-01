package com.n26.ws.validation;


public interface ClassCasts {

    @SuppressWarnings("unchecked")
    static <T> Class<T> cast(Class<?> target) {
        return (Class<T>) target;
    }
}
