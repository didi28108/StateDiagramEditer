package model;

import javafx.scene.paint.Paint;

public abstract class ColorModle extends Model{
    protected Model model;
    protected Paint paintmain,painttext;
    protected abstract void paint();
    public ColorModle(Model model, Paint paintmain, Paint painttext) {
        this.model =model;
        this.paintmain = paintmain;
        this.painttext = painttext;
    }
}
