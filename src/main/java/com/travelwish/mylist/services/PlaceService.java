package com.travelwish.mylist.services;

import com.travelwish.mylist.entity.Place;
import com.travelwish.mylist.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    PlaceRepository placeRepository;

    public List<Place> getPlaces(){
        return placeRepository.findAll();
    }

    public Optional<Place> getPlaces(Integer id){
        return placeRepository.findById(id);
    }

    public void saveOrUpdate(Place place){
        placeRepository.save(place);
    }

    public void delete(Integer id){
        placeRepository.deleteById(id);
    }

}
