package com.niraj.railway.controller;


import com.niraj.railway.entity.Route;
import com.niraj.railway.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteService routeservice;

    @PostMapping
    public Route addRoute (@RequestBody Route route) {
        return routeservice.addRoute(route);
    }

    @GetMapping
    public List<Route> getAllRoutes(){
        return routeservice.getAllRoutes();
    }

    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable("id") Long id){

        return  routeservice.getRouteById(id);
    }
    @PutMapping("/{id}")
    public Route updateRoute(@PathVariable("id") Long id, @RequestBody Route route){
        return routeservice.updateRoute(id, route);}

    @DeleteMapping("/{id}")
    public void deleteRouteById(@PathVariable("id") Long id)   {
        routeservice.deleteRoute(id);
        }

    }

