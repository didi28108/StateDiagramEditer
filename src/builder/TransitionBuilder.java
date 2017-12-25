package builder;

import factory.*;
import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import model.Model;
import model.Transition;

public class TransitionBuilder implements ModelBuilder {
    Group group,group2;
    BaseFactory baseFactory;
    BaseElement text,line,start,end,arrow;
    Transition transition;
    public TransitionBuilder(){
        baseFactory = new BaseFactory();
        group = new Group();
        group2 = new Group();
    }
    @Override
    public void createText() {
        text = baseFactory.getelement("Text");
    }

    @Override
    public void createMain() {
        line = baseFactory.getelement("Line");
        arrow = baseFactory.getelement("Arrow",(Text)text.getshape(),(Line)line.getshape());
    }

    @Override
    public void addelse() {
        start = baseFactory.getelement("StartAnchor",(Line)line.getshape(),(Arrow)arrow.getshape());
        end = baseFactory.getelement("EndAnchor",(Line)line.getshape(),(Arrow)arrow.getshape());
    }

    @Override
    public void combined() {
        group.getChildren().addAll(text.getshape(),line.getshape(),arrow.getshape());
        group2.getChildren().addAll(start.getshape(),end.getshape());
        transition = new Transition((MText)text,(MLine)line,(Anchor)start,(Anchor) end,(Arrow)arrow,group,group2);
    }

    @Override
    public Model getModle() {
        return transition;
    }

}
