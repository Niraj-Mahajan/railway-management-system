package com.niraj.railway.controller;


import com.niraj.railway.dto.BookingResponseDTO;
import com.niraj.railway.entity.Booking;
import com.niraj.railway.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingservice;

    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody Booking booking){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingservice.addBooking(booking));
    }
    @GetMapping
    public ResponseEntity<List<BookingResponseDTO>> getAllBooking(){
        return  ResponseEntity.ok(bookingservice.getAllBooking());
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> getBookingById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookingservice.getBookingById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> updateBooking(@PathVariable("id") Long id, @RequestBody Booking booking){

        return ResponseEntity.ok(bookingservice.updateBooking(id, booking));
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<BookingResponseDTO> cancelBooking(@PathVariable("id") Long id) {
        return ResponseEntity.ok(bookingservice.cancelBooking(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable("id") Long id){
        bookingservice.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
