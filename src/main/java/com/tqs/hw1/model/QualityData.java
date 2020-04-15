package com.tqs.hw1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class QualityData {

    private String aqi;

    private String idx;

    private City city;

    private Airquality iaqi;

    @Override
    public String toString() {
        return "{" +
                "aqi:'" + aqi + '\'' +
                ", idx:'" + idx + '\'' +
                ", city:'" + city + '\'' +
                ", iaqi:" + iaqi +
                '}';
    }
}

