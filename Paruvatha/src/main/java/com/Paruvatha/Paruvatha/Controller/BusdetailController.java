package com.Paruvatha.Paruvatha.Controller;

import com.Paruvatha.Paruvatha.Model.Busdetails;
import com.Paruvatha.Paruvatha.Service.BusdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/buses")
public class BusdetailController {

    @Autowired
    private BusdetailsService busService;

    @PostMapping
    public Busdetails addBus(@RequestBody Busdetails bus) {
        return busService.addBus(bus);
    }


    @GetMapping
    public List<Busdetails> getAllBuses() {
        return busService.getAllBuses();
    }


    @GetMapping("/{id}")
    public Busdetails getBusById(@PathVariable Long id) {
        return busService.getBusById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteBus(@PathVariable Long id) {
        busService.deleteBus(id);
        return "Bus deleted successfully!";
    }


    @GetMapping("/search")
    public List<Busdetails> getAvailableBuses(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date) {
        return busService.getAvailableBuses(from, to, LocalDate.parse(date));
    }
}
