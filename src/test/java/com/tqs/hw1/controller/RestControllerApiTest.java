package com.tqs.hw1.controller;

import com.tqs.hw1.Service.Cache;
import com.tqs.hw1.model.Weather;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(RestControllerApi.class)
public class RestControllerApiTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private Cache cache;

    @Test
    public void getCache_thenReturnJsonArray() throws Exception {
        Weather w = new Weather();
        w.setSearchKey("London");
        w.setStatus("ok");
        List<Weather> weathers = Arrays.asList(w);
        given(cache.getCache()).willReturn(weathers);

        mvc.perform(get("/api/cache")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].searchKey", is(w.getSearchKey())));

    }

    @Test
    @DisplayName("Weather exists")
    void locationExists(){
        String location = "Lisboa";
        Weather w = new Weather();
        Cache c = new Cache();
        w.setSearchKey(location);
        c.addWeather(w);
        assertEquals(true, c.weatherExists(location), "Should return true");
    }

}
