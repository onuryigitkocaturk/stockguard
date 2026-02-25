package com.onur.stockguard.persistence.jpa.mapper;

import com.onur.stockguard.domain.model.stock.Reservation;
import com.onur.stockguard.domain.model.stock.ReservationId;
import com.onur.stockguard.persistence.jpa.entity.ReservationEntity;

import java.util.UUID;

public final class ReservationMapper {

    private ReservationMapper() {
    }

    public static Reservation toDomain(ReservationEntity entity) {
        if (entity == null) return null;

        return new Reservation(
                new ReservationId(entity.getId().toString()), // UUID -> String
                entity.getProductId(),
                entity.getQuantity(),
                entity.getCreatedAt(),
                entity.getExpiresAt()
        );
    }

    public static ReservationEntity toEntity(Reservation domain) {
        if (domain == null) return null;

        return new ReservationEntity(
                UUID.fromString(domain.getId().getValue()), // String -> UUID
                domain.getProductId(),
                domain.getQuantity(),
                domain.getCreatedAt(),
                domain.getExpiresAt(),
                domain.getStatus()
        );
    }
}