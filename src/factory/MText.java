package factory;

import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MText extends Text implements BaseElement {
    public MText(String name){
        super(name);
        create();
    }
    public void create() {
        setFont(Font.font(null, FontWeight.BOLD, 18));
        if (getText().equals("state")) {
           setTranslateX(35);
           setTranslateY(58);
        }
    }
    @Override
    public Shape getshape() {
        return this;
    }
}
