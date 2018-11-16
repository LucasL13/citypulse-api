package gd.TPJena.services;

import org.apache.jena.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@Service
public class ParkingService {

    @Autowired
    SPQLService service;

    public String getParkingAll(int maxEntries){

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
        QueryExecution qexec = QueryExecutionFactory.create(query, service.getModelParking());
        ResultSet results = qexec.execSelect();
        ResultSetFormatter.outputAsJSON(os, results);

        queryString = "prefix sao: <http://iot.ee.surrey.ac.uk/citypulse/resources/ontologies/sao.ttl>" +
                "\nprefix ct: <http://www.insight-centre.org/citytraffic#>" +
                "\nprefix ns1: <http://purl.oclc.org/NET/ssnx/ssn#>" +
                "\nprefix tl: <http://purl.org/NET/c4dm/timeline.owl#>" +

                "\nSELECT ?point ?val ?unit ?name ?longitude ?latitude ?pTime" +
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
                "\n}" +
                "LIMIT " + maxEntries;
        query = QueryFactory.create(queryString);
        qexec = QueryExecutionFactory.create(query, service.getModelParking());
        results = qexec.execSelect();
        ResultSetFormatter.outputAsJSON(os2, results);

        return ("{\"durationRange\":" + ((ByteArrayOutputStream) os).toString() + ",\"entries\":" + ((ByteArrayOutputStream) os2).toString()+"}");
    }

}
