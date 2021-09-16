package component.logicStrats;

import component.LogicStrategy;

public class NORStrategy extends LogicStrategy {
    /**
     * Returns true if all inputs are false.
     */
    public NORStrategy() {
        super(2, 1);
    }

    @Override
    public boolean getOutput(boolean[] inputs) {
        for (int i = 0; i < inputs.length; i++){
            if (inputs[i])
                return false;
        }
        return true;
    }
}
