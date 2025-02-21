package com.foods.restaurant_service.controller;

import com.foods.restaurant_service.model.Restaurant;
import com.foods.restaurant_service.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant){
        return ResponseEntity.ok(restaurantService.createRestaurant(restaurant));
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @GetMapping("/{name}")
    public Restaurant getById(@PathVariable String name){
        return restaurantService.getByName(name);
    }
}
