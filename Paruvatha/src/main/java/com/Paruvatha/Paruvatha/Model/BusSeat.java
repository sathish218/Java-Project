package com.Paruvatha.Paruvatha.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "bus_seat")
public class BusSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    private Busdetails busdetails;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(name = "is_booked", nullable = false)
    private boolean isBooked = false;


    @Column(name = "available", nullable = false)
    private boolean available = true;

    public BusSeat() {}

    public BusSeat(Busdetails busdetails, String seatNumber) {
        this.busdetails = busdetails;
        this.seatNumber = seatNumber;
        this.isBooked = false; // Default for booked
        this.available = true; // Default for available
    }

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Busdetails getBusdetails() { return busdetails; }

    public void setBusdetails(Busdetails busdetails) { this.busdetails = busdetails; }

    public String getSeatNumber() { return seatNumber; }

    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public boolean isBooked() { return isBooked; }

    public void setBooked(boolean booked) { isBooked = booked; }

    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) { this.available = available; }
}
