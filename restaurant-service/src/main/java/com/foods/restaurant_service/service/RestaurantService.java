package com.foods.restaurant_service.service;

import com.foods.restaurant_service.exception.RestaurantNotFoundException;
import com.foods.restaurant_service.model.Restaurant;
import com.foods.restaurant_service.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }


    public Restaurant getByName(String name) {
        return restaurantRepository.findByName(name)
                .orElseThrow(()->new RestaurantNotFoundException("Restaurant not found by this name"+name+" ."));
    }
}
