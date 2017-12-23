package command;

import javafx.scene.layout.AnchorPane;
import model.Model;

public class Delete implements GuiCommand{
    @Override
    public void execute(AnchorPane anchr, Model model) {
        anchr.getChildren().remove(model.getGroup());
        anchr.getChildren().remove(model.getGroup2());
    }
}
