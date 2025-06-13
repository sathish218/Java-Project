package com.Paruvatha.Paruvatha.Service;

import com.Paruvatha.Paruvatha.Model.Busdetails;
import com.Paruvatha.Paruvatha.Model.BusSeat;
import com.Paruvatha.Paruvatha.Repository.BusSeatRepository;
import com.Paruvatha.Paruvatha.Repository.BusdetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BusdetailsService {

    @Autowired
    private BusdetailsRepository busRepository;

    @Autowired
    private BusSeatRepository seatRepository;

    public Busdetails addBus(Busdetails bus) {
        Busdetails savedBus = busRepository.save(bus);
        int seatCount = bus.getSeatCount(); // Now it's an integer

        List<BusSeat> seats = new ArrayList<>();
        for (int i = 1; i <= seatCount; i++) {
            seats.add(new BusSeat(savedBus, "S" + i)); // Assign seat numbers as S1, S2, ...
        }

        seatRepository.saveAll(seats);
        return savedBus;
    }

    public List<Busdetails> getAllBuses() {
        return busRepository.findAll();
    }

    public Busdetails getBusById(Long id) {
        return busRepository.findById(id).orElse(null);
    }

    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }

    public List<Busdetails> getAvailableBuses(String from, String to, LocalDate date) {
        return busRepository.findByFromPlaceAndToPlaceAndDepartureDate(from, to, date);
    }



}
