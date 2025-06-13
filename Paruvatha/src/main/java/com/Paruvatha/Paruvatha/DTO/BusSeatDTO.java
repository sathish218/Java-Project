package com.Paruvatha.Paruvatha.DTO;

import java.time.LocalDate;

public class BusSeatDTO {
    private Long seatId;
    private String seatNumber;
    private boolean isBooked;
    private String busName;
    private LocalDate departureDate;

    public BusSeatDTO(Long seatId, String seatNumber, boolean isBooked, String busName, LocalDate departureDate) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.isBooked = isBooked;
        this.busName = busName;
        this.departureDate = departureDate;
    }

    // Getters and setters
    public Long getSeatId() { return seatId; }
    public String getSeatNumber() { return seatNumber; }
    public boolean isBooked() { return isBooked; }
    public String getBusName() { return busName; }
    public LocalDate getDepartureDate() { return departureDate; }
}
