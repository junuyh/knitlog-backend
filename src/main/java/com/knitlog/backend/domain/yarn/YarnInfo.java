package com.knitlog.backend.domain.yarn;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class YarnInfo {

    // id가 이 Entity의 식별자, 즉 PK라는 뜻. JPA Entity는 반드시 식별자가 필요
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String name;
    private String season;
    private String yarnType;
    private String thickness;
    @Column(name = "length_per_100g")
    private Integer lengthPer100g;
    private String memo;

    public YarnInfo(String brand, String name, String season, String yarnType,
                    String thickness, Integer lengthPer100g, String memo) {
        this.brand = brand;
        this.name = name;
        this.season = season;
        this.yarnType = yarnType;
        this.thickness = thickness;
        this.lengthPer100g = lengthPer100g;
        this.memo = memo;
    }

    public void update(String brand, String name, String season, String yarnType,
                        String thickness, Integer lengthPer100g, String memo) {
        this.brand = brand;
        this.name = name;
        this.season = season;
        this.yarnType = yarnType;
        this.thickness = thickness;
        this.lengthPer100g = lengthPer100g;
        this.memo = memo;
    }

}
