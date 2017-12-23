package model;

import javafx.scene.paint.Paint;

public abstract class ColorModle extends Model{
    State state;
    Transition transition;
    protected Paint paintmain,paintmain2,painttext;
    protected abstract void paint();
}
