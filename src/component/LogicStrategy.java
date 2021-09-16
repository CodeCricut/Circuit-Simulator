package component;

/*
    Responsibilities:
    * Provides an interface for component.components to get the logical output according to the way they work.
    * Dictates how many inputTabs and outputs component.components can/should have
 */

public abstract class LogicStrategy {

    private int numOfInputs, numOfOutputs;

    public LogicStrategy(int numOfInputs, int numOfOutputs) {
        this.numOfInputs = numOfInputs;
        this.numOfOutputs = numOfOutputs;
    }

    public abstract boolean getOutput(boolean[] inputs);

    public int getNumOfInputs() {
        return numOfInputs;
    }

    public int getNumOfOutputs() {
        return numOfOutputs;
    }
}
