package factory;

import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BaseFactory {
    public BaseElement getelement(String name){
        switch (name.toString()){
            case ("Circle"):
                return new MCircle();
            case ("Line"):
                return new MLine();
            case ("Text"):
                return new MText("transition");
            case ("SText"):
                return new MText("state");
        }
        return null;
    }
    public BaseElement getelement(String name,Line line,Arrow arrow){
        if (name.equals("StartAnchor")){
            return new Anchor(line.startXProperty(),line.startYProperty(),arrow);
        }else if (name.equals("EndAnchor")){
            return new Anchor(line.endXProperty(),line.endYProperty(),arrow);
        }
        return null;
    }
    public BaseElement getelement(String name, Text text, Line line){
        if (name.equals("Arrow")){
            return new Arrow(text,line);
        }
        return null;
    }
}
