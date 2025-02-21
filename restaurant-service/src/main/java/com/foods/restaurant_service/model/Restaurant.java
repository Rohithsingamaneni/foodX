package com.foods.restaurant_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "restaurants", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private double rating;
}
