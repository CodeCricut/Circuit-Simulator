package component;

import javafx.scene.input.MouseEvent;
import tab.InputTabUI;
import tab.OutputTabUI;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;


public class ComponentUI extends StackPane {

     /*
        Responsibilities:
        * Display the component body and label
     */


    private Component attachedComponent;
    private Rectangle rectangleBody;
    private Label label;


    private ArrayList<InputTabUI> inputTabs;
    private ArrayList<OutputTabUI> outputTabs;

    public ComponentUI(Component attachedComponent, String componentName, ArrayList<InputTabUI> inputs, ArrayList<OutputTabUI> outputs,
                       int w, int h) {
        this.attachedComponent = attachedComponent;

        inputTabs = inputs;
        outputTabs = outputs;

        rectangleBody = new Rectangle(0, 0, w, h);
        //rectangleBody.setOnMouseClicked(event -> this.toFront());
        rectangleBody.setOnMouseDragged(this::moveComponentOnDrag);

        label = new Label(componentName);
        label.setOnMouseDragged(this::moveComponentOnDrag);
        label.setTextFill(Color.WHITE);
        label.toFront();

        getChildren().addAll(rectangleBody, label);
    }

    private void moveComponentOnDrag(MouseEvent event){
        if (event.getButton() == MouseButton.PRIMARY) {
            double offsetX = event.getSceneX();
            double offsetY = event.getSceneY();

            offsetX = ComponentPositioner.getCenterX((int) offsetX);
            offsetY = ComponentPositioner.getCenterY((int) offsetY);

            attachedComponent.move((int) offsetX, (int) offsetY);
        }
    }

    public Rectangle getRectangleBody() {
        return rectangleBody;
    }

    public ArrayList<InputTabUI> getInputTabs() {
        return inputTabs;
    }

    public ArrayList<OutputTabUI> getOutputTabs() {
        return outputTabs;
    }


    public void setLabel(String s) {
        label.setText(s);
    }

//    private void setupTabs() {
//        for (int i = 0; i < logicStrategy.getNumOfInputs(); i++) {
//            InputTab inputTab = TabFactory.createInput(this, -1, -1);
//            inputTabs.add(inputTab);
//            Main.getComponentPanel().addNode(inputTab);
//        }
//        for (int i = 0; i < logicStrategy.getNumOfOutputs(); i++) {
//            Tab outputTab = TabFactory.createOutput(this, -1, -1);
//            outputs.add(outputTab);
//            Main.getComponentPanel().addNode(outputTab);
//        }
//    }

//    public boolean getLogicalOutput() {
//        boolean[] inputsValues = new boolean[inputTabs.size()];
//        for (int i = 0; i < logicStrategy.getNumOfInputs(); i++) {
//
//            inputsValues[i] = inputTabs.get(i).getValue();
//        }
//        return logicStrategy.getOutput(inputsValues);
//    }

}
