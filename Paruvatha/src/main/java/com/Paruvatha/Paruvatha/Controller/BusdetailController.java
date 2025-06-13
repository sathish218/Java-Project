package com.Paruvatha.Paruvatha.Controller;

import com.Paruvatha.Paruvatha.Model.Busdetails;
import com.Paruvatha.Paruvatha.Model.BusSeat;
import com.Paruvatha.Paruvatha.Service.BusdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Paruvatha.Paruvatha.Repository.BusSeatRepository;
import com.Paruvatha.Paruvatha.Repository.BusdetailsRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/buses")
public class BusdetailController {

    @Autowired
    private BusdetailsService busService;

    // Add a bus
    @PostMapping
    public Busdetails addBus(@RequestBody Busdetails bus) {

        return busService.addBus(bus);
    }

    // Get all buses
    @GetMapping
    public List<Busdetails> getAllBuses() {

        return busService.getAllBuses();
    }

    // Get bus by ID
    @GetMapping("/{id}")
    public Busdetails getBusById(@PathVariable Long id) {

        return busService.getBusById(id);
    }

    // Delete bus by ID
    @DeleteMapping("/{id}")
    public String deleteBus(@PathVariable Long id) {
        busService.deleteBus(id);
        return "Bus deleted successfully!";
    }

    // Search for available buses
    @GetMapping("/search")
    public List<Busdetails> getAvailableBuses(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date) {
        return busService.getAvailableBuses(from, to, LocalDate.parse(date));
    }
    @Autowired
    private BusSeatRepository busSeatRepository;

    @Autowired
    private BusdetailsRepository busdetailsRepository;

    //  Get all booked seat numbers for a bus
    @GetMapping("/bookedSeats")
    public List<String> getBookedSeats(@RequestParam Long busId) {
        Busdetails bus = busdetailsRepository.findById(busId)
                .orElseThrow(() -> new RuntimeException("Bus not found"));
        List<BusSeat> bookedSeats = busSeatRepository.findByBusdetailsAndIsBookedTrue(bus);
        return bookedSeats.stream()
                .map(BusSeat::getSeatNumber)
                .collect(Collectors.toList());
    }


}
