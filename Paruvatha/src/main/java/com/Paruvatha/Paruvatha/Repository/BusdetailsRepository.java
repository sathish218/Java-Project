package com.Paruvatha.Paruvatha.Repository;

import com.Paruvatha.Paruvatha.Model.Busdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BusdetailsRepository extends JpaRepository<Busdetails, Long> {

    List<Busdetails> findByFromPlaceAndToPlaceAndDepartureDate(String fromPlace, String toPlace, LocalDate departureDate);
}
