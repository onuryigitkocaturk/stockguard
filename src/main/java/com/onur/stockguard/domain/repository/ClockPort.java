package com.onur.stockguard.domain.repository;

import java.time.Instant;

public interface ClockPort {
    Instant now();
}