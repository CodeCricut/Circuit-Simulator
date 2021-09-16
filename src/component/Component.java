package component;

import tab.InputTab;
import tab.OutputTab;
import tab.InputTabUI;
import tab.OutputTabUI;
import tab.TabPositioner;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

  /*
        Responsibilities:
        * Holds the component UI, the logic strategy, and the input and output tabs
        * Provides a way to move both the component UI and the tabs at the same time
        * Provides a way to get the logical output, which is based on values of the input tabs.
     */

/**
 * A component is the base class for all components such as the ANDComponent and ORComponent. This class holds references
 * to the component's UI, logic, and input and output tabs.
 */
public abstract class Component extends StackPane {

    protected ComponentUI componentUI;

    private LogicStrategy logicStrategy;
    protected ArrayList<InputTab> inputTabs;
    private ArrayList<OutputTab> outputTabs;

    /** The default constructor may be called, but it is expected that all local variables should be set upon component
     * creation.
     */
    public Component(){
        logicStrategy = null;
        inputTabs = new ArrayList<>();
        outputTabs = new ArrayList<>();
    }

    public void setComponentUI(ComponentUI componentUI) {
        this.componentUI = componentUI;
        getChildren().add(componentUI);
        setLayoutX(componentUI.getRectangleBody().getX());
        setLayoutY(componentUI.getRectangleBody().getY());
    }

    public void setLogicStrategy(LogicStrategy logicStrategy) {
        this.logicStrategy = logicStrategy;
    }

    public void setInputTabs(ArrayList<InputTab> inputTabs) {
        this.inputTabs = inputTabs;
        for (InputTab inputTab : inputTabs) {
            inputTab.getTabUI().setFill(Color.RED);
            getChildren().add(inputTab.getTabUI());
        }
    }

    public void setOutputTabs(ArrayList<OutputTab> outputTabs) {
        this.outputTabs = outputTabs;
        for (OutputTab outputTab : outputTabs) {
            outputTab.getTabUI().setFill(Color.RED);
            getChildren().add(outputTab.getTabUI());
        }
    }

    public void setInputTabsVisibility(boolean visible){
        for (InputTab tab : inputTabs) {
            InputTabUI inputTab = (InputTabUI) tab.getTabUI();
            inputTab.setVisible(visible);
        }
    }

    public void setOutputTabsVisibility(boolean visible){
        for (OutputTab tab : outputTabs) {
            OutputTabUI outputTab = (OutputTabUI) tab.getTabUI();
            outputTab.setVisible(visible);
        }
    }


    /**
     * Move the component and all of its parts to the position.
     * @param x The left coordinate of the component.
     * @param y The top coordinate of the component.
     */
    public void move(int x, int y){
        setTranslateX(x);
        setTranslateY(y);

        for (InputTab inputTab : inputTabs) {
            inputTab.getTabUI().moveConnection();
        }

        for (OutputTab outputTab : outputTabs) {
            outputTab.getTabUI().moveConnection();
        }
    }

    // in componentui
//    public void move(int x, int y) {
//        // Move the component body
//        componentUI.move(x, y);
//
//        // Move th input tabs
//        for (int i = 0; i < inputTabs.size(); i++){
//            inputTabs.get(i).move(TabPositioner.getInputX(x),
//                    TabPositioner.getInputY(y, i));
//        }
//
//        // Move the output tabs
//        for (int i = 0; i < outputTabs.size(); i++){
//            outputTabs.get(i).move(TabPositioner.getOutputX(x, (int) Math.round(componentUI.getWidth())),
//                    TabPositioner.getOutputY(y, (int) Math.round(componentUI.getHeight()), outputTabs.size(), i));
//        }
//    }

    public boolean getLogicalOutput() {
        boolean[] inputsValues = new boolean[inputTabs.size()];
        for (int i = 0; i < logicStrategy.getNumOfInputs(); i++) {
            inputsValues[i] = inputTabs.get(i).getValue();
        }
        return logicStrategy.getOutput(inputsValues);
    }

}



