package com.niraj.railway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponseDTO {

    private Long scheduleId;

    private String trainName;
    private String routeName;
    private String departureTime;
    private String arrivalTime;
    private Integer availableSeats;
}
