package bms.service;

import bms.dao.Database;
import bms.models.Cinema;
import bms.models.City;
import bms.models.Movie;
import bms.models.Show;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendationService {
    private final Database db = Database.init();

    public List<Movie> fetchMoviesInCity(City city){
        List<Cinema> cinemas = city.cinemas;
        return cinemas.stream().flatMap(c -> c.shows.stream().map(show -> show.movie).distinct()).toList();
    }

    public Map<Cinema, List<Show>> fetchShowsForMovie(Movie movie, City city){
        List<Cinema> cinemas = city.cinemas;
        Map<Cinema, List<Show>> response = new HashMap<>();
        cinemas.forEach(cinema -> {
            List<Show> shows = cinema.shows.stream().filter(show -> show.movie == movie).toList();
            response.put(cinema, shows);
        });
        return response;
    }

}
