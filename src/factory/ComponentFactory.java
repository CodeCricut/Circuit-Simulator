package factory;

import component.Component;
import component.ComponentEnum;
import component.ComponentUI;
import component.LogicStrategy;
import tab.InputTabLogic;
import tab.OutputTabLogic;
import tab.InputTab;
import tab.OutputTab;
import component.ComponentPositioner;
import tab.InputTabUI;
import tab.OutputTabUI;
import component.components.*;
import component.logicStrats.*;
import main.Main;

import java.util.ArrayList;

public class ComponentFactory {

    /*
        Responsibilities:
        * Creates a component based on the componentType argument
        * Adds event logic to the component to deal with drags and clicks
     */

    public static Component createComponent(ComponentEnum componentType, int x, int y) {
        x = ComponentPositioner.getCenterX(x);
        y = ComponentPositioner.getCenterY(y);

        Component component = null;
        ComponentUI componentBody = null;
        LogicStrategy logicStrategy = null;
        switch (componentType) {
            case TOGGLE:
                component = new ToggleComponent();
                componentBody = createComponentBody(component,
                        "TOGGLE", 0, 1);
                logicStrategy = new ToggleStrategy();
                break;
            case AND:
                component = new ANDComponent();
                componentBody = createComponentBody(component,
                        "AND", 2, 1);
                logicStrategy = new ANDStrategy();
                break;
            case VARIABLE:
                component = new VARIABLEComponent();
                componentBody = createComponentBody(component,
                        "VARIABLE", 0, 1);
                logicStrategy = new VARIABLEStrategy();
                break;
            case CLOCK:
                component = new ClockComponent();
                componentBody = createComponentBody(component,
                        "CLOCK", 0, 1);
                logicStrategy = new ClockStrategy();
                break;
            case OR:
                component = new ORComponent();
                componentBody = createComponentBody(component,
                        "OR", 2, 1);
                logicStrategy = new ORStrategy();
                break;
            case DEBUG:
                component = new DEBUGComponent();
                componentBody = createComponentBody(component,
                        "DEBUG", 1, 0);
                logicStrategy = new DEBUGStrategy();
                Main.getLogicThread().addUpdatable((DEBUGComponent) component);
                break;
            case NOT:
                component = new NOTComponent();
                componentBody = createComponentBody(component,
                        "NOT", 1, 1);
                logicStrategy = new NOTStrategy();
                break;
            case NAND:
                component = new NANDComponent();
                componentBody = createComponentBody(component,
                        "NAND", 2, 1);
                logicStrategy = new NANDStrategy();
                break;
            case NOR:
                component = new NORComponent();
                componentBody = createComponentBody(component,
                        "NOR", 2, 1);
                logicStrategy = new NORStrategy();
                break;
            case XOR:
                component = new XORComponent();
                componentBody = createComponentBody(component,
                        "XOR", 2, 1);
                logicStrategy = new XORStrategy();
                break;
            case EQUIVALENCE:
                component = new EQUIVALENCEComponent();
                componentBody = createComponentBody(component,
                        "EQUAL", 2, 1);
                logicStrategy = new EQUIVALENCEStrategy();
                break;
            case NIBBLE_DISPLAY:
                component = new NibbleDisplayComponent();
                componentBody = createComponentBody(component,
                        "NIBBLE DISPLAY", 4, 0);
                logicStrategy = new NibbleDisplayStrategy();
                Main.getLogicThread().addUpdatable((NibbleDisplayComponent) component);
                break;
            default:
                try {
                    throw new UnnaccountedComponentStrategy();
                } catch (UnnaccountedComponentStrategy unnaccountedComponentStrategy) {
                    unnaccountedComponentStrategy.printStackTrace();
                    System.exit(-1);
                }
        }


        ArrayList<OutputTab> outputTabs = new ArrayList<>();
        for (int i = 0; i < componentBody.getOutputTabs().size(); i++){
            OutputTabUI outputTabUI = componentBody.getOutputTabs().get(i);
            OutputTabLogic outputTabLogic = TabFactory.createOutputTabLogic(component);
            Main.getLogicThread().addUpdatable(outputTabLogic);
            OutputTab outputTab = TabFactory.createOutputTab(outputTabUI, outputTabLogic);
            outputTabs.add(outputTab);
        }

        ArrayList<InputTab> inputTabs = new ArrayList<>();
        for (int i = 0; i < componentBody.getInputTabs().size(); i++){
            InputTabUI inputTabUI = componentBody.getInputTabs().get(i);
            InputTabLogic inputTabLogic = TabFactory.createInputTabLogic();
            Main.getLogicThread().addUpdatable(inputTabLogic);
            InputTab inputTab = TabFactory.createInputTab(inputTabUI, inputTabLogic);
            inputTabs.add(inputTab);
        }

        component.setComponentUI(componentBody);
        component.setLogicStrategy(logicStrategy);
        component.setInputTabs(inputTabs);
        component.setOutputTabs(outputTabs);

        if (component instanceof ToggleComponent){
            ((ToggleComponent) component).setToggleBehavior();
        }

        component.move(x, y);
        return component;
    }

    private static ComponentUI createComponentBody(Component attachedComponent, String componentName,
                                                   int numOfInputs, int numOfOutputs){
        ArrayList<InputTabUI> inputs = new ArrayList<>();
        for (int i = 0; i < numOfInputs; i++){
            inputs.add(TabFactory.createInputTabBody(i));
        }
        ArrayList<OutputTabUI> outputs = new ArrayList<>();
        for (int o = 0; o < numOfOutputs; o++){
            outputs.add(TabFactory.createOutputTabBody(numOfOutputs, o));
        }

        return new ComponentUI(attachedComponent, componentName, inputs, outputs,
                ComponentPositioner.getWidth(), ComponentPositioner.getHeight());
    }
}
