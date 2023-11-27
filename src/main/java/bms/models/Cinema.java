package bms.models;

import bms.enums.CinemaStatus;

import java.util.ArrayList;
import java.util.List;

public class Cinema {

    public String name;
    public CinemaStatus status;
    public List<Show> shows;
    public List<CinemaSeat> cinemaSeats;

    public Cinema(String name, CinemaStatus status){
        this.name = name;
        this.status = status;
        this.shows = new ArrayList<>();
        this.cinemaSeats = new ArrayList<>();
    }

    public void addSeat(CinemaSeat cinemaSeat){
        this.cinemaSeats.add(cinemaSeat);
    }

    public void addShow(Show show){
        this.shows.add(show);
    }
}




