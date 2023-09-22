package com.example.Swiggato.model;

import com.example.Swiggato.Enum.FoodCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "food_item")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String itemName;

    double cost;

    @Enumerated(EnumType.STRING)
    FoodCategory category;

    boolean available;

    boolean veg;

    @ManyToOne
    @JoinColumn
    Cart cart;

    @ManyToOne
    @JoinColumn
    OrderEntity order;

    @ManyToOne
    @JoinColumn
    Restaurant restaurant;
}
