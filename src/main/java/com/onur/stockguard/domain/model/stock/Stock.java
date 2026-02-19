package com.onur.stockguard.domain.model.stock;

import com.onur.stockguard.domain.exception.DomainRuleViolationException;
import com.onur.stockguard.domain.exception.InvalidQuantityException;
import com.onur.stockguard.domain.exception.OutOfStockException;

import java.time.Instant;
import java.util.Objects;

public class Stock {

    private final Long productId;
    private long availableQuantity;

    public Stock(Long productId, long availableQuantity) {
        this.productId = Objects.requireNonNull(productId,"productId cannot be null");

        if (availableQuantity < 0) {
            throw new DomainRuleViolationException("availableQuantity cannot be negative");
        }
        this.availableQuantity = availableQuantity;
    }

    public Reservation reserve(long quantity, ReservationId reservationId, Instant now, Instant expiresAt) {
        Objects.requireNonNull(reservationId,"reservationId cannot be null");
        Objects.requireNonNull(now, "now cannot be null");
        Objects.requireNonNull(expiresAt, "expiresAt cannot be null");

        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be positive");
        }

        if (availableQuantity < quantity) {
            throw new OutOfStockException("Not enough stock");
        }
        availableQuantity -= quantity;
        return new Reservation(reservationId, productId, quantity, now, expiresAt);
    }

    public void release(long quantity) {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be positive");
        }
        availableQuantity += quantity;
    }
    public Long getProductId() {
        return productId;
    }
    public long getAvailableQuantity() {
        return availableQuantity;
    }
}
