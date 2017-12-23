package bridge;

import javafx.scene.layout.AnchorPane;
import model.Model;

public interface GuiBridge {
    void addstate(AnchorPane anchorPane, Model model);

    void addstransition(AnchorPane anchorPane, Model model);

    void delete(AnchorPane anchorPane, Model model);
}
