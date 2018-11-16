package gd.TPJena.utils;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.IOException;

public class SPQLTools {

    @Autowired
    ServletContext servletContext;

    public Model loadModel(String path){
        org.apache.jena.rdf.model.Model m = ModelFactory.createDefaultModel();
        m.read(this.getClass().getResourceAsStream(path), null, "TTL");
        return m;
    }

}
