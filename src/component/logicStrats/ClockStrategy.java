package component.logicStrats;

import component.LogicStrategy;

public class ClockStrategy extends LogicStrategy {

    /**
     * The clock strategy is not used to get the output of a clock component. Instead, the getOutput method is
     * overridden in the ClockComponent class, which uses local variables to get the output.
     */
    public ClockStrategy() {
        super(0, 1);
    }

    @Override
    public boolean getOutput(boolean[] inputs) {
        return false;
    }
}
