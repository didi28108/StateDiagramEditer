package sample;

import bridge.BridgeCommand;
import builder.Modelsupervier;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import memento.Originator;
import model.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

import java.util.Optional;

public class GuiController {
    BridgeCommand bridgeCommand;
    Originator originator;
    StateDiagram stateDiagram;
    Model select_model=null,pre_model;
    GuiView guiView;
    Modelsupervier modelsupervier;
    ModelListener modelListener;
    public GuiController() {
        modelsupervier= new Modelsupervier();
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
        statediagram_save(anchr);;
        modelsupervier.state_contruct();
        Model model = modelsupervier.getStateModel();
        if (!(main.equals(Color.BLACK)&&text.equals(Color.BLACK))){
            model = new ColorState(model,main,text);
        }
        modelListener = new ModelListener(this);
        modelListener.setlistener(model);
        stateDiagram.addModel(model);
        bridgeCommand.addstate(anchr, model);
        System.out.println("State add -> diagram save");
    }
    public void transition_press(AnchorPane anchr,Color main,Color text) {
        statediagram_save(anchr);
        modelsupervier.transition_contuct();
        Model model = modelsupervier.getTransition();
        if (!main.equals(Color.BLACK)){
            model =  new ColorTransition(model,main,main,text);
        }
        modelListener = new ModelListener(this);
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
}
