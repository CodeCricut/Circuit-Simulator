package component.logicStrats;

import component.LogicStrategy;

public class VARIABLEStrategy extends LogicStrategy {

    /**
     * Returns true at all times.
     */
    public VARIABLEStrategy() {
        super(0, 1);
    }

    @Override
    public boolean getOutput(boolean[] inputs) {
        return true;
    }
}
