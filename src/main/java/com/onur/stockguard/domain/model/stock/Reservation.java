package com.onur.stockguard.domain.model.stock;

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
        this.id = Objects.requireNonNull(id);
        this.productId = Objects.requireNonNull(productId);

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        this.quantity = quantity;
        this.createdAt = Objects.requireNonNull(createdAt);
        this.expiresAt = Objects.requireNonNull(expiresAt);
        this.status = ReservationStatus.ACTIVE;
    }
    public ReservationId getId() { return id; }
    public Long getProductId() { return productId; }
    public long getQuantity() { return quantity; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getExpiresAt() { return expiresAt; }
    public ReservationStatus getStatus() { return status; }

}
