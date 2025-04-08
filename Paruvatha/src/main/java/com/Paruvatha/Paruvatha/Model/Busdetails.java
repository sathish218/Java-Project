package com.Paruvatha.Paruvatha.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

@Entity
@Table(name = "buses")
public class Busdetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String busName;
    private String fromPlace;
    private String toPlace;
    private String boardingPlace;
    private String arrivalPlace;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private String busType;
    private String seatCount;
    private Double seaterFare;
    private Double sleeperFare;

    @ElementCollection
    @CollectionTable(name = "bus_amenities", joinColumns = @JoinColumn(name = "bus_id"))
    @MapKeyColumn(name = "amenity_name")
    @Column(name = "available")
    private Map<String, Boolean> amenities;

    public Busdetails() {

    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBusName() { return busName; }
    public void setBusName(String busName) { this.busName = busName; }

    public String getFromPlace() { return fromPlace; }
    public void setFromPlace(String fromPlace) { this.fromPlace = fromPlace; }

    public String getToPlace() { return toPlace; }
    public void setToPlace(String toPlace) { this.toPlace = toPlace; }

    public String getBoardingPlace() { return boardingPlace; }
    public void setBoardingPlace(String boardingPlace) { this.boardingPlace = boardingPlace; }

    public String getArrivalPlace() { return arrivalPlace; }
    public void setArrivalPlace(String arrivalPlace) { this.arrivalPlace = arrivalPlace; }

    public LocalDate getDepartureDate() { return departureDate; }
    public void setDepartureDate(LocalDate departureDate) { this.departureDate = departureDate; }

    public LocalTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalTime departureTime) { this.departureTime = departureTime; }

    public LocalDate getArrivalDate() { return arrivalDate; }
    public void setArrivalDate(LocalDate arrivalDate) { this.arrivalDate = arrivalDate; }

    public LocalTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(LocalTime arrivalTime) { this.arrivalTime = arrivalTime; }

    public String getBusType() { return busType; }
    public void setBusType(String busType) { this.busType = busType; }

    public String getSeatCount() { return seatCount; }
    public void setSeatCount(String seatCount) { this.seatCount = seatCount; }

    public Double getSeaterFare() { return seaterFare; }
    public void setSeaterFare(Double seaterFare) { this.seaterFare = seaterFare; }

    public Double getSleeperFare() { return sleeperFare; }
    public void setSleeperFare(Double sleeperFare) { this.sleeperFare = sleeperFare; }

    public Map<String, Boolean> getAmenities() { return amenities; }
    public void setAmenities(Map<String, Boolean> amenities) { this.amenities = amenities; }
}
