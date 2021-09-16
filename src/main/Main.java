package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;


/*
    Responsibilities:
    * Set up the JavaFX stage/scene
    * Create a component panel and logic thread
    * Start the logic thread, and show the component panel
 */

public class Main extends Application {

    public static ComponentPanel componentPanel;

    private static LogicThread logicThread;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Canvas canvas = new Canvas(900, 900);

        componentPanel = new ComponentPanel(canvas);
        logicThread = new LogicThread();
        logicThread.start();

        root.getChildren().addAll(canvas, componentPanel);

        Scene scene = new Scene(root, 900, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }

    public static ComponentPanel getComponentPanel() {
        return componentPanel;
    }

    public static LogicThread getLogicThread() {
        return logicThread;
    }
}
