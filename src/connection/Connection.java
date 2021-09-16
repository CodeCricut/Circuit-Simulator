package connection;

public class Connection {

    ConnectionUI connectionUI;
    ConnectionLogic connectionLogic;

    public Connection(ConnectionUI connectionUI, ConnectionLogic connectionLogic){
        this.connectionUI = connectionUI;
        this.connectionLogic = connectionLogic;
    }

    public ConnectionUI getConnectionUI() {
        return connectionUI;
    }

    public ConnectionLogic getConnectionLogic() {
        return connectionLogic;
    }
}
