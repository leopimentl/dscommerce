package com.leandrokhalel.dscommerce.api;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public record CustomError(
        Instant timestamp,
        Integer status,
        String error,
        String path
) {
}
