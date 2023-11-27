package bms.models;

import java.time.Duration;
import java.time.LocalDateTime;

public class Timings {
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public LocalDateTime breakStartTime;
    static Duration breakDuration = Duration.ofMinutes(15);

    public Timings(LocalDateTime startTime, LocalDateTime endTIme, LocalDateTime breakStartTime){
        this.startTime = startTime;
        this.endTime = endTIme;
        this.breakStartTime = breakStartTime;
    }
}
