package com.niraj.railway.controller;

import com.niraj.railway.entity.Passenger;
import com.niraj.railway.repository.RouteRepository;
import com.niraj.railway.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping
    public Passenger addPassenger(@RequestBody Passenger passenger) {
        return  passengerService.addPassenger(passenger);

    }
    @GetMapping
    public List<Passenger> getPassenger() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/{id}")
    public Passenger getPassenger(@PathVariable("id") Long id) {
        return passengerService.getPassengerById(id);
    }
    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable("id") Long id, @RequestBody Passenger passenger) {
        return  passengerService.updatePassenger(id, passenger);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable("id") Long id){
        passengerService.deletePassenger(id);
    }
}
