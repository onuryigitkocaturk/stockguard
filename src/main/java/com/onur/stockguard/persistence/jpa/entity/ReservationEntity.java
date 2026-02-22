package com.onur.stockguard.persistence.jpa.entity;

import com.onur.stockguard.domain.model.stock.ReservationStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "reservation")
public class ReservationEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "product_id", nullable = false)
    private  Long productId;

    @Column(name = "quantity", nullable = false)
    private long quantity;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "expires_at", nullable = false)
    private Instant expiresAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReservationStatus status;

    protected ReservationEntity() {
        // for JPA
    }

    public ReservationEntity(
            UUID id,
            Long productId,
            long quantity,
            Instant createdAt,
            Instant expiresAt,
            ReservationStatus status) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }
    public Long getProductId() {
        return productId;
    }
    public long getQuantity() {
        return quantity;
    }
    public Instant getCreatedAt() {
        return createdAt;
    }
    public Instant getExpiresAt() {
        return expiresAt;
    }
    public ReservationStatus getStatus() {
        return status;
    }
    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
