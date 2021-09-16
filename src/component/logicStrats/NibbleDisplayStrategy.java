package component.logicStrats;

import component.LogicStrategy;

public class NibbleDisplayStrategy extends LogicStrategy {
    public NibbleDisplayStrategy() {
        super(4, 1);
    }

    @Override
    public boolean getOutput(boolean[] inputs) {
        return false;
    }
}
