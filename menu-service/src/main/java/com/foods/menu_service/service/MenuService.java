package com.foods.menu_service.service;

import com.foods.menu_service.model.MenuItem;
import com.foods.menu_service.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final WebClient.Builder WebClientBuilder;

    private static final String RESTAURANT_SERVICE_URL = "http://restaurant-service";

    public Mono<MenuItem> addMenu(String restaurantName, MenuItem menuItem){
        return WebClientBuilder.build()
                .get()
                .uri(RESTAURANT_SERVICE_URL+"/restaurants/{name}/", restaurantName)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response->Mono.error(new RuntimeException("Restaurant not found")))
                .bodyToMono(Void.class)
                .then(menuRepository.save(menuItem));
    }

    public Flux<MenuItem> getMenuByRestaurant(String restaurantName, int page, int size){
        return menuRepository.findByRestaurantName(restaurantName, PageRequest.of(page, size))
                .collectList()
                .map(item->item.stream()
                        .filter(MenuItem::isAvailability)
                        .collect(Collectors.toList()))
                .flatMapMany(Flux::fromIterable);
    }

    public Flux<MenuItem> getMenuByCategory(String restaurantName, String category, int page, int size) {
        return menuRepository.findByRestaurantNameAndCategory(restaurantName,category, PageRequest.of(page,size));
    }


    public Mono<Void> deleteMenuItem(String restaurantName, String itemName) {
        return menuRepository.deleteByRestaurantNameAndItemName(restaurantName,itemName);
    }
}
