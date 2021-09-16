package tab;


import javafx.geometry.Bounds;

public class InputTabUI extends TabUI {

    public InputTabUI(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    @Override
    public void moveConnection() {
        Bounds boundsInScene = localToScene(getBoundsInLocal());
        if (connectionUI != null) {
            connectionUI.setEndX(boundsInScene.getMinX());
            connectionUI.setEndY(boundsInScene.getMinY());
        }
    }
}
