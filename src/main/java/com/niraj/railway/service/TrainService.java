package com.niraj.railway.service;

import com.niraj.railway.entity.Train;
import com.niraj.railway.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public Train addTrain(Train train)
    {
        return trainRepository.save(train);
    }
    public List<Train> getAllTrains(){
        return trainRepository.findAll();
    }
    public Train  getTrainById(Long id)
    {
        return trainRepository.findById(id).orElseThrow(()-> new RuntimeException("Train not found"));
    }
    public Train updateTrain(Long id, Train train){
        Train existing = getTrainById(id);
        existing.setTrainName(train.getTrainName());
        existing.setTrainNumber(train.getTrainNumber());
        existing.setTotalSeats(train.getTotalSeats());
        existing.setStatus(train.getStatus());
        return trainRepository.save(existing);

    }
    public void deleteTrainById(Long id)
    {
        trainRepository.deleteById(id);
    }
}
