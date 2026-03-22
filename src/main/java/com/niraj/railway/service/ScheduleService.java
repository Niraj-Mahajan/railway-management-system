package com.niraj.railway.service;

import com.niraj.railway.entity.Schedule;
import com.niraj.railway.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule addSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }
    public List<Schedule> getAllSchedules(){
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(Long id){
        return scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    public Schedule updateSchedule(Long id, Schedule schedule){

        Schedule existing =  getScheduleById(id);
        existing.setTrain(schedule.getTrain());
        existing.setRoute(schedule.getRoute());
        existing.setDepartureTime(schedule.getDepartureTime());
        existing.setArrivalTime(schedule.getArrivalTime());
        existing.setAvailableSeats(schedule.getAvailableSeats());
        return scheduleRepository.save(existing);


    }

    public void deleteRoute(Long id){
        scheduleRepository.deleteById(id);
    }
}
