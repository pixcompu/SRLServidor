package logic;

import java.io.Serializable;

/**
 *
 * @author PIX
 */
public class CinemaFunction implements Serializable{
    private int id;
    private  Room room;
    private  Movie movie;
    private  String schedule;

    public CinemaFunction(Room room, Movie movie, String schedule) {
        this.room = room;
        this.movie = movie;
        this.schedule = schedule;
    }

    public CinemaFunction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void printFunctionInformation(){
        System.out.println("Movie ID : " + movie.getId());
        System.out.println("Movie Name : " + movie.getMovieName());
        System.out.println("Movie Description : " + movie.getMovieDescription());
        System.out.println("Function Schedule : " + schedule);
        System.out.println("Seats : ");
        System.out.println("Rows  : " + room.getRows() + " Columns :" +room.getColumns() );
        room.setUpSeats();
        for(int[] seatRow : room.getSeats()){
            for(int i = 0; i < seatRow.length; i++){
                System.out.print("[" + seatRow[i] + "] ");
            }
            System.out.println("");
        }
    }
}
