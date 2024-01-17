package com.binary.carShow.exception;

import java.time.LocalDateTime;
import java.util.Objects;

public record ApiError(
        String path,
        String message,
        int statusCode,
        LocalDateTime timestamp
        ) {

}




