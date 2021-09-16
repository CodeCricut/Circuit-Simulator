package component.logicStrats;

import component.LogicStrategy;

public class ToggleStrategy extends LogicStrategy {

    /**
     * The output of the ToggleComponent is calculated in the ToggleComponent class. This strategy is simply here as a
     * placeholder.
     */
    public ToggleStrategy() {
        super(0, 1);
    }

    @Override
    public boolean getOutput(boolean[] inputs) {
        return false;
    }
}
