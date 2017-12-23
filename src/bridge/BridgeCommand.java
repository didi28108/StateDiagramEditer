package bridge;

import command.AddState;
import command.AddTransition;
import command.Delete;
import javafx.scene.layout.AnchorPane;
import model.Model;

public class BridgeCommand implements GuiBridge{

    @Override
    public void addstate(AnchorPane anchorPane, Model model) {
        AddState addState = new AddState();
        addState.execute(anchorPane,model);
    }

    @Override
    public void addstransition(AnchorPane anchorPane,Model model) {
        AddTransition addTransition = new AddTransition();
        addTransition.execute(anchorPane,model);
    }

    @Override
    public void delete(AnchorPane anchorPane,Model model) {
        Delete delete = new Delete();
        delete.execute(anchorPane,model);
    }
}
