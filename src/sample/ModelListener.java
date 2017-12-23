package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import model.Model;

public class ModelListener{
    private Model model;
    GuiController guiController;
    public ModelListener(GuiController controller){
        this.guiController = controller;
            }
    public void setlistener(Model smodel){
        model = smodel;
        model.getGroup().setOnMousePressed((MouseEvent e) -> {mousepress(e);});
        model.getGroup().setOnMouseDragged((MouseEvent e) -> {mousedrag(e);});
        model.getGroup().setOnMouseClicked((MouseEvent e) ->{mouseclick(e);});
    }
    private void mousepress(MouseEvent mouseEvent) {
        model.setOrgSceneX(mouseEvent.getSceneX());
        model.setOrgSceneY(mouseEvent.getSceneY());
        model.setOrgTranslateX(((Group)(mouseEvent.getSource())).getTranslateX());
        model.setOrgTranslateY(((Group)(mouseEvent.getSource())).getTranslateY());
    }
    private void mousedrag(MouseEvent mouseEvent){
        double offsetX = mouseEvent.getSceneX() - model.getOrgSceneX();
        double offsetY = mouseEvent.getSceneY() - model.getOrgSceneY();
        double newTranslateX = model.getOrgTranslateX() + offsetX;
        double newTranslateY = model.getOrgTranslateY() + offsetY;
        ((Group)(mouseEvent.getSource())).setTranslateX(newTranslateX);
        ((Group)(mouseEvent.getSource())).setTranslateY(newTranslateY);
       // System.out.println(((Group)(mouseEvent.getSource()))+" "+newTranslateX+" "+newTranslateY);
        if(model.getClass().toString().equals("class model.Transition")||
                model.getClass().toString().equals("class model.ColorTransition"))
        {
            model.getGroup2().setTranslateX(newTranslateX);
            model.getGroup2().setTranslateY(newTranslateY);
           // System.out.println(model.getGroup2().getTranslateX()+","+model.getGroup2().getTranslateY());
        }
    };
    private void mouseclick(MouseEvent mouseEvent) {
        guiController.setSelect_model(model);
    }
}
