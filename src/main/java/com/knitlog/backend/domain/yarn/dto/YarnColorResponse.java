package com.knitlog.backend.domain.yarn.dto;

import com.knitlog.backend.domain.yarn.YarnColor;

public record YarnColorResponse(
        Long id,
        Long yarnInfoId,
        String colorCode,
        String colorName,
        String memo
) {

    public static YarnColorResponse from(YarnColor yarnColor) {
        return new YarnColorResponse(
                yarnColor.getId(),
                yarnColor.getYarnInfo().getId(),
                yarnColor.getColorCode(),
                yarnColor.getColorName(),
                yarnColor.getMemo()
        );
    }
}
