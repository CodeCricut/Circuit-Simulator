package component.logicStrats;

import component.LogicStrategy;

public class XORStrategy extends LogicStrategy {

    /**
     * Returns true when one and only one input is true. In other words, returns true if the inputs aren't equal.
     */
    public XORStrategy() {
        super(2, 1);
    }

    @Override
    public boolean getOutput(boolean[] inputs) {
        int numOfTrue = 0;
        for (int i = 0; i < inputs.length; i++){
            if (inputs[i])
                numOfTrue ++;
        }
        return (numOfTrue == 1);
    }
}
