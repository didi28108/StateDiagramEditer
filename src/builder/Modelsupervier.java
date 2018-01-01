package builder;

import model.Model;
import model.State;
import model.Transition;

public class Modelsupervier {
    ModelBuilder modelBuilder;
    public Modelsupervier(ModelBuilder modelBuilder){
        this.modelBuilder = modelBuilder;
    };
    public void contruct(){
        modelBuilder.createText();
        modelBuilder.createMain();
        modelBuilder.combined();
    }
    public Model getModel(){
       return modelBuilder.getModle();
    }
}
