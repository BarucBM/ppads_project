package com.TCC.domain.event;

import com.TCC.domain.company.Company;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record CustomerEventDTO(
        String id,
        String title,
        String description,
        LocalDateTime startTime,
        LocalDateTime endTime,
        boolean freeEntry,
        BigDecimal ticketUnitPrice,
        BigDecimal ticketTax,
        Company company,
        LocalDateTime acquisitionDate,
        int customerRating
) {
}
