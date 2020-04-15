package com.tqs.hw1.controller;


import com.google.gson.Gson;
import com.tqs.hw1.Service.Cache;
import com.tqs.hw1.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class WeatherController {

    @Autowired
    Cache cache;


    @GetMapping("/")
    public String index(@RequestParam(required = false, name = "location") String location, Model model) {
        if(this.cache.weatherExists(location)){
            Weather weather = this.cache.getLastWeather();
            model.addAttribute("local", weather);
            model.addAttribute("geo", weather.getData().getCity().getGeo());
        }
        else {
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject("https://api.waqi.info/feed/" + location + "/?token=8fe6c48599b128a1f153d247218ae5a54ab0f4c7", String.class);
            if (response.charAt(11) != 'e') {
                Gson g = new Gson();
                Weather weather = g.fromJson(response, Weather.class);
                weather.setSearchKey(location);
                this.cache.addWeather(weather);
                model.addAttribute("local", weather);
                model.addAttribute("geo", weather.getData().getCity().getGeo());
                System.out.println(weather);
            }
            else{
                if(location != null)model.addAttribute("local", "Informação do local é inexistente.");
            }
        }



        return "index";
    }





}
