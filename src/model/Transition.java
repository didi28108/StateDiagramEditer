package model;

import builder.Modelsupervier;
import factory.Anchor;
import factory.Arrow;
import factory.MLine;
import factory.MText;
import javafx.scene.Group;

public class Transition extends Model {
    MText text;
    MLine line;
    Anchor start,end;
    Arrow arrow;
    Group group1,group2;
    public Transition(MText text, MLine line, Anchor start, Anchor end, Arrow arrow, Group group1, Group group2){
        this.text = text;
        this.line = line;
        this.start = start;
        this.end = end;
        this.arrow = arrow;
        this.group1 = group1;
        this.group2 = group2;
    }
    public Model clone(){
        Modelsupervier modelsupervier = new Modelsupervier();
        modelsupervier.transition_contuct();
        Transition model = modelsupervier.getTransition();
        model.setOrgSceneX(orgSceneX);
        model.setOrgSceneY(orgSceneY);
        model.setOrgTranslateX(orgTranslateX);
        model.setOrgTranslateY(orgTranslateY);
        model.getGroup().setTranslateX(this.group1.getTranslateX());
        model.getGroup().setTranslateY(this.group1.getTranslateY());
        model.getText().setText(getText().getText());
        model.getGroup2().setTranslateX(this.group2.getTranslateX());
        model.getGroup2().setTranslateY(this.group2.getTranslateY());
        model.getStart().setCenterX(this.getStart().getCenterX());
        model.getStart().setCenterY(this.getStart().getCenterY());
        model.getEnd().setCenterX(this.getEnd().getCenterX());
        model.getEnd().setCenterY(this.getEnd().getCenterY());
        model.getArrow().update();
        return model;
    }

    @Override
    public Group getGroup() {
        return group1;
    }

    @Override
    public Group getGroup2() {
        return group2;
    }

    public MText getText() {
        return text;
    }
    public MLine getLine() {
        return line;
    }
    public Anchor getStart() {
        return start;
    }
    public Anchor getEnd() {
        return end;
    }
    public Arrow getArrow() {
        return arrow;
    }
}
