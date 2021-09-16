package component.logicStrats;

import component.LogicStrategy;

public class NOTStrategy extends LogicStrategy {
    /**
     * Returns the opposite of the first input, which should be the only input.
     */
    public NOTStrategy() {
        super(1, 1);
    }

    @Override
    public boolean getOutput(boolean[] inputs) {
        return !inputs[0];
    }
}
