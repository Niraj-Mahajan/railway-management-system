package com.niraj.railway.service;

import com.niraj.railway.entity.Station;
import com.niraj.railway.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public Station addStation(Station station){
        return stationRepository.save(station);
    }

    public List<Station> getAllStations(){
        return stationRepository.findAll();
    }
    public Station getStationByID(Long id){
        return stationRepository.findById(id).orElseThrow(() -> new RuntimeException ("No Station available"));
    }
    public Station updateStation(Long id, Station station){
        Station existing = getStationByID(id);
        existing.setStationName(station.getStationName());
        existing.setStationCode(station.getStationCode());
        existing.setCity(station.getCity());
        return stationRepository.save(existing);


    }

    public void deleteStation(Long id)
    {
        stationRepository.deleteById(id);
    }

}
