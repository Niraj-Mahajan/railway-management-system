package com.niraj.railway.controller;


import com.niraj.railway.dto.RouteResponseDTO;
import com.niraj.railway.entity.Route;
import com.niraj.railway.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteService routeservice;

    @PostMapping
    public ResponseEntity<RouteResponseDTO> addRoute (@RequestBody Route route) {
        return ResponseEntity.status(HttpStatus.CREATED).body(routeservice.addRoute(route));
    }

    @GetMapping
    public ResponseEntity<List<RouteResponseDTO>> getAllRoutes(){
        return ResponseEntity.ok(routeservice.getAllRoutes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteResponseDTO> getRouteById(@PathVariable("id") Long id){

        return  ResponseEntity.ok(routeservice.getRouteById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<RouteResponseDTO> updateRoute(@PathVariable("id") Long id, @RequestBody Route route){
        return ResponseEntity.ok(routeservice.updateRoute(id, route));}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRouteById(@PathVariable("id") Long id)   {
        routeservice.deleteRoute(id);
        return ResponseEntity.noContent().build();

        }

    }

