package com.niraj.railway.service;


import com.niraj.railway.dto.RouteResponseDTO;
import com.niraj.railway.entity.Route;
import com.niraj.railway.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    // Convert Route to DTO
    private RouteResponseDTO convertToDTO(Route route){
        return new RouteResponseDTO(
                route.getRouteId(),
                route.getRouteName(),
                route.getSourceStation(),
                route.getDestinationStation(),
                route.getDistanceKm()
        );
    }

    public RouteResponseDTO addRoute(Route route){
        Route saved = routeRepository.save(route);
        return convertToDTO(saved);
    }

    public List<RouteResponseDTO> getAllRoutes(){
        return routeRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RouteResponseDTO getRouteById(Long id){
        Route route =  routeRepository.findById(id).orElseThrow(() -> new RuntimeException("Route not found"));
        return  convertToDTO(route);
    }

    public RouteResponseDTO updateRoute(Long id, Route route){
        Route existing  = routeRepository.findById(id).orElseThrow(() -> new RuntimeException("Route not found"));
        existing.setRouteName(route.getRouteName());
        existing.setSourceStation(route.getSourceStation());
        existing.setDestinationStation(route.getDestinationStation());
        existing.setDistanceKm(route.getDistanceKm());
        return convertToDTO(routeRepository.save(existing));   }

    public void deleteRoute(Long id){
        routeRepository.deleteById(id);
    }


}
