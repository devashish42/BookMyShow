package bms.models;

import bms.enums.ShowEnums.*;

import java.util.ArrayList;
import java.util.List;


public class Show {
    public Integer id;
    public Movie movie;
    public ShowStatus status;
    public Timings timings;
    public List<ShowSeat> showSeats;

    public Show(Integer id, Movie movie, ShowStatus status, Timings timings) {
        this.id = id;
        this.movie = movie;
        this.status = status;
        this.timings = timings;
        this.showSeats = new ArrayList<>();
    }

    public Show(Integer id, Movie movie, ShowStatus status, Timings timings, List<ShowSeat> seats) {
        this.id = id;
        this.movie = movie;
        this.status = status;
        this.timings = timings;
        this.showSeats = seats;
    }

    public void addSeat(ShowSeat seat) {
        this.showSeats.add(seat);
    }
}




