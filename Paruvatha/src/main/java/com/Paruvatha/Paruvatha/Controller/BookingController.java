package com.Paruvatha.Paruvatha.Controller;

import com.Paruvatha.Paruvatha.Model.Booking;
import com.Paruvatha.Paruvatha.Service.BookingService;
import com.Paruvatha.Paruvatha.Util.AuthUtil;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/seats")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService){

        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public Booking bookSeats(@RequestBody Booking booking){

        return bookingService.saveBooking(booking);
    }

    @GetMapping("/booked")
    public List<String> getBookedSeats(@RequestParam String busId,@RequestParam String date){
       return bookingService.getBookedSeats(busId, date);
    }


}
