package com.onur.stockguard.persistence.jpa.repsitory;

import com.onur.stockguard.persistence.jpa.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservationJpaRepository extends JpaRepository<ReservationEntity, UUID> {
}
