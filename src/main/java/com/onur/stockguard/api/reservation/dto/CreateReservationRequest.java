package com.onur.stockguard.api.reservation.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreateReservationRequest(
        @NotNull Long productId,
        @NotNull @Min(1) Long quantity,
        @Min(1) Integer ttlMinutes
) {}
