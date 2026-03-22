package com.niraj.railway.service;

import com.niraj.railway.dto.PassengerResponseDTO;
import com.niraj.railway.entity.Passenger;
import com.niraj.railway.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    //convert Passenger to DTO
    private PassengerResponseDTO  convertToDTO(Passenger passenger){
        return new  PassengerResponseDTO(
                passenger.getPassengerId(),
                passenger.getName(),
                passenger.getEmail(),
                passenger.getPhone()
        );

    }



    public PassengerResponseDTO addPassenger(Passenger passenger) {
       Passenger saved =   passengerRepository.save(passenger);
       return  convertToDTO(saved);
    }

    public List<PassengerResponseDTO> getAllPassengers() {
        return passengerRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PassengerResponseDTO getPassengerById(Long id) {
        Passenger passenger =  passengerRepository.findById(id).orElseThrow(()-> new RuntimeException("Passenger not found"));
        return  convertToDTO(passenger);
    }

    public PassengerResponseDTO updatePassenger(Long id, Passenger passenger) {

        Passenger existing = passengerRepository.findById(id).orElseThrow(()-> new RuntimeException("Passenger not found"));

        existing.setName(passenger.getName());
        existing.setEmail(passenger.getEmail());
        existing.setPhone(passenger.getPhone());
        return  convertToDTO(passengerRepository.save(existing));
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
