package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("State editer");
        primaryStage.show();
        GuiController controller = new GuiController();
        GuiView guiView = new GuiView(primaryStage,controller);
        guiView.create();
        controller.setGuiView(guiView);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
