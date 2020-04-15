package com.tqs.hw1.controller;

import com.tqs.hw1.Service.Cache;
import com.tqs.hw1.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RestControllerApi {

    @Autowired
    Cache cache;

    @GetMapping("/cache")
    public List<Weather> getCache(Model model) {
        return cache.getCache();
    }

    @GetMapping("/last")
    public Weather getLastWeather(Model model) {
        return cache.getCache().get(cache.getCache().size() - 1);
    }
}
