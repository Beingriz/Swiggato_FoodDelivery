package com.example.Swiggato.service;

import com.example.Swiggato.dto.request.RestaurantRequest;
import com.example.Swiggato.dto.response.RestaurantResponse;
import com.example.Swiggato.exception.RestaurantNotFoundException;
import com.example.Swiggato.model.Restaurant;
import com.example.Swiggato.repisoory.RestaurantRepository;
import com.example.Swiggato.transformer.RestaurantTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {
    final RestaurantRepository restaurantRepository;
    @Autowired

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {

        // Dto to modedl
        Restaurant restaurant = RestaurantTransformer.restaurantResquesttoRestaurant(restaurantRequest);
        Restaurant savedrestaurant =  restaurantRepository.save(restaurant); // Saved in db

        // Converto Response DTO

        return RestaurantTransformer.restaurantToRestaurantResponse(savedrestaurant);
    }

    public String openOrCloseRestaurant(int id) {
      Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
      if(restaurantOptional.isEmpty()){
          throw new RestaurantNotFoundException("Invalid Restaurant Id!");
      }
      Restaurant restaurant = restaurantOptional.get();
      restaurant.setOpened(!restaurant.isOpened());
      restaurantRepository.save(restaurant);

      if(restaurant.isOpened()){
          return " Retaurant is now Opend!..";
      }
      return " Restaurant is now Closed";
    }
}
