package model;

import builder.Modelsupervier;
import factory.MCircle;
import factory.MText;
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
        Modelsupervier modelsupervier = new Modelsupervier();
        modelsupervier.state_contruct();
        State model = modelsupervier.getStateModel();
        model.setOrgSceneX(orgSceneX);
        model.setOrgSceneY(orgSceneY);
        model.setOrgTranslateX(orgTranslateX);
        model.setOrgTranslateY(orgTranslateY);
        model.getGroup().setTranslateX(getGroup().getTranslateX());
        model.getGroup().setTranslateY(getGroup().getTranslateY());
        model.getText().setText(getText().getText());
        /*System.out.println(group+" "+group.getTranslateX()+" "+group.getTranslateY()+" "+text.getText()+" -> " +
        model.getGroup()+""+model.getGroup().getTranslateX()+" "+model.getGroup().getTranslateY()+" "+model.getText().getText());*/
        return model;
    }
    public MCircle getCircle() {
        return circle;
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
