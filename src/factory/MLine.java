package factory;


import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class MLine extends Line implements BaseElement {
    public MLine() {
        super(7, 50, 97, 50);
        create();
    }

    public void create() {
        setStrokeWidth(2);
    }

    @Override
    public Shape getshape() {
        return this;
    }
}
