package com.niraj.railway.controller;

import com.niraj.railway.dto.ScheduleResponseDTO;
import com.niraj.railway.entity.Schedule;
import com.niraj.railway.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ScheduleResponseDTO addSchedule(@RequestBody Schedule schedule){
        return scheduleService.addSchedule(schedule);
    }
    @GetMapping
    public List<ScheduleResponseDTO> getAllSchedules(){
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public ScheduleResponseDTO getScheduleById(@PathVariable("id") Long id){
        return scheduleService.getScheduleById(id);
    }

    @PutMapping("/{id}")
    public ScheduleResponseDTO updateSchedule(@PathVariable("id") Long id, @RequestBody Schedule schedule){
        return scheduleService.updateSchedule(id, schedule);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable("id") Long id)
    {
        scheduleService.deleteSchedule(id);
    }
}
