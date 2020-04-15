package com.tqs.hw1.model;

import lombok.Getter;
import lombok.Setter;


import java.util.HashMap;


@Getter
@Setter
public class Airquality {

    private HashMap<String, Double> co = new HashMap<>();

    private HashMap<String, Double> h = new HashMap<>();

    private HashMap<String, Double> no2 = new HashMap<>();

    private HashMap<String, Double> o3 = new HashMap<>();

    private HashMap<String, Double> p = new HashMap<>();

    private HashMap<String, Double> pm10 = new HashMap<>();

    private HashMap<String, Double> pm25 = new HashMap<>();

    private HashMap<String, Double> r = new HashMap<>();

    private HashMap<String, Double> so2 = new HashMap<>();

    private HashMap<String, Double> t = new HashMap<>();

    private HashMap<String, Double> w = new HashMap<>();


    @Override
    public String toString() {
        return "{" +
                "co: " + co +
                ", h: " + h +
                ", no2: " + no2 +
                ", o3: " + o3 +
                ", p: " + p +
                ", pm10: " + pm10 +
                ", pm25: " + pm25 +
                ", r: " + r +
                ", so2: " + so2 +
                ", t: " + t +
                ", w: " + w +
                '}';
    }
}
