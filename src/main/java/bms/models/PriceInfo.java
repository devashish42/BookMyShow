package bms.models;

import bms.enums.SeatEnums;

import java.math.BigDecimal;

public class PriceInfo {
    public SeatEnums.SeatType type;
    public BigDecimal price;

    public PriceInfo(SeatEnums.SeatType type, BigDecimal price) {
        this.type = type;
        this.price = price;
    }
}
