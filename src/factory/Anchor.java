package factory;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;

public class Anchor extends Circle implements BaseElement {
    double x,y,newX,newY;
    DoubleProperty dx,dy;
    Arrow arrow ;
    public Anchor(DoubleProperty xx, DoubleProperty yy,Arrow arrow) {
        super(xx.get(), yy.get(), 5);
        dx = xx;
        dy = yy;
        this.arrow = arrow;
        create();
        enableDrag();
    }
    private void enableDrag() {
        setOnMousePressed(mouseEvent -> {
            x = getCenterX() - mouseEvent.getX();
            y = getCenterY() - mouseEvent.getY();
            getScene().setCursor(Cursor.H_RESIZE);
        });
        setOnMouseReleased(mouseEvent -> getScene().setCursor(Cursor.H_RESIZE));
        setOnMouseDragged(mouseEvent -> {
            newX = mouseEvent.getX() + x;
                setCenterX(newX);
            newY = mouseEvent.getY() + y;
                setCenterY(newY);
                arrow.update();
        });
        setOnMouseEntered(mouseEvent -> {
            if (!mouseEvent.isPrimaryButtonDown()) {
                getScene().setCursor(Cursor.H_RESIZE);
            }
        });
        setOnMouseExited(mouseEvent -> {
            if (!mouseEvent.isPrimaryButtonDown()) {
                getScene().setCursor(Cursor.DEFAULT);
            }
        });
    }
    @Override
    public void create() {
        setFill(Color.LIGHTBLUE.deriveColor(1, 1, 1, 0.5));
        setStroke(Color.LIGHTBLUE);
        setStrokeWidth(2);
        setStrokeType(StrokeType.OUTSIDE);
        dx.bind(centerXProperty());
        dy.bind(centerYProperty());
    }
    @Override
    public Shape getshape() {
        return this;
    }
}