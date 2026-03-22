package com.niraj.railway.controller;

import com.niraj.railway.dto.StationResponseDTO;
import com.niraj.railway.entity.Station;
import com.niraj.railway.entity.Train;
import com.niraj.railway.service.StationService;
import com.niraj.railway.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stations")

public class StationController {

    @Autowired
    private StationService stationservice;


    @PostMapping
    public StationResponseDTO addStation(@RequestBody Station station){
        return stationservice.addStation(station);
    }
    @GetMapping
    public List<StationResponseDTO> getAllStations(){
        return stationservice.getAllStations();
    }
    @GetMapping("/{id}")
    public StationResponseDTO getStationById(@PathVariable("id") Long id)
    {
        return stationservice.getStationByID(id);
    }
    @PutMapping("/{id}")
    public StationResponseDTO updateStation( @PathVariable("id") Long id, @RequestBody Station station){
        return stationservice.updateStation(id,station);
    }

    @DeleteMapping("/{id}")
    public void deleteStationById(@PathVariable("id") Long id){
        stationservice.deleteStation(id);
    }

}
