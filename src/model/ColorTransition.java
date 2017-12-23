package model;

import builder.Modelsupervier;
import builder.TransitionBuilder;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class ColorTransition extends ColorModle {
    public ColorTransition(Model transition, Paint paintmain,Paint paintmain2, Paint painttext) {
        this.painttext = painttext;
        this.paintmain = paintmain;
        this.paintmain2 = paintmain2;
        this.transition = (Transition) transition;
        paint();
    }
    protected void paint() {
        transition.getLine().setStroke(paintmain);
        transition.getArrow().setFill(paintmain2);
        transition.getText().setFill(painttext);
    }
    @Override
    protected Model clone() {
        Modelsupervier modelsupervier = new Modelsupervier();
        modelsupervier.transition_contuct();
        Transition transition = modelsupervier.getTransition();
        ColorTransition model = new ColorTransition(transition,paintmain,paintmain2,painttext);
        model.setOrgSceneX(orgSceneX);
        model.setOrgSceneY(orgSceneY);
        model.setOrgTranslateX(orgTranslateX);
        model.setOrgTranslateY(orgTranslateY);
        model.getGroup().setTranslateX(this.getGroup().getTranslateX());
        model.getGroup().setTranslateY(this.getGroup().getTranslateY());
        model.getText().setText(getText().getText());
        model.getGroup2().setTranslateX(this.transition.getGroup2().getTranslateX());
        model.getGroup2().setTranslateY(this.transition.getGroup2().getTranslateY());
        transition.getStart().setCenterX(this.transition.getStart().getCenterX());
        transition.getStart().setCenterY(this.transition.getStart().getCenterY());
        transition.getEnd().setCenterX(this.transition.getEnd().getCenterX());
        transition.getEnd().setCenterY(this.transition.getEnd().getCenterY());
        transition.getArrow().update();
        return model;
    }
    @Override
    public Group getGroup() {
        return transition.getGroup();
    }

    @Override
    public Group getGroup2() {
        return transition.getGroup2();
    }

    @Override
    public Text getText() {
        return transition.getText();
    }
}
