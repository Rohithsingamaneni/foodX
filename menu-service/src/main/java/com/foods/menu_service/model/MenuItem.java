package com.foods.menu_service.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "menu_items")
@Data
@Builder
public class MenuItem {

    @Id
    private Long id;
    private String restaurantName; // Reference to the restaurant (no foreign key)
    private String category;
    private String itemName;
    private String description;
    private double price;
    private boolean availability;
}
