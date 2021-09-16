package connection;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class ConnectionUI extends Line {

    public ConnectionUI(int startX, int startY,
                        int endX, int endY){
        setStartX(startX);
        setStartY(startY);
        setEndX(endX);
        setEndY(endY);
    }

    public void turnOn(){
        setStroke(Color.GREEN);
    }

    public void turnOff(){
        setStroke(Color.BLACK);
    }
}
