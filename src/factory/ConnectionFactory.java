package factory;

import connection.ConnectionLogic;
import tab.InputTabLogic;
import tab.OutputTabLogic;
import connection.Connection;
import connection.ConnectionUI;
import main.Main;

/*
    Responsibilities:
    * Creates connections
    * Adds the connection to the output tab as an observer
    * Sets the output tab as the input tab's output tab (provides a reference)
 */

public class ConnectionFactory {

    public static Connection createConnection(ConnectionUI connectionUI, ConnectionLogic connectionLogic){
        return new Connection(connectionUI, connectionLogic);
    }

    public static ConnectionLogic createConnectionLogic(InputTabLogic inputTabLogic,
                                                        OutputTabLogic outputTabLogic,
                                                        ConnectionUI connectionUI){
        ConnectionLogic connectionLogic = new ConnectionLogic(outputTabLogic, connectionUI);

        Main.getLogicThread().addUpdatable(connectionLogic);
        inputTabLogic.setConnectedOutput(outputTabLogic);

        return connectionLogic;
    }

    public static ConnectionUI createConnectionUI(int startX, int startY,
                                                   int endX, int endY){
        return new ConnectionUI(startX, startY, endX, endY);
    }
}
