package logic;

import java.io.Serializable;

/**
 *
 * @author PIX
 */
public class Movie implements Serializable {
    private int id;
    private String movieName;
    private String movieDescription;

    public Movie(String movieName, String movieDescription) {
        this.movieName = movieName;
        this.movieDescription = movieDescription;
    }

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
