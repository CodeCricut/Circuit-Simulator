package connection;

import tab.OutputTabLogic;
import observer.Updatable;

public class ConnectionLogic implements Updatable {

    private OutputTabLogic outputTabLogic;
    private ConnectionUI connectionUI;

    public ConnectionLogic(OutputTabLogic outputTabLogic, ConnectionUI connectionUI){
        this.outputTabLogic = outputTabLogic;
        this.connectionUI = connectionUI;
    }

    @Override
    public void update() {
        if (outputTabLogic.getValue())
            connectionUI.turnOn();
        else
            connectionUI.turnOff();
    }
}
