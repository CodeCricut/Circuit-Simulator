package tab;


import connection.ConnectionUI;
import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

public abstract class TabUI extends Rectangle {

    ConnectionUI connectionUI;

    TabUI(int x, int y, int w, int h) {
        // Should this be transform?
        setTranslateX(x);
        setTranslateY(y);
        setWidth(w);
        setHeight(h);
    }

    public abstract void moveConnection();

    public int getGlobalX() {
        Bounds boundsInScene = this.localToScene(this.getBoundsInLocal());
        return (int) boundsInScene.getMinX();
    }

    public int getGlobalY() {
        Bounds boundsInScene = this.localToScene(this.getBoundsInLocal());
        return (int) boundsInScene.getMinY();
    }

    public void setConnectionUI(ConnectionUI connectionUI) {
        this.connectionUI = connectionUI;
    }

}
