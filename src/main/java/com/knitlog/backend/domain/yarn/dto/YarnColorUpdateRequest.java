package com.knitlog.backend.domain.yarn.dto;

import jakarta.validation.constraints.NotBlank;

public record YarnColorUpdateRequest(
        String colorCode,
        @NotBlank String colorName,
        String memo
) {
}
