package gd.TPJena.controllers;

import gd.TPJena.services.SPQLService;
import gd.TPJena.services.WeatherService;
import org.apache.jena.query.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@RestController
public class WeatherController {

    @Autowired
    WeatherService ws;

    @Autowired
    ServletContext servletContext;

    /* Retourne toutes les données du dataset Weather Humidity */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/searchFor/weather/all")
    public String weatherAll(@RequestBody String msg) {

        JSONObject parameters = (JSONObject) new JSONObject(msg).get("parameters");

        int maxEntries = 1;
        if (!(parameters.get("maxEntries") instanceof Integer))
            maxEntries = Integer.parseInt((String) parameters.get("maxEntries"));
        else
            maxEntries = (Integer) parameters.get("maxEntries");
        System.out.println("Le client demande " + maxEntries + " entrées GPS");

        return ws.getWeatherAll(maxEntries);
    }
}