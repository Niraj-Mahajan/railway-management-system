package com.niraj.railway.controller;


import com.niraj.railway.dto.TrainResponseDTO;
import com.niraj.railway.entity.Train;
import com.niraj.railway.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {


    @Autowired
    private TrainService trainService;

    @PostMapping
    public  ResponseEntity<TrainResponseDTO> addTrain(@RequestBody Train train){
        return ResponseEntity.status(HttpStatus.CREATED).body(trainService.addTrain(train));
    }
    @GetMapping
    public ResponseEntity<List<TrainResponseDTO >> getAllTrains(){
        return ResponseEntity.ok(trainService.getAllTrains());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TrainResponseDTO>  getTrainById(@PathVariable("id") Long id)
    {
        return ResponseEntity.ok(trainService.getTrainById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<TrainResponseDTO>  updateTrain( @PathVariable("id") Long id, @RequestBody Train train){
        return ResponseEntity.ok(trainService.updateTrain(id,train));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainById(@PathVariable("id") Long id){
        trainService.deleteTrainById(id);
       return ResponseEntity.noContent().build();
    }


}
