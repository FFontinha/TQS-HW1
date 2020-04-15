package com.tqs.hw1.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class City {

    private double[] geo;

    private String name;

    private Airquality iaqi;

    @Override
    public String toString() {
        return "{" +
                "geo:" + Arrays.toString(geo) +
                ", name:'" + name + '\'' +
                '}';
    }
}

