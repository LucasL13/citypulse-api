package gd.TPJena.models;

import gd.TPJena.utils.SPQLTools;
import org.apache.jena.rdf.model.Model;


public class SPQLData {

    SPQLTools toolBox;
    Model dataModel;

    public SPQLData(){
        toolBox = new SPQLTools();
    }

    public void loadData(String path){
        dataModel = toolBox.loadModel(path);
    }

    public Model getModel(){
        return this.dataModel;
    }
}
