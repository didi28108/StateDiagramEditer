package model;

import factory.*;
import javafx.scene.Group;
import javafx.scene.paint.Paint;

public class ColorState extends ColorModle{
    public ColorState(Model state, Paint paintmain, Paint painttext) {
        super(state,paintmain,painttext);
        paint();
    }
    @Override
    protected void paint() {
        model.getCircle().setFill(paintmain);
        model.getText().setFill(painttext);
    }
    @Override
    public Model clone() {
        ColorState model1 = new ColorState(model.clone(),paintmain,painttext);
        return model1;
    }

    @Override
    public Group getGroup() {
        return model.getGroup();
    }

    @Override
    public Group getGroup2() {
        return model.getGroup2();
    }

    @Override
    public MText getText() {
        return model.getText();
    }

    @Override
    public MCircle getCircle() {
        return model.getCircle();
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
}
