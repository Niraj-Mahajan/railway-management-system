package com.niraj.railway.service;

import com.niraj.railway.dto.StationResponseDTO;
import com.niraj.railway.entity.Station;
import com.niraj.railway.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    // Convert Station to DTO
    private StationResponseDTO convertToDTO (Station station)
    {
        return new  StationResponseDTO(

                station.getStationId(),
                station.getStationName(),
                station.getStationCode(),
                station.getCity()

        );

    }


    public StationResponseDTO addStation(Station station){
        Station saved = stationRepository.save(station);

        return convertToDTO(saved);
    }

    public List<StationResponseDTO> getAllStations(){
        return stationRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());


    }
    public StationResponseDTO getStationByID(Long id){
        Station station = stationRepository.findById(id).orElseThrow(() -> new RuntimeException ("No Station available"));
        return convertToDTO(station);
    }
    public StationResponseDTO updateStation(Long id, Station station){
        Station existing = stationRepository.findById(id).orElseThrow(() -> new RuntimeException ("No Station available"));
        existing.setStationName(station.getStationName());
        existing.setStationCode(station.getStationCode());
        existing.setCity(station.getCity());
        return convertToDTO(stationRepository.save(existing));


    }

    public void deleteStation(Long id)
    {
        stationRepository.deleteById(id);
    }

}
