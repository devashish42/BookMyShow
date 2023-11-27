package bms.models;

import java.util.List;

public class Booking {
    Integer showId;
    User user;
    List<ShowSeat> showSeats;

    private Booking(Integer showId, User user, List<ShowSeat> showSeats){
        this.showId = showId;
        this.user = user;
        this.showSeats = showSeats;
    }

    public static Booking newBooking(Integer showId, User user, List<ShowSeat> showSeats){
        return new Booking(showId, user, showSeats);
    }
}
