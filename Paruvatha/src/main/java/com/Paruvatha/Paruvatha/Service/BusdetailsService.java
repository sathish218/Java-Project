package com.Paruvatha.Paruvatha.Service;

import com.Paruvatha.Paruvatha.Model.Busdetails;
import com.Paruvatha.Paruvatha.Repository.BusdetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BusdetailsService {

    @Autowired
    private BusdetailsRepository busRepository;


    public Busdetails addBus(Busdetails bus) {
        return busRepository.save(bus);
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
