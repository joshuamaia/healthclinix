package com.jbconnect.healthclinix.security.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse(int status, String path, String message, LocalDateTime timespamp) {
}
