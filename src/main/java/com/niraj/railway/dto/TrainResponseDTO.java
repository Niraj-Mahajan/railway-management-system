package com.niraj.railway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainResponseDTO {

    private Long trainId;
    private String trainName;
    private String trainNumber;
    private Integer totalSeats;
    private String status;
}