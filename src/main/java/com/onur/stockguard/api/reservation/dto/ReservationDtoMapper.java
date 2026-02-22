package com.onur.stockguard.api.reservation.dto;

import com.onur.stockguard.domain.model.stock.Reservation;
import com.onur.stockguard.domain.model.stock.ReservationStatus;

public final class ReservationDtoMapper {

    private ReservationDtoMapper() {}

    public static ReservationResponse toResponse(Reservation r) {
        return new ReservationResponse(
                r.getId().getValue(),
                r.getProductId(),
                r.getQuantity(),
                r.getStatus().name(),
                r.getCreatedAt(),
                r.getExpiresAt()
        );
    }
}
