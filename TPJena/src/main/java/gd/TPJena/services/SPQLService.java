package gd.TPJena.services;

import gd.TPJena.models.SPQLData;
import org.apache.jena.rdf.model.Model;
import org.springframework.stereotype.Service;

@Service
public class SPQLService {

    SPQLData dataParking;
    SPQLData dataWeather;

    public SPQLService() {
        dataParking = new SPQLData();
        dataWeather = new SPQLData();
    }

    public void loadData(String pathParking, String pathWeather) {
        dataParking.loadData(pathParking);
        dataWeather.loadData(pathWeather);
    }

    public Model getModelParking() {
        return dataParking.getModel();
    }

    public Model getModelWeather() {
        return dataWeather.getModel();
    }
}
