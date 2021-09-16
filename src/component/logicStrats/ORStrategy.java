package component.logicStrats;

import component.LogicStrategy;

public class ORStrategy extends LogicStrategy {

    /**
     * Returns true if any input is true.
     */
    public ORStrategy() {
        super(2, 1);
    }

    @Override
    public boolean getOutput(boolean[] inputs) {
        for (int i = 0; i < inputs.length; i++){
            if (inputs[i])
                return true;
        }
        return false;
    }
}
