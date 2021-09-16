package main;


import component.Component;
import connection.ConnectionLogic;
import tab.InputTabLogic;
import tab.OutputTabLogic;
import connection.Connection;
import tab.Tab;
import connection.ConnectionUI;
import tab.TabUI;
import factory.ComponentFactory;
import factory.ConnectionFactory;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import component.ComponentEnum;

import java.util.ArrayList;


/*
    Responsibilities:
    * Keep track of the current state (adding component, clicking on input/output, etc)
    * Add component.components when click on button the screen
    * Displaying buttons and managing the clicks
    * Add connections and component.components
    * Add nodes (displayables) to the canvas
 */

public class ComponentPanel extends Group {

    private boolean addingComponent = false;
    private boolean selectingInput = false;
    private boolean selectingOutput = false;

    private ComponentEnum componentType;

    private Tab connectionInput;
    private Tab connectionOutput;

    private ArrayList<Component> components = new ArrayList<>();

    public ComponentPanel(Canvas canvas) {
        canvas.setOnMouseClicked(event -> {
            if (addingComponent) {
                // Adding component
                double x = event.getX();
                double y = event.getY();

                addComponent((int) x, (int) y);
            }
        });


        VBox componentButtonVBox = new VBox();
        componentButtonVBox.setPrefWidth(150);

        Button toggleButton = new Button("TOGGLE");
        toggleButton.prefWidthProperty().bind(componentButtonVBox.widthProperty());
        toggleButton.setOnAction(event -> {
            addingComponent = true;
            componentType = ComponentEnum.TOGGLE;
        });

        Button variableButton = new Button("VAR");
        variableButton.prefWidthProperty().bind(componentButtonVBox.widthProperty());
        variableButton.setOnAction(event -> {
            addingComponent = true;
            componentType = ComponentEnum.VARIABLE;
        });

        Button clockButton = new Button("CLOCK");
        clockButton.prefWidthProperty().bind(componentButtonVBox.widthProperty());
        clockButton.setOnAction(event -> {
            addingComponent = true;
            componentType = ComponentEnum.CLOCK;
        });

        Button debugButton = new Button("DEBUG");
        debugButton.prefWidthProperty().bind(componentButtonVBox.widthProperty());
        debugButton.setOnAction(event -> {
            addingComponent = true;
            componentType = ComponentEnum.DEBUG;
        });

        Button andButton = new Button("AND");
        andButton.prefWidthProperty().bind(componentButtonVBox.widthProperty());
        andButton.setOnAction(event -> {
            addingComponent = true;
            componentType = ComponentEnum.AND;
        });

        Button orButton = new Button("OR");
        orButton.prefWidthProperty().bind(componentButtonVBox.widthProperty());
        orButton.setOnAction(event -> {
            addingComponent = true;
            componentType = ComponentEnum.OR;
        });

        Button notButton = new Button("NOT");
        notButton.prefWidthProperty().bind(componentButtonVBox.widthProperty());
        notButton.setOnAction(event -> {
            addingComponent = true;
            componentType = ComponentEnum.NOT;
        });

        Button nandButton = new Button("NAND");
        nandButton.prefWidthProperty().bind(componentButtonVBox.widthProperty());
        nandButton.setOnAction(event -> {
            addingComponent = true;
            componentType = ComponentEnum.NAND;
        });

        Button norButton = new Button("NOR");
        norButton.prefWidthProperty().bind(componentButtonVBox.widthProperty());
        norButton.setOnAction(event -> {
            addingComponent = true;
            componentType = ComponentEnum.NOR;
        });

        Button xorButton = new Button("XOR");
        xorButton.prefWidthProperty().bind(componentButtonVBox.widthProperty());
        xorButton.setOnAction(event -> {
            addingComponent = true;
            componentType = ComponentEnum.XOR;
        });

        Button equalButton = new Button("EQUAL");
        equalButton.prefWidthProperty().bind(componentButtonVBox.widthProperty());
        equalButton.setOnAction(event -> {
            addingComponent = true;
            componentType = ComponentEnum.EQUIVALENCE;
        });

        Button nibbleDisplayButton = new Button("NIBBLE DISPLAY");
        nibbleDisplayButton.prefWidthProperty().bind(componentButtonVBox.widthProperty());
        nibbleDisplayButton.setOnAction(event -> {
            addingComponent = true;
            componentType = ComponentEnum.NIBBLE_DISPLAY;
        });

        Button addConnectionButton = new Button("Add Connection");
        addConnectionButton.prefWidthProperty().bind(componentButtonVBox.widthProperty());
        addConnectionButton.setOnAction(event -> setSelectingInput(true));

        componentButtonVBox.getChildren().addAll(toggleButton, variableButton, clockButton, debugButton, andButton,
                orButton, notButton, nandButton, norButton, xorButton, equalButton, nibbleDisplayButton, addConnectionButton);

        addNode(componentButtonVBox);
    }



