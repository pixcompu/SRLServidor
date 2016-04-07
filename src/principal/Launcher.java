package principal;

import remote.MessageServer;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import remote.IRemoteMovie;
import remote.IRemoteMovieObject;

/**
 * Created by Andre on 16/03/2016.
 */
public class Launcher {

    private static final int SERVER_MESSAGE_PORT = 1099;
    private static final int SERVER_RMI_PORT = 1098;
    private static final String SERVER_RMI_PROPERTY = "java.rmi.server.hostname";
    private static final String SERVER_RMI_IP_ADDRESS = "127.0.0.1";
    private static final String SERVER_RMI_SERVICE_NAME = "Movie";

    public static void main(String[] args) throws SQLException {
        setUpServer();
    }

    private static void startMessageServer() throws IOException {
        MessageServer server = MessageServer.getInstance();
        if ( !server.isRunning() ) {
            server.start(SERVER_MESSAGE_PORT);
        }
        Thread thread = new Thread(server);
        thread.start();
    }

    private static void startRMIServer() throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(SERVER_RMI_PORT);
        IRemoteMovie movieManager = new IRemoteMovieObject();
        System.setProperty(SERVER_RMI_PROPERTY, SERVER_RMI_IP_ADDRESS);
        registry.rebind(SERVER_RMI_SERVICE_NAME, movieManager);
    }

    private static void setUpServer() {
        
        try {
            
            startRMIServer();
            startMessageServer();
            System.out.println("Server is ready!");
            
        } catch (RemoteException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
