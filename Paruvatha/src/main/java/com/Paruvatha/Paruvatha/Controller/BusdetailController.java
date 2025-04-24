package com.Paruvatha.Paruvatha.Controller;

import com.Paruvatha.Paruvatha.Model.BusSeat;
import com.Paruvatha.Paruvatha.Model.Busdetails;
import com.Paruvatha.Paruvatha.Repository.BusdetailsRepository;
import com.Paruvatha.Paruvatha.Service.BusSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@CrossOrigin(origins = "*") // Allow frontend to connect
public class BusSeatController {

    @Autowired
    private BusSeatService busSeatService;

    @Autowired
    private BusdetailsRepository busdetailsRepository;

    // Get booked seats for a bus
    @GetMapping("/booked/{busId}")
    public List<BusSeat> getBookedSeats(@PathVariable Long busId) {
        Busdetails bus = busdetailsRepository.findById(busId).orElseThrow();
        return busSeatService.getBookedSeatsByBus(bus);
    }

    // Book seats (after payment)
    @PostMapping("/book")
    public String bookSeats(@RequestParam Long busId, @RequestBody List<String> seatNumbers) {
        Busdetails bus = busdetailsRepository.findById(busId).orElseThrow();
        busSeatService.markSeatsAsBooked(bus, seatNumbers);
        return "Seats successfully booked!";
    }

    // Get available seats
    @GetMapping("/available/{busId}")
    public List<BusSeat> getAvailableSeats(@PathVariable Long busId) {
        return busSeatService.getAvailableSeats(busId);
    }
}
