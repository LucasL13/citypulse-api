package gd.TPJena.controllers;

import gd.TPJena.services.SPQLService;
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
        OutputStream os2 = new ByteArrayOutputStream();

        String queryString = "prefix sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>" +
                "\nprefix ct: <http://www.insight-centre.org/citytraffic#>" +
                "\nprefix ns1: <http://purl.oclc.org/NET/ssnx/ssn#>" +
                "\nprefix tl: <http://purl.org/NET/c4dm/timeline.owl#>" +

                "\nSELECT ?SEStart ?SEEnd" +
                "\nWHERE {" +
                "\n?sEvent a sao:streamEvent;" +
                "\nsao:time _:sEventTime." +
                "\n_:sEventTime tl:start ?SEStart." +
                "\n_:sEventTime tl:end ?SEEnd." +
                "\n}" +
                "LIMIT " + maxEntries;
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, service.getModelWeather());
        ResultSet results = qexec.execSelect();
        ResultSetFormatter.outputAsJSON(os, results);

        queryString = "prefix sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>" +
                "\nprefix ct: <http://www.insight-centre.org/citytraffic#>" +
                "\nprefix ns1: <http://purl.oclc.org/NET/ssnx/ssn#>" +
                "\nprefix tl: <http://purl.org/NET/c4dm/timeline.owl#>" +

                "\nSELECT ?pTime ?unit ?val" +
                "\nWHERE {?point a sao:Point ;" +
                "\nsao:value ?val ;" +
                "\nsao:hasUnitOfMeasurement ?unit;" +
                "\nsao:time _:fpTime." +
                "\n_:fpTime tl:at ?pTime." +
                "\n}" +
                "LIMIT " + maxEntries;
        query = QueryFactory.create(queryString);
        qexec = QueryExecutionFactory.create(query, service.getModelWeather());
        results = qexec.execSelect();
        ResultSetFormatter.outputAsJSON(os2, results);

        return ("{\"durationRange\":" + ((ByteArrayOutputStream) os).toString() + ",\"entries\":" + ((ByteArrayOutputStream) os2).toString()+"}");
    }
}