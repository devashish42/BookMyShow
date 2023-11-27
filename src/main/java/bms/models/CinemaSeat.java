package bms.models;

import bms.enums.SeatEnums;

public class CinemaSeat {
    public Integer number;
    public SeatEnums.SeatType type;
    public SeatEnums.SeatStatus status;

    public CinemaSeat(Integer number, SeatEnums.SeatStatus status, SeatEnums.SeatType type) {
        this.number = number;
        this.status = status;
        this.type = type;
    }
}
