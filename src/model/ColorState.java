package model;

import builder.Modelsupervier;
import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class ColorState extends ColorModle{
    State state;
    public ColorState(Model state, Paint paintmain, Paint painttext) {
        this.state = (State) state;
        this.paintmain = paintmain;
        this.painttext = painttext;
        paint();
    }
    @Override
    protected void paint() {
        state.getCircle().setFill(paintmain);
        state.getText().setFill(painttext);
    }
    @Override
    protected Model clone() {
        Modelsupervier modelsupervier = new Modelsupervier();
        modelsupervier.state_contruct();
        State state = modelsupervier.getStateModel();
        ColorState model = new ColorState(state,paintmain,painttext);
        model.setOrgSceneX(orgSceneX);
        model.setOrgSceneY(orgSceneY);
        model.setOrgTranslateX(orgTranslateX);
        model.setOrgTranslateY(orgTranslateY);
        model.getGroup().setTranslateX(getGroup().getTranslateX());
        model.getGroup().setTranslateY(getGroup().getTranslateY());
        model.getText().setText(getText().getText());
        return model;
    }

    @Override
    public Group getGroup() {
        return state.getGroup();
    }

    @Override
    public Group getGroup2() {
        return state.getGroup2();
    }

    @Override
    public Text getText() {
        return state.getText();
    }
}
