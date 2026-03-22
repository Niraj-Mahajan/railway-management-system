package com.niraj.railway.controller;

import com.niraj.railway.dto.StationResponseDTO;
import com.niraj.railway.entity.Station;
import com.niraj.railway.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stations")

public class StationController {

    @Autowired
    private StationService stationservice;


    @PostMapping
    public ResponseEntity<StationResponseDTO> addStation(@RequestBody Station station){
        return ResponseEntity.status(HttpStatus.CREATED).body( stationservice.addStation(station));
    }
    @GetMapping
    public ResponseEntity<List<StationResponseDTO>> getAllStations(){
        return ResponseEntity.ok(stationservice.getAllStations());
    }
    @GetMapping("/{id}")
    public ResponseEntity<StationResponseDTO> getStationById(@PathVariable("id") Long id)
    {
        return ResponseEntity.ok(stationservice.getStationByID(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<StationResponseDTO> updateStation( @PathVariable("id") Long id, @RequestBody Station station){
        return ResponseEntity.ok(stationservice.updateStation(id,station));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStationById(@PathVariable("id") Long id){
        stationservice.deleteStation(id);
        return ResponseEntity.noContent().build();
    }

}
