package com.niraj.railway.service;


import com.niraj.railway.entity.Route;
import com.niraj.railway.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    public Route addRoute(Route route){
        return routeRepository.save(route);
    }

    public List<Route> getAllRoutes(){
        return routeRepository.findAll();
    }

    public Route getRouteById(Long id){
        return routeRepository.findById(id).orElseThrow(() -> new RuntimeException("Route not found"));
    }

    public Route updateRoute(Long id, Route route){
        Route existing  = getRouteById(id);

        existing.setRouteName(route.getRouteName());
        existing.setSourceStation(route.getSourceStation());
        existing.setDestinationStation(route.getDestinationStation());
        existing.setDistanceKm(route.getDistanceKm());
        return routeRepository.save(existing);
    }

    public void deleteRoute(Long id){
        routeRepository.deleteById(id);
    }


}
