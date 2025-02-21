package com.foods.menu_service.controller;

import com.foods.menu_service.model.MenuItem;
import com.foods.menu_service.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/restaurants/{restaurantName}/menus")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @PostMapping
    public Mono<ResponseEntity<MenuItem>> addMenuItem(@PathVariable String restaurantName, @RequestBody MenuItem menuItem){
        return menuService.addMenu(restaurantName,menuItem)
                .map(savedItem->ResponseEntity.ok().body(savedItem))
                .onErrorResume(e->Mono.just(ResponseEntity.badRequest().build()));
    }

    @GetMapping
    public Flux<MenuItem> getMenuByRestaurant(@PathVariable String restaurantName,
                                              @RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10")int size){
        return menuService.getMenuByRestaurant(restaurantName,page,size);

    }

    @GetMapping("/{category}")
    public Flux<MenuItem> getMenuByCategory(@PathVariable String restaurantName,
                                            @PathVariable String category,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10")int size){
        return menuService.getMenuByCategory(restaurantName, category, page, size);
    }

    @DeleteMapping("/{itemName}")
    public Mono<ResponseEntity<Void>> deleteMenuItem(@PathVariable String restaurantName,@PathVariable String itemName){
        return menuService.deleteMenuItem(restaurantName,itemName)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }


}
