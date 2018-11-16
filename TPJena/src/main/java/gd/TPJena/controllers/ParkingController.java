package gd.TPJena.controllers;

import gd.TPJena.services.ParkingService;
import gd.TPJena.services.SPQLService;
import org.apache.jena.query.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@RestController
public class ParkingController {

    @Autowired
    ParkingService ps;

    @Autowired
    ServletContext servletContext;

    /* Retourne toutes les données du dataset Parking */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/searchFor/parking/all")
    public String parkingAll(@RequestBody String msg){

        JSONObject parameters = (JSONObject) new JSONObject(msg).get("parameters");

        int maxEntries = 1;
        if(!(parameters.get("maxEntries") instanceof Integer))
            maxEntries = Integer.parseInt((String) parameters.get("maxEntries"));
        else
            maxEntries = (Integer) parameters.get("maxEntries");
        System.out.println("Le client demande " + maxEntries + " entrées GPS");

        return ps.getParkingAll(maxEntries);
    }
}

