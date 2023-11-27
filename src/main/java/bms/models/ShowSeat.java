package bms.models;

import bms.enums.SeatEnums;

import java.math.BigDecimal;

public class ShowSeat extends CinemaSeat {
    BigDecimal price;

    public ShowSeat(Integer number, SeatEnums.SeatStatus status, SeatEnums.SeatType type, BigDecimal price) {
        super(number, status, type);
        this.price = price;
    }
}
