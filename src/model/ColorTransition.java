package model;

import builder.Modelsupervier;
import builder.TransitionBuilder;
import factory.*;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class ColorTransition extends ColorModle {
    public ColorTransition(Model model, Paint paintmain, Paint painttext) {
        super(model,paintmain,painttext);
        paint();
    }
    protected void paint() {
        model.getLine().setStroke(paintmain);
        model.getArrow().setFill(paintmain);
        model.getText().setFill(painttext);
    }
    @Override
    public Model clone() {
        ColorTransition model1 = new ColorTransition( model.clone(),paintmain,painttext);
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
        return null;
    }

    @Override
    public MLine getLine() {
        return model.getLine();
    }

    @Override
    public Anchor getStart() {
        return model.getStart();
    }

    @Override
    public Anchor getEnd() {
        return model.getEnd();
    }

    @Override
    public Arrow getArrow() {
        return model.getArrow();
    }
}
