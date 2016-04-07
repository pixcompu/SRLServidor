package data.DAOs;

import logic.Movie;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Andre on 16/03/2016.
 */
public class MovieDAO extends AbstractDAO<Movie> {
    @Override
    public void add(Movie movie) throws SQLException {
        saveEntity(movie);
    }

    @Override
    public void delete(Movie movie) {
        deleteEntity(movie);
    }

    @Override
    public void update(Movie movie) {
        updateEntity(movie);
    }

    @Override
    public Movie get(int objectId) {
        return null;
    }

    @Override
    public ArrayList<Movie> getList() {
        return null;
    }
}
