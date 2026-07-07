package com.knitlog.backend.domain.yarn.dto;

import jakarta.validation.constraints.NotBlank;

public record YarnInfoUpdateRequest(
        @NotBlank String brand,
        @NotBlank String name,
        String season,
        String yarnType,
        String thickness,
        Integer lengthPer100g,
        String memo
) {
}
