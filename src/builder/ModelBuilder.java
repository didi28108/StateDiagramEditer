package builder;


import factory.Anchor;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import model.Model;


public interface ModelBuilder {
    void createText();
    void createMain();
    void combined();
    Model getModle();
}
