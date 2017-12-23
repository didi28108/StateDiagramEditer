package builder;

import factory.*;
import javafx.scene.Group;
import model.Model;
import model.State;

public class StateBuilder implements ModelBuilder {
    Group group;
    BaseElement text,circle;
    BaseFactory baseFactory;
    State state;
    public StateBuilder(){
        baseFactory = new BaseFactory();
        group = new Group();
    }
    @Override
    public void createText() {
        text = baseFactory.getelement("SText");
        //text =  new MText("state").getText();
    }
    @Override
    public void createMain() {
        circle = baseFactory.getelement("Circle");
        //circle = new MCircle().getCircle();
    }
    @Override
    public void addelse() {    }

    @Override
    public void combined() {
        group.getChildren().addAll(circle.getshape(),text.getshape());
        state = new State((MText)text,(MCircle)circle,group);
    }
    @Override
    public Model getModle() {
        return state;
    }
}
