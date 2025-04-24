package com.Paruvatha.Paruvatha.Model;

import jakarta.persistence.*;

@Entity
public class BusSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    private Busdetails busdetails;

    private String seatNumber;

    // Default to true (available), set to false (unavailable) after payment
    private boolean isBooked = false;

    // Constructor
    public BusSeat() {}

    public BusSeat(Busdetails busdetails, String seatNumber) {
        this.busdetails = busdetails;
        this.seatNumber = seatNumber;
    }

    // Getter and Setter methods
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Busdetails getBusdetails() { return busdetails; }
    public void setBusdetails(Busdetails busdetails) { this.busdetails = busdetails; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public boolean isBooked() { return isBooked; }
    public void setBooked(boolean booked) { this.isBooked = booked; }

}