    public void inputClicked(Tab inputTab) {
        InputTabLogic tabLogic = (InputTabLogic) inputTab.getTabLogic();
        if (selectingInput && tabLogic.isAvailable()) {
            System.out.println("Input tab selected");
            connectionInput = inputTab;
            setSelectingInput(false);
            setSelectingOutput(true);
        }
    }

    public void outputClicked(Tab outputTab) {
        if (selectingOutput) {
            System.out.println("Output tab selected");
            connectionOutput = outputTab;
            setSelectingOutput(false);
            createConnection();
        }
    }

    private void setSelectingInput(boolean s) {
        addingComponent = false;
        if (s) {
            selectingInput = true;
            for (Component component : getComponents()) {
                component.setInputTabsVisibility(true);
                component.setOutputTabsVisibility(false);
            }
        } else {
            for (Component component : getComponents()) {
                component.setOutputTabsVisibility(true);
            }
            selectingInput = false;
        }
    }

    private void setSelectingOutput(boolean s) {
        addingComponent = false;
        if (s) {
            selectingOutput = true;
            for (Component component : getComponents()) {
                component.setOutputTabsVisibility(true);
                component.setInputTabsVisibility(false);
            }
        } else {
            for (Component component : getComponents()) {
                component.setInputTabsVisibility(true);
            }
            selectingOutput = false;
            selectingInput = true;
        }
    }

    private void createConnection() {
        if (connectionInput == null ||
                connectionOutput == null)
            System.err.println("Trying to create connection without input or output tabs selected");
        else {
            OutputTabLogic outputTabLogic = (OutputTabLogic) connectionOutput.getTabLogic();
            TabUI outputTabUI = connectionOutput.getTabUI();
            InputTabLogic inputTabLogic = (InputTabLogic) connectionInput.getTabLogic();
            TabUI inputTabUI = connectionInput.getTabUI();

            ConnectionUI connectionUI = ConnectionFactory.createConnectionUI(
                    Math.round(outputTabUI.getGlobalX()), Math.round(outputTabUI.getGlobalY()),
                    Math.round(inputTabUI.getGlobalX()), Math.round(inputTabUI.getGlobalY()));

            ConnectionLogic connectionLogic = ConnectionFactory.createConnectionLogic(
                    inputTabLogic, outputTabLogic, connectionUI);

            Connection connection = ConnectionFactory.createConnection(connectionUI, connectionLogic);

            inputTabUI.setConnectionUI(connectionUI);
            outputTabUI.setConnectionUI(connectionUI);

            addNode(connectionUI);

            setSelectingInput(false);
            setSelectingOutput(false);
        }
    }

    private void addComponent(int x, int y) {
        Component component = ComponentFactory.createComponent(componentType, x, y);
        addNode(component);
        components.add(component);
    }

    public void addNode(Node node) {
        getChildren().add(node);
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

}