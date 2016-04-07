package remote;

import data.DAOs.CinemaFunctionDAO;
import data.DAOs.RoomDAO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import logic.CinemaFunction;
import logic.Movie;

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
    public int save(Movie movie) throws RemoteException {
        System.out.println("SAVE");
        return 69;
    }

    @Override
    public int update(Movie movie) throws RemoteException {
        System.out.println("UPDATE");
        return 69;
    }

    @Override
    public int delete(Movie movie) throws RemoteException {
        System.out.println("DELETE");
        return 69;
    }

    @Override
    public void deleteAll() throws RemoteException {
        System.out.println("DELETE ALL");
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
    public ArrayList findByName(String criteria) throws RemoteException {
        ArrayList list = new ArrayList();
        list.add("Find By Name");
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

}
