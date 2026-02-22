package com.onur.stockguard.persistence.jpa.repsitory;

import com.onur.stockguard.persistence.jpa.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StockJpaRepository extends JpaRepository<StockEntity, Long> {
}
