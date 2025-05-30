package com.TCC.domain.event;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EventDTO(
        @NotBlank String title,
        @NotBlank String description,
        LocalDateTime startTime,
        LocalDateTime endTime,
        boolean freeEntry,
        BigDecimal ticketUnitPrice,
        BigDecimal ticketTax,
        MultipartFile[] images
) {
}
