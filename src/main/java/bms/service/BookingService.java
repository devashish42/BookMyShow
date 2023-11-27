package bms.service;

import bms.dao.Database;
import bms.enums.SeatEnums;
import bms.models.*;

import java.util.List;

public class BookingService {
    private final Database db = Database.init();
    private final PaymentService paymentService = PaymentService.create();

    synchronized public Booking bookShow(User user, Cinema cinema, Show show, List<ShowSeat> showSeats) {
        Booking booking = Booking.newBooking(show.id, user, showSeats);

        showSeats.forEach(s -> s.status = SeatEnums.SeatStatus.BOOKED);
        db.booking.add(booking);
        paymentService.makePayment(booking);
        return booking;
    }

    public List<ShowSeat> showSeats(Show show) {
        return show.showSeats;
    }

    public List<ShowSeat> showAvailableSeats(Show show) {
        return show.showSeats.stream().filter(seat -> seat.status == SeatEnums.SeatStatus.AVAILABLE).toList();
    }

    synchronized public void selectSeats(List<ShowSeat> showSeats){
        showSeats.forEach(s -> s.status = SeatEnums.SeatStatus.ON_HOLD);
    }
}
