package com.onur.stockguard.domain.repository;

import com.onur.stockguard.domain.model.stock.Reservation;
import com.onur.stockguard.domain.model.stock.ReservationId;

import java.util.Optional;

public interface ReservationRepository {
    Optional<Reservation> findById(ReservationId reservationId);
    Reservation save(Reservation reservation);
}
