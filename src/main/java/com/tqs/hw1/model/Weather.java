package com.tqs.hw1.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Weather {


    private String status;

    private QualityData data;

    private String searchKey;


    @Override
    public String toString() {
        return "{" +
                "status:'" + status + '\'' +
                ", data:" + data +
                ", searchKey:" + searchKey +
                '}';
    }


}

