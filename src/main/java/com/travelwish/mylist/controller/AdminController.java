package com.travelwish.mylist.controller;


import com.travelwish.mylist.entity.Place;
import com.travelwish.mylist.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PlaceService placeService;

    @GetMapping
    public String getPlaces(Model model) {
        List<Place> places = placeService.getPlaces();
        model.addAttribute("places", places);
        return "admin";
    }

    @PostMapping("/save")
    public String saveOrUpdatePlace(@ModelAttribute Place place) {
        try {
            placeService.saveOrUpdate(place);
            return "redirect:/admin";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/delete/{id}")
    public String deletePlace(@PathVariable Integer id) {
        placeService.delete(id);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editPlace(@PathVariable Integer id, Model model) {
        Place place = placeService.getPlaces(id).orElse(new Place());
        model.addAttribute("place", place);
        return "editPlace";
    }
}

