package factory;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class MCircle extends Circle implements BaseElement {
    public MCircle(){
        super(50,50,50.0f, Color.TRANSPARENT);
        create();
    }
    public void create() {
        setStrokeWidth(2);
        setStroke(Color.BLACK);
        setFill(Color.WHITE);
    }

    @Override
    public Shape getshape() {
        return this;
    }
}
