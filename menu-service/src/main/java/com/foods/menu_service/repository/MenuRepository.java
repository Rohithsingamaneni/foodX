package com.foods.menu_service.repository;

import com.foods.menu_service.model.MenuItem;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.Pageable;

@Repository
public interface MenuRepository extends ReactiveCrudRepository<MenuItem,Long> {
    Flux<MenuItem> findByRestaurantName(String  restaurantName, Pageable pageable);
    Flux<MenuItem> findByRestaurantNameAndCategory(String restaurantName, String category, Pageable pageable);
    Mono<Void> deleteByRestaurantNameAndItemName(String restaurantName, String itemName);
}
