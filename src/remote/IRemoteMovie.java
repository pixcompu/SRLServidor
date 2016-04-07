package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import logic.CinemaFunction;
import logic.Movie;

/**
 *
 * @author PIX
 */
public interface IRemoteMovie extends Remote{
    public int save(Movie movie) throws RemoteException;
    public int update(Movie movie) throws RemoteException;
    public int delete(Movie movie) throws RemoteException;
    public void deleteAll() throws RemoteException;
    public ArrayList<CinemaFunction> findAll() throws RemoteException;
    public ArrayList<CinemaFunction> findByName(String criteria) throws RemoteException;
    public void changeSeatState(int roomID, int row, int column, int newSeatState) throws RemoteException;
}
