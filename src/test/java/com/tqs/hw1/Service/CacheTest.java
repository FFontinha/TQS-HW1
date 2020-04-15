package com.tqs.hw1.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tqs.hw1.model.Weather;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

public class CacheTest {


    @Test
    @DisplayName("Weather doesn't exist")
    void weatherExists(){
        Cache c = new Cache();
        assertEquals(false, c.weatherExists(""), "Should return false");
    }

    @Test
    @DisplayName("Weather exists")
    void weatherExists2(){
        Cache c = new Cache();
        Weather w = new Weather();
        w.setSearchKey("London");
        c.addWeather(w);
        assertEquals(true, c.weatherExists("London"), "Should return true");
    }

    @Test
    @DisplayName("No last weather")
    void lastWeather(){
        Cache c = new Cache();
        Weather w = c.getLastWeather();
        assertEquals(false, c.getLastWeather() != null, "Should return false");
    }

    @Test
    @DisplayName("Last weather")
    void lastWeatherExists(){
        Cache c = new Cache();
        Weather w = new Weather();
        c.setLastWeather(w);
        assertEquals(true, c.getLastWeather() != null, "Should return true");
    }

    @Test
    @DisplayName("Cache is Empty")
    void getCache(){
        Cache c = new Cache();
        assertEquals(true, c.getCache().isEmpty(), "Should return true");
    }


}

