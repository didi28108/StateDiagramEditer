package sample;

import bridge.BridgeCommand;
import builder.ModelBuilder;
import builder.Modelsupervier;
import builder.StateBuilder;
import builder.TransitionBuilder;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import memento.Originator;
import model.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.util.Optional;

public class GuiController {
    BridgeCommand bridgeCommand;
    Originator originator;
    StateDiagram stateDiagram;
    Model select_model=null,pre_model;
    GuiView guiView;
    Modelsupervier modelsupervier;
    ModelBuilder statebuilder,transitionbuilder;
    public GuiController() {
        statebuilder = new StateBuilder();
        transitionbuilder = new TransitionBuilder();
        bridgeCommand = new BridgeCommand();
        stateDiagram = new StateDiagram();
        originator = originator.getInstance();
    }
    public void new_press(AnchorPane anchr) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("確定要刪除所有東西？");
        alert.setContentText("刪除的東西無法復原");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            anchr.getChildren().clear();
            originator.clearall();
        }
    }
    public void statediagram_save(AnchorPane anchorPane){
        originator.setMemeto(stateDiagram.clone(this));
    }
    public void edit_press(AnchorPane anchr,String name){
        if (select_model != null && !select_model.getText().getText().equals(name)){
            statediagram_save(anchr);
            select_model.getText().setText(name);
            System.out.println("Edited -> diagram save ");
            statediagram_save(anchr);
        }
    }
    public void redo_press(AnchorPane anchr) {
        stateDiagram = originator.redoCommand(stateDiagram);
        if (stateDiagram != null){
            System.out.print("redo ");
            stateDiagram.load(anchr, bridgeCommand);}
    }

    public void undo_press(AnchorPane anchr) {
        stateDiagram = originator.undoCommand(stateDiagram);
        if (stateDiagram != null){
            System.out.print("undo ");
            stateDiagram.load(anchr, bridgeCommand);}
    }
    public void delete_press(AnchorPane anchr) {
        if (select_model != null){
            statediagram_save(anchr);
            bridgeCommand.delete(anchr,select_model);
            stateDiagram.deleteModel(select_model);
            select_model = null;
            System.out.println("Deleted -> diagram save");
        }
    }
    public void state_press(AnchorPane anchr,Color main,Color text) {
        statediagram_save(anchr);
        modelsupervier = new Modelsupervier(statebuilder);
        modelsupervier.contruct();
        Model model = modelsupervier.getModel();
        if (!(main.equals(Color.BLACK)&&text.equals(Color.BLACK))){
            model = new ColorState((State)model,main,text);
        }
        ModelListener modelListener = new ModelListener(this);
        modelListener.setlistener(model);
        stateDiagram.addModel(model);
        bridgeCommand.addstate(anchr, model);
        System.out.println("State add -> diagram save");
    }
    public void transition_press(AnchorPane anchr,Color main,Color text) {
        statediagram_save(anchr);
        modelsupervier = new Modelsupervier(transitionbuilder);
        modelsupervier.contruct();
        Model model = modelsupervier.getModel();
        if (!main.equals(Color.BLACK)){
            model =  new ColorTransition((Transition)model,main,text);
        }
        ModelListener modelListener = new ModelListener(this);
        modelListener.setlistener(model);
        stateDiagram.addModel(model);
        bridgeCommand.addstransition(anchr, model);
        System.out.println("Transition add -> diagram save");
    }
    public void setSelect_model(Model model) {
        pre_model = select_model;
        if (model == null && select_model !=null) {
            select_model.getGroup().setEffect(new Glow(0));
            System.out.println("Unselected");
        }else {
            this.select_model = model;
            selectGlow();
        }
    }
    public void setGuiView(GuiView guiView) {
        this.guiView = guiView;
    }
    public void selectGlow(){
        if(pre_model!=null)pre_model.getGroup().setEffect(new Glow(0));
        if(select_model!=null)select_model.getGroup().setEffect(new Glow(0.8));
    }
    public void mainChageColor(AnchorPane anchr,Color main,Color text){
        //System.out.println(select_model.getClass().toString());
        if (select_model !=null){
            statediagram_save(anchr);;
            stateDiagram.deleteModel(select_model);
        if (select_model.getClass().toString().equals("class model.State")||select_model.getClass().toString().equals("class model.ColorState")){
            this.select_model = new ColorState(select_model,main,text);
        }else if (select_model.getClass().toString().equals("class model.Transition")||select_model.getClass().toString().equals("class model.ColorTransition")) {
            this.select_model = new ColorTransition(select_model, main, text);
        }
        stateDiagram.addModel(select_model);
        }

    }
}
