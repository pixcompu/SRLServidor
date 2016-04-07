package data.DAOs;

import logic.CinemaFunction;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Andre on 15/03/2016.
 */
public class CinemaFunctionDAO extends AbstractDAO<CinemaFunction> {

    @Override
    public void add(CinemaFunction cinemaFunction) throws SQLException {
        saveEntity(cinemaFunction);
    }

    @Override
    public void delete(CinemaFunction cinemaFunction) {
        deleteEntity(cinemaFunction);
}

    @Override
    public void update(CinemaFunction cinemaFunction) {
        updateEntity(cinemaFunction);
    }

    @Override
    public CinemaFunction get(int objectId) {
        CinemaFunction cinemaFunction = null;

        try {
            openSession();

            cinemaFunction = (CinemaFunction) session.get(CinemaFunction.class, objectId);
        } finally {
            session.close();
        }
        return cinemaFunction;
    }

    @Override
    public ArrayList<CinemaFunction> getList() {
        ArrayList cinemaFunctionList = null;

        try {
            openSession();
            cinemaFunctionList = (ArrayList) session.createQuery("from CinemaFunction").list();
        } finally {
            session.close();
        }

        return cinemaFunctionList;
    }
}
