package com.example.Swiggato.utils;

import com.example.Swiggato.model.Restaurant;
import com.example.Swiggato.repisoory.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidateUtils {
    final RestaurantRepository restaurantRepository;
    @Autowired
    public ValidateUtils(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public boolean validateRestaurantId(int id){
        Optional<Restaurant> optionalRestaurant =  restaurantRepository.findById(id);
        return optionalRestaurant.isPresent();
    }
}
