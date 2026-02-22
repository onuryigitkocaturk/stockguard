package com.onur.stockguard.persistence.repository;

import com.onur.stockguard.persistence.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StockJpaRepository extends JpaRepository<StockEntity, Long> {
}
