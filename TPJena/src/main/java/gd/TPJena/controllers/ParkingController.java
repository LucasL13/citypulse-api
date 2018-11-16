package gd.TPJena.controllers;

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
    SPQLService service;

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

        OutputStream os = new ByteArrayOutputStream();

        String queryString = "prefix sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>" +
                "\nprefix ct: <http://www.insight-centre.org/citytraffic#>" +
                "\nprefix ns1: <http://purl.oclc.org/NET/ssnx/ssn#>" +
                "\nprefix tl: <http://purl.org/NET/c4dm/timeline.owl#>" +

                "\nSELECT ?point ?val ?unit ?name ?longitude ?latitude ?pTime ?setStart ?setEnd" +
                "\nWHERE {?point a sao:Point ;" +
                "\nsao:value ?val ;" +
                "\nsao:hasUnitOfMeasurement ?unit ;" +
                "\nns1:featureOfInterest ?foi;" +
                "\nsao:time _:fpTime." +
                "\n_:fpTime tl:at ?pTime." +
                "\n?foi ct:hasFirstNode _:fNode." +
                "\n_:fNode ct:hasNodeName ?name." +
                "\n_:fNode ct:hasLongitude ?longitude." +
                "\n_:fNode ct:hasLatitude ?latitude." +
                "\n?sEvent a sao:streamEvent;" +
                "\nsao:time _:sEventTime." +
                "\n_:sEventTime tl:start ?setStart." +
                "\n_:sEventTime tl:end ?setEnd." +
                "\n}" +
                "LIMIT " + maxEntries;
        Query query = QueryFactory.create(queryString) ;
        QueryExecution qexec = QueryExecutionFactory.create(query, service.getModelParking()) ;
        ResultSet results = qexec.execSelect() ;
        ResultSetFormatter.outputAsJSON(os, results);
        //System.out.println(((ByteArrayOutputStream) os).toString());

        return ((ByteArrayOutputStream) os).toString();
    }
}

