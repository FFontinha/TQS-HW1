package com.tqs.hw1.Service;

import com.tqs.hw1.model.Weather;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Service
public class Cache {

    private List<Weather> cache = new ArrayList<>();

    private Weather lastWeather;

    public void addWeather(Weather w){
        this.cache.add(w);
    }


    public boolean weatherExists(String name){
        for(Weather w : this.cache){
            if (w.getSearchKey().equalsIgnoreCase(name)){
                this.lastWeather = w;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "{" +
                "cache: " + cache +
                '}';
    }
}
