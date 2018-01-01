package model;

import builder.Modelsupervier;
import builder.StateBuilder;
import factory.*;
import javafx.scene.Group;

public class State extends Model {
    MText text;
    MCircle circle;
    Group group;
    public State(MText text, MCircle circle,Group group){
        this.text = text;
        this.circle = circle;
        this.group = group;
    }
    public Model clone(){
        Modelsupervier modelsupervier = new Modelsupervier(new StateBuilder());
        modelsupervier.contruct();
        State model = (State) modelsupervier.getModel();
        model.setOrgSceneX(orgSceneX);
        model.setOrgSceneY(orgSceneY);
        model.setOrgTranslateX(orgTranslateX);
        model.setOrgTranslateY(orgTranslateY);
        model.getGroup().setTranslateX(getGroup().getTranslateX());
        model.getGroup().setTranslateY(getGroup().getTranslateY());
        model.getText().setText(getText().getText());
        return model;
    }
    public MCircle getCircle() {
        return circle;
    }

    @Override
    public MLine getLine() {
        return null;
    }

    @Override
    public Anchor getStart() {
        return null;
    }

    @Override
    public Anchor getEnd() {
        return null;
    }

    @Override
    public Arrow getArrow() {
        return null;
    }

    public MText getText() {
        return text;
    }
    public Group getGroup() {
        return group;
    }
    @Override
    public Group getGroup2() {
        return group;
    }
}
