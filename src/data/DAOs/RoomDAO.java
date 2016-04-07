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
        SQLQuery q = session.createSQLQuery("SELECT * from room WHERE id_room = " + objectId);
        List<Object[]> entities = q.list();
        Room room = new Room();
        room.setId(objectId);
        room.setRows(5);
        room.setColumns(10);
        int[][] seats = new int[5][10];
        for (Object[] entity : entities) {
            seats[Integer.parseInt(entity[1].toString())][Integer.parseInt(entity[2].toString())] = Integer.parseInt(entity[3].toString());
        }
        room.setSeats(seats);
        session.close();
        return room;
    }

    @Override
    public ArrayList<Room> getList() {
        return null;
    }
    
    public void changeSeatState(int roomID, int row, int column, int newSeatState){
        openSession();
        String query = "UPDATE room SET value = " + newSeatState  + " WHERE id_room = " + roomID + " AND mat_row = " + column + " AND mat_column = " + row;
        SQLQuery q = session.createSQLQuery(query);
        int updateState = q.executeUpdate();
        session.close();
    }
}
