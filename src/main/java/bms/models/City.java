package bms.models;

import java.util.ArrayList;
import java.util.List;

public class City {

    public String name;
    public String country;
    public List<Cinema> cinemas;

    public City(String name, String country){
        this.name = name;
        this.country = country;
        this.cinemas = new ArrayList<>();
    }

    public City(String name, String country, List<Cinema> cinemas){
        this.name = name;
        this.country = country;
        this.cinemas = cinemas;
    }

    public Cinema add(Cinema cinema) {
        this.cinemas.add(cinema);
        return cinema;
    }

    public Cinema addAll(List<Cinema> cinemas) {
        this.cinemas.addAll(cinemas);
        return (Cinema) cinemas;
    }
}
