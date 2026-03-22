package com.niraj.railway.service;

import com.niraj.railway.dto.ScheduleResponseDTO;
import com.niraj.railway.entity.Schedule;
import com.niraj.railway.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    //convert Schedule to DTO
    public ScheduleResponseDTO convertToDTO(Schedule schedule){
        return new ScheduleResponseDTO(
                schedule.getScheduleId(),
                schedule.getTrain().getTrainName(),
                schedule.getRoute().getRouteName(),
                schedule.getDepartureTime(),
                schedule.getArrivalTime(),
                schedule.getAvailableSeats()

        );
    }

    public ScheduleResponseDTO addSchedule(Schedule schedule){
        Schedule saved =  scheduleRepository.save(schedule);
        return convertToDTO(saved);
    }
    public List<ScheduleResponseDTO> getAllSchedules(){
        return scheduleRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ScheduleResponseDTO getScheduleById(Long id){
        Schedule schedule =  scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        return convertToDTO(schedule);

    }

    public ScheduleResponseDTO updateSchedule(Long id, Schedule schedule){

        Schedule existing =  scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        existing.setTrain(schedule.getTrain());
        existing.setRoute(schedule.getRoute());
        existing.setDepartureTime(schedule.getDepartureTime());
        existing.setArrivalTime(schedule.getArrivalTime());
        existing.setAvailableSeats(schedule.getAvailableSeats());
        return convertToDTO(scheduleRepository.save(existing));


    }

    public void deleteSchedule(Long id){
        scheduleRepository.deleteById(id);
    }
}
