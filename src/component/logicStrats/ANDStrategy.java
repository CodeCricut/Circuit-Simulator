package component.logicStrats;

import component.LogicStrategy;

public class ANDStrategy extends LogicStrategy {

    /**
     * Returns true if all of the inputs are true. In other words, returns false if any of the inputs are false.
     */
    public ANDStrategy() {
        super(2, 1);
    }

    @Override
    public boolean getOutput(boolean[] inputs) {
        for (boolean input : inputs) {
            if (!input)
                return false;
        }
        return true;
    }
}
