package factory;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

public class Arrow extends Polygon implements BaseElement {
    public float t;
    Rotate rz;
    Line line;
    Text text;
    public Arrow(Text text,Line line) {
        super(0,0,10,20,-10,20);
        this.line = line;
        this.t =1f;
        this.text = text;
        create();
    }
    @Override
    public void create() {
        setFill(Color.BLACK);
        rz = new Rotate();
        {
            rz.setAxis(Rotate.Z_AXIS);
        }
        getTransforms().addAll(rz);
        setTranslateX(line.getEndX());
        setTranslateY(line.getEndY());
        update();
    }
    public void update() {
        double size = Math.max(line.getBoundsInLocal().getWidth(), line.getBoundsInLocal().getHeight());
        double scale = size / 4d;
        Point2D ori = eval(line, t);
        Point2D tan = evalDt(line, t).normalize().multiply(scale);
        setTranslateX(ori.getX());
        setTranslateY(ori.getY());
        double angle = Math.atan2( tan.getY(), tan.getX());
        angle = Math.toDegrees(angle);
        // arrow origin is top => apply offset
        double offset = -90;
        if( t > 0.5)
            offset = +90;
        rz.setAngle(angle + offset);
        txetpos();
    }
    private void txetpos(){
        text.setTranslateX((line.getStartX()-70+line.getEndX())/2);
        text.setTranslateY((line.getStartY()+line.getEndY())/2-5);
    }
    /**
     * Evaluate the cubic curve at a parameter 0<=t<=1, returns a Point2D
     * @param c the CubicCurve
     * @param t param between 0 and 1
     * @return a Point2D
     */
    private Point2D eval(Line c, float t){
        Point2D p=new Point2D(Math.pow(1-t,3)*c.getStartX()+
                3*t*Math.pow(1-t,2)*c.getStartX()+
                3*(1-t)*t*t*c.getStartX()+
                Math.pow(t, 3)*c.getEndX(),
                Math.pow(1-t,3)*c.getStartY()+
                        3*t*Math.pow(1-t, 2)*c.getStartY()+
                        3*(1-t)*t*t*c.getStartY()+
                        Math.pow(t, 3)*c.getEndY());
        return p;
    }

    /**
     * Evaluate the tangent of the cubic curve at a parameter 0<=t<=1, returns a Point2D
     * @param c the CubicCurve
     * @param t param between 0 and 1
     * @return a Point2D
     */
    private Point2D evalDt(Line c, float t){
        Point2D p=new Point2D(-3*Math.pow(1-t,2)*c.getStartX()+
                3*(Math.pow(1-t, 2)-2*t*(1-t))*c.getStartX()+
                3*((1-t)*2*t-t*t)*c.getStartX()+
                3*Math.pow(t, 2)*c.getEndX(),
                -3*Math.pow(1-t,2)*c.getStartY()+
                        3*(Math.pow(1-t, 2)-2*t*(1-t))*c.getStartY()+
                        3*((1-t)*2*t-t*t)*c.getStartY()+
                        3*Math.pow(t, 2)*c.getEndY());
        return p;
    }


    @Override
    public Shape getshape() {
        return this;
    }
}
