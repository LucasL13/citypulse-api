package gd.TPJena.utils;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class SPQLTools {

    public Model loadModel(String path){
        org.apache.jena.rdf.model.Model m = ModelFactory.createDefaultModel();
        try{
            m.read(new FileInputStream(path), null, "TTL");
        }catch (IOException e){ e.getMessage(); }
        return m;
    }

}
