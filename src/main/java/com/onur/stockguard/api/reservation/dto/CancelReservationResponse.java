package com.onur.stockguard.api.reservation.dto;

import java.time.Instant;

public record CancelReservationResponse(
        String reservationId,
        String status,
        Instant canceledAt
) {}
