package com.Paruvatha.Paruvatha.Repository;

import com.Paruvatha.Paruvatha.Model.BusSeat;
import com.Paruvatha.Paruvatha.Model.Busdetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusSeatRepository extends JpaRepository<BusSeat, Long> {

    // Find all booked seats for a specific bus (where isBooked = true)
    List<BusSeat> findByBusdetailsAndIsBookedTrue(Busdetails busdetails);

    // Find seats by bus details and a list of seat numbers
    List<BusSeat> findByBusdetailsAndSeatNumberIn(Busdetails busdetails, List<String> seatNumbers);

    // Find seats by bus details ID and booking status (isBooked)
    List<BusSeat> findByBusdetailsIdAndIsBooked(Long busdetailsId, boolean isBooked);
}
