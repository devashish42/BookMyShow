package bms.dao;

import bms.models.*;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public List<City> cities = new ArrayList<>();
    public List<Cinema> cinemas = new ArrayList<>();
    public List<User> users = new ArrayList<>();
    public List<CinemaSeat> cinemaSeats = new ArrayList<>();
    public List<Movie> movies = new ArrayList<>();
    public List<Show> shows = new ArrayList<>();
    public List<Booking> booking = new ArrayList<>();
    public List<Transaction> transactions = new ArrayList<>();

    public List<City> getAllCities() {
        return cities;
    }

    private static Database obj;
    private static Boolean isCreated = false;

    private Database() {
        isCreated = true;
    }

    synchronized public static Database init() {
        if (isCreated)
            return obj;

        obj = new Database();
        isCreated = true;
        return obj;
    }
}

