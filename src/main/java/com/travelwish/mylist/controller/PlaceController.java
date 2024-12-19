package com.travelwish.mylist.controller;

import com.travelwish.mylist.entity.Place;
import com.travelwish.mylist.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/places")

public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping
    public List<Place> getAll(){
        return placeService.getPlaces();
    }

    @GetMapping("/{id}")
    public Optional<Place> getById(@PathVariable("id") Integer id){
        return placeService.getPlaces(id);
    }

    @PostMapping
    public Place saveUpdate(@RequestBody Place place ){
        placeService.saveOrUpdate(place);
        return place;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable( "id") Integer id){
        placeService.delete(id);
    }
}
