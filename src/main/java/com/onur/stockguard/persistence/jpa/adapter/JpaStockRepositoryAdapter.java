package com.onur.stockguard.persistence.jpa.adapter;

import com.onur.stockguard.domain.model.stock.Stock;
import com.onur.stockguard.domain.repository.StockRepository;
import com.onur.stockguard.persistence.jpa.mapper.StockMapper;
import com.onur.stockguard.persistence.jpa.repository.StockJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaStockRepositoryAdapter implements StockRepository {

    private final StockJpaRepository stockJpaRepository;

    public JpaStockRepositoryAdapter(StockJpaRepository stockJpaRepository) {
        this.stockJpaRepository = stockJpaRepository;
    }

    @Override
    public Optional<Stock> findByProductId(Long productId) {
        return stockJpaRepository.findById(productId)
                .map(StockMapper::toDomain);
    }

    @Override
    public Stock save(Stock stock) {
        var savedEntity = stockJpaRepository.save(StockMapper.toEntity(stock));
        return StockMapper.toDomain(savedEntity);
    }
}