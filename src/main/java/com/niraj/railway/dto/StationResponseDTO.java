package com.niraj.railway.dto;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationResponseDTO {

    private Long stationId;
    private String stationName;
    private String stationCode;
    private String city;

}
