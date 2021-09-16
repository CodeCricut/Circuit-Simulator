package component.logicStrats;


import component.LogicStrategy;

public class DEBUGStrategy extends LogicStrategy {

    /**
     * Returns the value of the first input, which should be the only input.
     */
    public DEBUGStrategy() {
        super(1, 0);
    }

    @Override
    public boolean getOutput(boolean[] inputs) {
        return inputs[0];
    }
}
