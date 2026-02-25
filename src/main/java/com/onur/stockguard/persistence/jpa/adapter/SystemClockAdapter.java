package com.onur.stockguard.persistence.jpa.adapter;

import com.onur.stockguard.domain.repository.ClockPort;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class SystemClockAdapter implements ClockPort {

    @Override
    public Instant now() {
        return Instant.now();
    }
}