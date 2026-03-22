package com.niraj.railway.controller;


import com.niraj.railway.entity.Booking;
import com.niraj.railway.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingservice;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking){
        return bookingservice.addBooking(booking);
    }
    @GetMapping
    public List<Booking> getAllBooking(){
        return  bookingservice.getAllBooking();
    }
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable("id") Long id){
        return bookingservice.getBookingById(id);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable("id") Long id, @RequestBody Booking booking){

        return bookingservice.updateBooking(id, booking);
    }

    @PutMapping("/{id}/cancel")
    public Booking cancelBooking(@PathVariable("id") Long id) {
        return bookingservice.cancelBooking(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable("id") Long id){
        bookingservice.deleteBooking(id);
    }
}
