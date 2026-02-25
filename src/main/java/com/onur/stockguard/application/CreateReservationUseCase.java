package com.onur.stockguard.application;

import com.onur.stockguard.domain.model.stock.Reservation;
import com.onur.stockguard.domain.model.stock.ReservationId;
import com.onur.stockguard.domain.model.stock.Stock;
import com.onur.stockguard.domain.repository.ClockPort;
import com.onur.stockguard.domain.repository.ReservationRepository;
import com.onur.stockguard.domain.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Service
public class CreateReservationUseCase {

    private static final Duration DEFAULT_TTL = Duration.ofMinutes(15);

    private final StockRepository stockRepository;
    private final ReservationRepository reservationRepository;
    private final ClockPort clockPort;

    public CreateReservationUseCase(
            StockRepository stockRepository,
            ReservationRepository reservationRepository,
            ClockPort clockPort
    ) {
        this.stockRepository = stockRepository;
        this.reservationRepository = reservationRepository;
        this.clockPort = clockPort;
    }

    @Transactional
    public Reservation create(Long productId, long quantity) {

        Stock stock = stockRepository.findByProductId(productId)
                .orElseThrow(() -> new IllegalStateException("Stock not found for productId=" + productId));

        Instant now = clockPort.now();
        Instant expiresAt = now.plus(DEFAULT_TTL);

        Reservation reservation = new Reservation(
                new ReservationId(UUID.randomUUID().toString()),
                productId,
                quantity,
                now,
                expiresAt
        );

        stock.release(quantity);

        stockRepository.save(stock);
        return reservationRepository.save(reservation);
    }
}