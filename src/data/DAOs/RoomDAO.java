package data.DAOs;

import logic.Room;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;

/**
 * Created by Andre on 16/03/2016.
 */
public class RoomDAO extends AbstractDAO<Room> {

    private final int ROOM_ROWS = 5;
    private final int ROOM_COLUMNS = 10;
    
    @Override
    public void add(Room room) throws SQLException {
        saveEntity(room);
    }

    @Override
    public void delete(Room room) {
        deleteEntity(room);
    }

    @Override
    public void update(Room room) {
        updateEntity(room);
    }

    @Override
    public Room get(int objectId) {
        openSession();
        Room room = getRoom(objectId);
        int[][] seats = getSeats(objectId);
        room.setSeats(seats);
        session.close();
        return room;
    }

    @Override
    public ArrayList<Room> getList() {
        return null;
    }
    
    public void changeSeatState(int roomID, int column, int row, int newSeatState){
        openSession();
        String query = "UPDATE room SET value = " + newSeatState  + " WHERE id_room = " + roomID + " AND mat_row = " + row + " AND mat_column = " + column;
        SQLQuery q = session.createSQLQuery(query);
        int updateState = q.executeUpdate();
        transaction.commit();
        session.close();
    }

    private int[][] getSeats(int objectId) {
        SQLQuery query = session.createSQLQuery("SELECT * from room WHERE id_room = " + objectId);
        List<Object[]> entities = query.list();
        int[][] seats = new int[ROOM_ROWS][ROOM_COLUMNS];
        for (Object[] entity : entities) {
            int row = Integer.parseInt(entity[1].toString());
            int column = Integer.parseInt(entity[2].toString());
            int value = Integer.parseInt(entity[3].toString());
            seats[row][column] = value;
        }
        return seats;
    }

    private Room getRoom(int objectId) {
        Room room = new Room();
        room.setId(objectId);
        room.setRows(ROOM_ROWS);
        room.setColumns(ROOM_COLUMNS);
        return room;
    }
}
