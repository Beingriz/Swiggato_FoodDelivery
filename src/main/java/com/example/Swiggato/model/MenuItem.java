package com.example.Swiggato.model;

import com.example.Swiggato.Enum.FoodCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "menu_item")
public class MenuItem {
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
    Restaurant restaurant;

   @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    List<FoodItem> foodItems = new ArrayList<>();
}
