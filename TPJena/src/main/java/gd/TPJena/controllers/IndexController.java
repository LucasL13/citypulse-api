package gd.TPJena.controllers;

import gd.TPJena.services.ParkingService;
import gd.TPJena.services.SPQLService;
import gd.TPJena.services.WeatherService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;


@RestController
public class IndexController {

    @Autowired
    ParkingService ps;
    @Autowired
    WeatherService ws;


    @Autowired
    ServletContext servletContext;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/searchFor/all")
    public String getAllData(@RequestBody String msg){

        JSONObject parameters = (JSONObject) new JSONObject(msg).get("parameters");

        int maxEntries = 1;
        if (!(parameters.get("maxEntries") instanceof Integer))
            maxEntries = Integer.parseInt((String) parameters.get("maxEntries"));
        else
            maxEntries = (Integer) parameters.get("maxEntries");
        System.out.println("Le client demande " + maxEntries + " entrées GPS");

        return ("{\"dataParking\":"+ps.getParkingAll(maxEntries)+",\"dataWeather\":"+ws.getWeatherAll(maxEntries)+"}");
    }
}