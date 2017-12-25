package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import memento.Originator;

import java.io.IOException;

public class GuiView {
    @FXML
    Button btn_new,btn_undo,btn_redo,btn_edit,btn_delete,btn_state,btn_transition;
    @FXML
    ColorPicker main_colorPicker,text_colorPicker;
    @FXML
    TextField textField;
    GuiController controller;
    Stage stage;
    Scene scene;
    AnchorPane anchorPane;
    ToolBar toolBar;
    BorderPane borderPane;
    public GuiView(Stage stage, GuiController controller){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ToolBar.fxml"));
            loader.setController(this);
            toolBar = loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        anchorPane = new AnchorPane();
        borderPane = new BorderPane();
        this.stage = stage;
        this.controller = controller;
    }
    void create() {
        try {
            anchorPane.setPrefHeight(520);
            anchorPane.setPrefWidth(1024);
            anchorPane.setOnDragDetected(event -> dragdone(event));
            anchorPane.setOnMouseClicked(event -> current(event));
            borderPane.setCenter(anchorPane);
            borderPane.setTop(toolBar);
            scene = new Scene(borderPane, 1024, 512);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void dragdone(Event event) {
        String classneme = event.getTarget().getClass().toString();
        if(classneme.equals("class factory.MText")||classneme.equals("class factory.MCircle")||classneme.equals("class factory.MLine")||classneme.equals("class factory.Anchor")){
            controller.statediagram_save(anchorPane);
            System.out.println("Dragged -> Saved");
        }
    }
    public void current(MouseEvent event){
        String classneme = event.getTarget().getClass().toString();
        if(classneme.equals("class factory.MText")||classneme.equals("class factory.MCircle")||classneme.equals("class factory.MLine")||classneme.equals("class factory.Anchor")){
            System.out.println("Selected");
            controller.selectGlow();
        }else {
            controller.setSelect_model(null);
        }
    }
    public void new_press(ActionEvent event) {
        controller.new_press(anchorPane);
    }
    public void edit_press(ActionEvent event){
        controller.edit_press(anchorPane,textField.getText());
    }
    public void redo_press(ActionEvent event) {
        controller.redo_press(anchorPane);
    }
    public void undo_press(ActionEvent event) {
        controller.undo_press(anchorPane);
    }
    public void delete_press(ActionEvent event) {
        controller.delete_press(anchorPane);
    }
    public void state_press(ActionEvent event) {
        controller.state_press(anchorPane,main_colorPicker.getValue(),text_colorPicker.getValue());
    }
    public void transition_press(ActionEvent event) {
        controller.transition_press(anchorPane,main_colorPicker.getValue(),text_colorPicker.getValue());
    }



}
