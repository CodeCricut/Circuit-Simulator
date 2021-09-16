package tab;

import javafx.geometry.Bounds;

public class OutputTabUI extends TabUI {
    public OutputTabUI(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    @Override
    public void moveConnection() {
        Bounds boundsInScene = localToScene(getBoundsInLocal());
        if (connectionUI != null) {
            connectionUI.setStartX(boundsInScene.getMinX());
            connectionUI.setStartY(boundsInScene.getMinY());
        }
    }
}
