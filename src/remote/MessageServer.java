package remote;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PIX
 */
public class MessageServer implements Runnable {

    private final boolean APLICATION_RUNNING = true;
    private ServerSocket server;
    private static MessageServer instance;
    private final LinkedList<ClientConnection> connections;

    private MessageServer() {
        connections = new LinkedList<>();
    }

    public static MessageServer getInstance() {
        if (instance == null) {
            instance = new MessageServer();
        }
        return instance;
    }

    public void start(int port) throws IOException {
        if (server == null) {
            this.server = new ServerSocket(port);
        }
    }
    
    public boolean isRunning(){
        return server != null;
    }

    public void broadcast(String message) {
        synchronized ( connections ) {
            for (ClientConnection current : connections) {
                sendMessage(current, message);
            }
        }
    }

    @Override
    public void run() {
        while (APLICATION_RUNNING) {
            try {
                Socket client = server.accept();
                System.out.println("New client in : " + client.getInetAddress());
                ClientConnection clientConnection = new ClientConnection(client);
                connections.add(clientConnection);
            } catch (IOException ex) {
                Logger.getLogger(MessageServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void sendMessage(ClientConnection destinatary, String message) {
        try {
            synchronized (destinatary.getOutputStream()) {
                destinatary.getOutputStream().writeUTF(message);
            }
            destinatary.getOutputStream().flush();
        } catch (IOException ex) {
            Logger.getLogger(MessageServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
