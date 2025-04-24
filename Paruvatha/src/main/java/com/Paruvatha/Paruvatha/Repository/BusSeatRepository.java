package com.Paruvatha.Paruvatha.Repository;

import com.Paruvatha.Paruvatha.Model.BusSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusSeatRepository extends JpaRepository<BusSeat, Long> {

    // Find all seats by busId and availability status
    List<BusSeat> findByBusIdAndAvailable(String busId, boolean available);

    // Find all seats for a specific bus
    List<BusSeat> findByBusId(String busId);

    // Find seat by busId and seatNumber (useful for seat selection and updates)
    BusSeat findByBusIdAndSeatNumber(String busId, String seatNumber);

    // ✅ Find multiple seats by busId and a list of seat numbers
    List<BusSeat> findByBusIdAndSeatNumberIn(String busId, List<String> seatNumbers);

    // Find all available seats for a bus
    List<BusSeat> findByAvailableTrue();

    // Find all unavailable seats for a bus
    List<BusSeat> findByAvailableFalse();

    // Find seats by busId and seat type (e.g., Seater, Sleeper)
    List<BusSeat> findByBusIdAndSeatType(String busId, String seatType);
}
