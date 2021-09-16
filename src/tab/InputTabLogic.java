package tab;

public class InputTabLogic extends TabLogic {

    private OutputTabLogic connectedOutput;

    public InputTabLogic(){}

    private boolean isAvailable = true;

    @Override
    public void update() {
        if (connectedOutput != null) {
            value = connectedOutput.getValue();
        }
    }

    public void setConnectedOutput(OutputTabLogic o){
        connectedOutput = o;
        isAvailable = false;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
