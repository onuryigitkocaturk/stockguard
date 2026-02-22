package com.onur.stockguard.api.reservation.dto;

import java.time.Instant;

public record ReservationResponse(
        String reservationId,
        Long productId,
        Long quantity,
        String status,
        Instant createdAt,
        Instant expiresAt
) {}
