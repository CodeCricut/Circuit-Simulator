package component.logicStrats;

import component.LogicStrategy;

public class EQUIVALENCEStrategy extends LogicStrategy {

    /**
     * Returns true if the first two inputs are equal, which should be the only inputs.
     */
    public EQUIVALENCEStrategy() {
        super(2, 1);
    }

    @Override
    public boolean getOutput(boolean[] inputs) {
        return (inputs[0] == inputs[1]);
    }
}
