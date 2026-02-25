package com.onur.stockguard.persistence.jpa.mapper;

import com.onur.stockguard.domain.model.stock.Stock;
import com.onur.stockguard.persistence.jpa.entity.StockEntity;

public final class StockMapper {

    private StockMapper() {
    }

    public static Stock toDomain(StockEntity entity) {
        if (entity == null) return null;

        return new Stock(
                entity.getProductId(),
                entity.getAvailableQuantity()
        );
    }

    public static StockEntity toEntity(Stock domain) {
        if (domain == null) return null;

        return new StockEntity(
                domain.getProductId(),
                domain.getAvailableQuantity()
        );
    }
}