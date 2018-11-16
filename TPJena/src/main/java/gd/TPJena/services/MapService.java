package gd.TPJena.services;

import org.apache.jena.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@Service
public class MapService {

    @Autowired
    SPQLService service;

    public String getMapdata(int maxEntries){
        OutputStream os = new ByteArrayOutputStream();

        String queryString = "prefix sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>" +
                "\nprefix ct: <http://www.insight-centre.org/citytraffic#>" +
                "\nprefix ns1: <http://purl.oclc.org/NET/ssnx/ssn#>" +
                "\nprefix tl: <http://purl.org/NET/c4dm/timeline.owl#>" +

                "\nSELECT DISTINCT ?longitude ?latitude" +
                "\nWHERE {?point a sao:Point ;" +
                "\nns1:featureOfInterest ?foi." +
                "\n?foi ct:hasFirstNode _:fNode." +
                "\n_:fNode ct:hasNodeName ?name." +
                "\n_:fNode ct:hasLongitude ?longitude." +
                "\n_:fNode ct:hasLatitude ?latitude." +
                "\n}" +
                "LIMIT " + maxEntries;
        Query query = QueryFactory.create(queryString) ;
        QueryExecution qexec = QueryExecutionFactory.create(query, service.getModelParking()) ;
        ResultSet results = qexec.execSelect() ;
        ResultSetFormatter.outputAsJSON(os, results);

        return ((ByteArrayOutputStream) os).toString();
    }

}
