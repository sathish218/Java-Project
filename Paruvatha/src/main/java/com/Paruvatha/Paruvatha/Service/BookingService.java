package com.Paruvatha.Paruvatha.Service;

import org.springframework.stereotype.Service;
import com.Paruvatha.Paruvatha.Model.Booking;
import com.Paruvatha.Paruvatha.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    public Booking saveBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    public List<String> getBookedSeats(String busId, String date){
        List<Booking> bookings = bookingRepository.findByBusIdAndDate(busId, date);
        return bookings.stream()
                .flatMap(b -> b.getSeatNumbers().stream())
                .collect(Collectors.toList());
    }

//    public List<Map<String, String>> getBookingsForUser(String userEmail) {
//        // Retrieve all bookings for the provided user ema    il from the database
//        return bookingRepository.findBookingsByUserEmail(userEmail);
//    }
}
