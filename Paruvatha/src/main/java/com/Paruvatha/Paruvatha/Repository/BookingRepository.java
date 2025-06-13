package com.Paruvatha.Paruvatha.Repository;

import com.Paruvatha.Paruvatha.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByBusIdAndDate(String busId, String date);

//    List<Booking> findByUserEmail(String email);


//    @Query("SELECT b FROM Booking b WHERE b.busId = :busId AND b.date = :date")
//    List<Booking> findBookingsByBusIdAndDate(@Param("busId") String busId, @Param("date") String date);





}
