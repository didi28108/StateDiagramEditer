package model;

import sample.GuiController;
import bridge.BridgeCommand;
import javafx.scene.layout.AnchorPane;
import sample.ModelListener;
import java.util.ArrayList;

public class StateDiagram {
    ArrayList<Model> statediagrams;
    public StateDiagram(){
        this.statediagrams = new ArrayList<>();
    }
    public StateDiagram(ArrayList<Model> arraylist){
        this.statediagrams = arraylist;
    }
    public void addModel(Model model){
        statediagrams.add(model);
    }
    public void deleteModel(Model model){
        statediagrams.remove(model);
    }
    public StateDiagram clone(GuiController controller){
        ModelListener modelListener;
        ArrayList<Model> arraylist = new ArrayList<>();
        for (Model i:statediagrams){
            modelListener = new ModelListener(controller);
            Model model_org = i;
            Model model_clone;
            model_clone = model_org.clone();
            modelListener.setlistener(model_clone);
            arraylist.add(model_clone);
           // System.out.println(model_org.getGroup()+" "+model_org.getGroup().getTranslateX()+" "+model_org.getGroup().getTranslateY()+" -> "+
                  //  model_clone.getGroup()+" "+model_clone.getGroup().getTranslateX()+" "+model_clone.getGroup().getTranslateY());
        }
        StateDiagram clonestateDiagram = new StateDiagram(arraylist);
        //System.out.println(this+" "+statediagrams+" -> "+clonestateDiagram+" "+arraylist);
        return clonestateDiagram;
    }
    public void load(AnchorPane anchorPane,BridgeCommand bridgeCommand){
        anchorPane.getChildren().clear();
        System.out.println("load "+this);
        for (Model i:statediagrams){
            if (i.getClass().toString().equals("class model.State")||i.getClass().toString().equals("class model.ColorState")){
                bridgeCommand.addstate(anchorPane,i);
            }else if(i.getClass().toString().equals("class model.Transition")||i.getClass().toString().equals("class model.ColorTransition")){
                bridgeCommand.addstransition(anchorPane,i);
            }
        }
    }
}
