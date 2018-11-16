package gd.TPJena.controllers;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import gd.TPJena.services.SPQLService;
import org.apache.jena.query.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;

@RestController
public class WeatherController {

    @Autowired
    SPQLService service;

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

        OutputStream os = new ByteArrayOutputStream();

        String queryString = "prefix sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>" +
                "\nprefix ct: <http://www.insight-centre.org/citytraffic#>" +
                "\nprefix ns1: <http://purl.oclc.org/NET/ssnx/ssn#>" +
                "\nprefix tl: <http://purl.org/NET/c4dm/timeline.owl#>" +

                "\nSELECT ?unit ?val ?setStart ?setEnd" +
                "\nWHERE {?point a sao:Point ;" +
                "\nsao:value ?val ;" +
                "\nsao:hasUnitOfMeasurement ?unit." +
                "\n?sEvent a sao:streamEvent;" +
                "\nsao:time _:sEventTime." +
                "\n_:sEventTime tl:start ?setStart." +
                "\n_:sEventTime tl:end ?setEnd." +
                "\n}" +
                "LIMIT " + maxEntries;
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, service.getModelWeather());
        ResultSet results = qexec.execSelect();
        ResultSetFormatter.outputAsJSON(os, results);
        //System.out.println(((ByteArrayOutputStream) os).toString());

        return ((ByteArrayOutputStream) os).toString();
    }
}