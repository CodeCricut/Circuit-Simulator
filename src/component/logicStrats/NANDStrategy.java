package component.logicStrats;

import component.LogicStrategy;

public class NANDStrategy extends LogicStrategy {

    /**
     * Returns true if there is at least one false input.
     */
    public NANDStrategy() {
        super(2, 1);
    }

    @Override
    public boolean getOutput(boolean[] inputs) {
        for (int i = 0; i < inputs.length; i++){
            if (!inputs[i])
                return true;
        }
        return false;
    }
}
