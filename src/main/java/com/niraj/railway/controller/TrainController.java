package com.niraj.railway.controller;


import com.niraj.railway.entity.Train;
import com.niraj.railway.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping
    public Train addTrain(@RequestBody Train train){
        return trainService.addTrain(train);
    }
    @GetMapping
    public List<Train> getAllTrains(){
        return trainService.getAllTrains();
    }
    @GetMapping("/{id}")
    public Train getTrainById(@PathVariable("id") Long id)
    {
        return trainService.getTrainById(id);
    }
    @PutMapping("/{id}")
    public Train updateTrain( @PathVariable("id") Long id, @RequestBody Train train){
        return trainService.updateTrain(id,train);
    }

    @DeleteMapping("/{id}")
    public void deleteTrainById(@PathVariable("id") Long id){
        trainService.deleteTrainById(id);
    }


}
