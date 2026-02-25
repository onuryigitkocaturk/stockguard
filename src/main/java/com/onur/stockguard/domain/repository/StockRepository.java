package com.onur.stockguard.domain.repository;

import com.onur.stockguard.domain.model.stock.Stock;

import java.util.Optional;

public interface StockRepository {
    Optional<Stock> findByProductId(Long productId);
    Stock save(Stock stock);
}
