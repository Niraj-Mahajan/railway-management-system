package com.niraj.railway.service;

import com.niraj.railway.entity.Passenger;
import com.niraj.railway.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).orElseThrow(()-> new RuntimeException("Passenger not found"));
    }

    public Passenger updatePassenger(Long id, Passenger passenger) {

        Passenger existing = getPassengerById(id);

        existing.setName(passenger.getName());
        existing.setEmail(passenger.getEmail());
        existing.setPhone(passenger.getPhone());
        return  passengerRepository.save(existing);
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
