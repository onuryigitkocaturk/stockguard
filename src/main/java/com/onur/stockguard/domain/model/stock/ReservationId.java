package com.onur.stockguard.domain.model.stock;

import java.util.Objects;

public class ReservationId {

    private final String value;

    public ReservationId(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("ReservationId cannot be blank");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservationId that)) return false;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }

}
