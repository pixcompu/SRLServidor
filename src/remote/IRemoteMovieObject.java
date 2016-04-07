package remote;

import data.DAOs.CinemaFunctionDAO;
import data.DAOs.RoomDAO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import logic.CinemaFunction;
import logic.Room;

/**
 *
 * @author PIX
 */
public class IRemoteMovieObject extends UnicastRemoteObject implements IRemoteMovie {

    private static final long serialVersionUID = 11L;

    public IRemoteMovieObject() throws RemoteException {
        super();
    }

    @Override
    public ArrayList findAll() throws RemoteException {
        
        CinemaFunctionDAO cinemaDAO = new CinemaFunctionDAO();
        RoomDAO room = new RoomDAO();
        ArrayList<CinemaFunction> list = cinemaDAO.getList();
        for(CinemaFunction current : list){
            current.setRoom(room.get(1));
        }
        return list;
    }

    @Override
    public void changeSeatState(int roomID, int row, int column, int newSeatState) throws RemoteException{
        
        RoomDAO roomDAO = new RoomDAO();
        roomDAO.changeSeatState(roomID, row, column, newSeatState);
        String template = "%d:%d:%d:%d";
        
        MessageServer messageServer = MessageServer.getInstance();
        
        if( messageServer.isRunning()){
            
            messageServer.broadcast(String.format(template,
                roomID,
                row,
                column,
                newSeatState
                ));
        }
    }

    @Override
    public Room getRoom(int roomID) throws RemoteException {
        RoomDAO room = new RoomDAO();
        return room.get(roomID);
    }

}
