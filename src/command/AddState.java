package command;

import javafx.scene.layout.AnchorPane;
import model.Model;

public class AddState implements GuiCommand{
    @Override
    public void execute(AnchorPane anchr, Model model) {
        anchr.getChildren().add(model.getGroup());
    }
}
