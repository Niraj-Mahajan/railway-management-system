package com.niraj.railway.service;

import com.niraj.railway.dto.TrainResponseDTO;
import com.niraj.railway.entity.Train;
import com.niraj.railway.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    // Convert Train to DTO
    private TrainResponseDTO convertToDTO(Train train) {
        return new TrainResponseDTO(
                train.getTrainId(),
                train.getTrainName(),
                train.getTrainNumber(),
                train.getTotalSeats(),
                train.getStatus()
        );
    }

    public TrainResponseDTO addTrain(Train train) {
        Train saved = trainRepository.save(train);
        return convertToDTO(saved);
    }
    public List<TrainResponseDTO> getAllTrains() {
        return trainRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public TrainResponseDTO getTrainById(Long id) {
        Train train = trainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Train not found"));
        return convertToDTO(train);
    }


    public TrainResponseDTO updateTrain(Long id, Train train) {
        Train existing = trainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Train not found"));
        existing.setTrainName(train.getTrainName());
        existing.setTrainNumber(train.getTrainNumber());
        existing.setTotalSeats(train.getTotalSeats());
        existing.setStatus(train.getStatus());
        return convertToDTO(trainRepository.save(existing));
    }


    public void deleteTrainById(Long id)
    {
        trainRepository.deleteById(id);
    }
}
