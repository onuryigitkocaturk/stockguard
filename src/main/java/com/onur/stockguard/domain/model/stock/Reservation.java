package com.onur.stockguard.domain.model.stock;

import com.onur.stockguard.domain.exception.DomainException;
import com.onur.stockguard.domain.exception.DomainRuleViolationException;

import java.time.Instant;
import java.util.Objects;

public class Reservation {
    private final ReservationId id;
    private final Long productId;
    private final long quantity;
    private final Instant createdAt;
    private final Instant expiresAt;

    private ReservationStatus status;

    public Reservation(
            ReservationId id,
            Long productId,
            long quantity,
            Instant createdAt,
            Instant expiresAt) {
        this.id = Objects.requireNonNull(id,"id cannot be null");
        this.productId = Objects.requireNonNull(productId,"productId cannot be null");

        if (quantity <= 0) {
            throw new DomainRuleViolationException("Quantity must be positive");
        }

        this.quantity = quantity;
        this.createdAt = Objects.requireNonNull(createdAt,"createdAt cannot be null");
        this.expiresAt = Objects.requireNonNull(expiresAt,"expiresAt cannot be null");

        if (!expiresAt.isAfter(createdAt)) {
            throw new DomainRuleViolationException("expiresAt must be after createdAt");
        }

        this.status = ReservationStatus.ACTIVE;
    }
    public ReservationId getId() { return id; }
    public Long getProductId() { return productId; }
    public long getQuantity() { return quantity; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getExpiresAt() { return expiresAt; }
    public ReservationStatus getStatus() { return status; }

    public boolean isExpired(Instant now) {
        Objects.requireNonNull(now,"now can not be null");
        return now.isAfter(expiresAt);
    }

    public void expire(Instant now) {
        Objects.requireNonNull(now,"now cannot be null");

        if (status != ReservationStatus.ACTIVE) {
            return;
        }
        if (!isExpired(now)) {
            return;
        }
        this.status = ReservationStatus.EXPIRED;
    }

    public void cancel(Instant now) {
        Objects.requireNonNull(now, "now cannot be null");

        if (status != ReservationStatus.ACTIVE) {
            throw new DomainRuleViolationException("Only ACTIVE reservations can be cancelled");
        }
        if (isExpired(now)) {
            this.status = ReservationStatus.EXPIRED;
            throw new DomainRuleViolationException("Cannot cancel an expired reservation");
        }
        this.status = ReservationStatus.CANCELED;
    }

    public void confirm(Instant now) {
        Objects.requireNonNull(now, "now cannot be null");

        if (status != ReservationStatus.ACTIVE) {
            throw new DomainRuleViolationException("Only ACTIVE reservations can be confirmed");
        }
        if (isExpired(now)) {
            this.status = ReservationStatus.EXPIRED;
            throw new DomainRuleViolationException("Cannot confirme an expired reservation");
        }
        this.status = ReservationStatus.CONFIRMED;
    }

}
