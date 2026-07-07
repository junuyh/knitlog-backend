package com.knitlog.backend.domain.yarn.dto;

import com.knitlog.backend.domain.yarn.YarnInfo;

public record YarnInfoResponse(
        Long id,
        String brand,
        String name,
        String season,
        String yarnType,
        String thickness,
        Integer lengthPer100g,
        String memo
) {
    public static YarnInfoResponse from(YarnInfo yarnInfo) {
        return new YarnInfoResponse(
                yarnInfo.getId(),
                yarnInfo.getBrand(),
                yarnInfo.getName(),
                yarnInfo.getSeason(),
                yarnInfo.getYarnType(),
                yarnInfo.getThickness(),
                yarnInfo.getLengthPer100g(),
                yarnInfo.getMemo()
        );
    }

}

