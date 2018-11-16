package gd.TPJena.controllers;

import gd.TPJena.services.SPQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;


@RestController
public class IndexController {

    @Autowired
    SPQLService service;

    @Autowired
    ServletContext servletContext;

    @Autowired
    ParkingController pc;
    @Autowired
    WeatherController wc;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/searchFor/all")
    public String getAllData(@RequestBody String msg){
        return ("{\"dataParking\":"+pc.parkingAll(msg)+",\"dataWeather\":"+wc.weatherAll(msg)+"}");
    }
}