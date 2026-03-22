package com.niraj.railway.controller;

import com.niraj.railway.dto.PassengerResponseDTO;
import com.niraj.railway.entity.Passenger;
import com.niraj.railway.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping
    public ResponseEntity<PassengerResponseDTO> addPassenger(@RequestBody Passenger passenger) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(passengerService.addPassenger(passenger));

    }
    @GetMapping
    public ResponseEntity<List<PassengerResponseDTO>> getPassenger() {
        return ResponseEntity.ok(passengerService.getAllPassengers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerResponseDTO> getPassenger(@PathVariable("id") Long id) {
        return ResponseEntity.ok(passengerService.getPassengerById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PassengerResponseDTO> updatePassenger(@PathVariable("id") Long id, @RequestBody Passenger passenger) {
        return  ResponseEntity.ok(passengerService.updatePassenger(id, passenger));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable("id") Long id){
        passengerService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }
}
