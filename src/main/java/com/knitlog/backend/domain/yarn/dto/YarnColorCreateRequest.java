package com.knitlog.backend.domain.yarn.dto;

import jakarta.validation.constraints.NotBlank;

public record YarnColorCreateRequest(
        String colorCode,
        @NotBlank String colorName,
        String memo
) {
}
