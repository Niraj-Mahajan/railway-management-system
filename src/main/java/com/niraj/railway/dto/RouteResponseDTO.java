package com.niraj.railway.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteResponseDTO {

    private Long routeId;
    private String routeName;
    private String sourceStation;
    private String destinationStation;
    private Double distanceKm;
}
