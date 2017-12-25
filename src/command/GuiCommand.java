package command;

import javafx.scene.layout.AnchorPane;
import model.Model;

public interface GuiCommand {
   void execute(AnchorPane anchr, Model model);
}
