package com.onur.stockguard.persistence.jpa.adapter;

import com.onur.stockguard.domain.model.stock.Reservation;
import com.onur.stockguard.domain.model.stock.ReservationId;
import com.onur.stockguard.domain.repository.ReservationRepository;
import com.onur.stockguard.persistence.jpa.mapper.ReservationMapper;
import com.onur.stockguard.persistence.jpa.repository.ReservationJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaReservationRepositoryAdapter implements ReservationRepository {

    private final ReservationJpaRepository reservationJpaRepository;

    public JpaReservationRepositoryAdapter(ReservationJpaRepository reservationJpaRepository) {
        this.reservationJpaRepository = reservationJpaRepository;
    }

    @Override
    public Optional<Reservation> findById(ReservationId id) {
        return reservationJpaRepository
                .findById(UUID.fromString(id.getValue()))
                .map(ReservationMapper::toDomain);
    }

    @Override
    public Reservation save(Reservation reservation) {
        var savedEntity = reservationJpaRepository
                .save(ReservationMapper.toEntity(reservation));

        return ReservationMapper.toDomain(savedEntity);
    }
}