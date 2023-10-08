package com.example.Swiggato.model;

import com.example.Swiggato.Enum.RestaurantCategory;
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
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    String location;
    RestaurantCategory restaurantCategory;
    String contactNo;
    boolean opened;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    List<MenuItem> availableMenuItems = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    List<OrderEntity> orders = new ArrayList<>();

}
