package bms;

import bms.dao.Database;
import bms.enums.CinemaStatus;
import bms.enums.SeatEnums;
import bms.enums.ShowEnums;
import bms.models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BmsApplication {
    Database db;

    public void createDummyData() {
        db = Database.init();
        Cinema cinema1 = new Cinema("Pvr", CinemaStatus.OPEN);
        cinema1.addSeat(new CinemaSeat(1, SeatEnums.SeatStatus.AVAILABLE, SeatEnums.SeatType.PLATINUM));
        cinema1.addSeat(new CinemaSeat(2, SeatEnums.SeatStatus.AVAILABLE, SeatEnums.SeatType.PLATINUM));
        cinema1.addSeat(new CinemaSeat(3, SeatEnums.SeatStatus.AVAILABLE, SeatEnums.SeatType.GOLD));
        cinema1.addSeat(new CinemaSeat(4, SeatEnums.SeatStatus.AVAILABLE, SeatEnums.SeatType.SILVER));
        Cinema cinema2 = new Cinema("Pvr", CinemaStatus.OPEN);
        cinema2.addSeat(new CinemaSeat(11, SeatEnums.SeatStatus.AVAILABLE, SeatEnums.SeatType.SILVER));
        cinema2.addSeat(new CinemaSeat(12, SeatEnums.SeatStatus.AVAILABLE, SeatEnums.SeatType.GOLD));
        cinema2.addSeat(new CinemaSeat(13, SeatEnums.SeatStatus.AVAILABLE, SeatEnums.SeatType.PLATINUM));
        cinema2.addSeat(new CinemaSeat(14, SeatEnums.SeatStatus.AVAILABLE, SeatEnums.SeatType.PLATINUM));
        Cinema cinema3 = new Cinema("Pvr", CinemaStatus.OPEN);
        cinema3.addSeat(new CinemaSeat(21, SeatEnums.SeatStatus.AVAILABLE, SeatEnums.SeatType.SILVER));
        cinema3.addSeat(new CinemaSeat(22, SeatEnums.SeatStatus.AVAILABLE, SeatEnums.SeatType.GOLD));
        cinema3.addSeat(new CinemaSeat(23, SeatEnums.SeatStatus.AVAILABLE, SeatEnums.SeatType.PLATINUM));
        cinema3.addSeat(new CinemaSeat(24, SeatEnums.SeatStatus.AVAILABLE, SeatEnums.SeatType.GOLD));
        Cinema cinema4 = new Cinema("Silver city", CinemaStatus.OPEN);
        cinema4.addSeat(new CinemaSeat(21, SeatEnums.SeatStatus.AVAILABLE, SeatEnums.SeatType.SILVER));
        cinema4.addSeat(new CinemaSeat(22, SeatEnums.SeatStatus.AVAILABLE, SeatEnums.SeatType.GOLD));
        cinema4.addSeat(new CinemaSeat(23, SeatEnums.SeatStatus.AVAILABLE, SeatEnums.SeatType.PLATINUM));
        cinema4.addSeat(new CinemaSeat(24, SeatEnums.SeatStatus.AVAILABLE, SeatEnums.SeatType.GOLD));

        City c1 = new City("Delhi", "India");
        c1.addAll(new ArrayList<>(Arrays.asList(cinema1, cinema2)));
        City c2 = new City("Hyderabad", "India");
        c2.add(cinema3);
        City c3 = new City("Pune", "India");
        c3.add(cinema4);
        User u1 = User.createUser("deva", c1, "xyz");


        Movie m1 = new Movie("DevilMayCry");
        Movie m2 = new Movie("Doom");
        Movie m3 = new Movie("XXX");
        Movie m4 = new Movie("Marvel");

        Timings t1 = new Timings(LocalDateTime.MIN, LocalDateTime.MAX, LocalDateTime.MAX.plusHours(1));
        Show s1 = new Show(1, m1, ShowEnums.ShowStatus.AVAILABLE, t1);
        Show s2 = new Show(2, m2, ShowEnums.ShowStatus.AVAILABLE, t1);
        Show s3 = new Show(3, m1, ShowEnums.ShowStatus.OVER, t1);
        Show s4 = new Show(4, m3, ShowEnums.ShowStatus.AVAILABLE, t1);
        Show s5 = new Show(5, m4, ShowEnums.ShowStatus.AVAILABLE, t1);

        cinema1.addShow(s1);
        cinema2.addShow(s2);
        cinema3.addShow(s3);
        cinema4.addShow(s4);
        cinema1.addShow(s5);

        db.cities = List.of(c1, c2, c3);
        db.cinemas = List.of(cinema1, cinema2, cinema3, cinema4);
        db.users = List.of(u1);
        db.movies = List.of(m1, m2);
        db.cinemaSeats = db.cinemas.stream().flatMap(cinema -> cinema.cinemaSeats.stream()).collect(Collectors.toList());
        db.shows = db.cinemas.stream().flatMap(cinema -> cinema.shows.stream()).collect(Collectors.toList());

    }


    public void startApp() {
        createDummyData();
    }

}
