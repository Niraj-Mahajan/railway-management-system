package com.niraj.railway.controller;

import com.niraj.railway.dto.ScheduleResponseDTO;
import com.niraj.railway.entity.Schedule;
import com.niraj.railway.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDTO> addSchedule(@RequestBody Schedule schedule){
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.addSchedule(schedule));
    }
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDTO>> getAllSchedules(){
        return ResponseEntity.ok(scheduleService.getAllSchedules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDTO> getScheduleById(@PathVariable("id") Long id){
        return ResponseEntity.ok(scheduleService.getScheduleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDTO> updateSchedule(@PathVariable("id") Long id, @RequestBody Schedule schedule){
        return ResponseEntity.ok(scheduleService.updateSchedule(id, schedule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable("id") Long id)
    {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
