package com.example.Swiggato.service;

import com.example.Swiggato.dto.request.MenuRequest;
import com.example.Swiggato.dto.request.RestaurantRequest;
import com.example.Swiggato.dto.response.RestaurantResponse;
import com.example.Swiggato.exception.RestaurantNotFoundException;
import com.example.Swiggato.model.MenuItem;
import com.example.Swiggato.model.Restaurant;
import com.example.Swiggato.repisoory.RestaurantRepository;
import com.example.Swiggato.transformer.FoodItemTransformer;
import com.example.Swiggato.transformer.RestaurantTransformer;
import com.example.Swiggato.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    final RestaurantRepository restaurantRepository;
    final ValidateUtils validateUtils;
    @Autowired

    public RestaurantService(RestaurantRepository restaurantRepository, ValidateUtils validateUtils) {
        this.restaurantRepository = restaurantRepository;
        this.validateUtils = validateUtils;
    }

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {

        // Dto to modedl
        Restaurant restaurant = RestaurantTransformer.restaurantResquesttoRestaurant(restaurantRequest);
        Restaurant savedrestaurant =  restaurantRepository.save(restaurant); // Saved in db

        // Converto Response DTO

        return RestaurantTransformer.restaurantToRestaurantResponse(savedrestaurant);
    }

    public String openOrCloseRestaurant(int id) {
      if(!validateUtils.validateRestaurantId(id)){
          throw new RestaurantNotFoundException("Invalid Restaurant Id!");
      }
      Restaurant restaurant = restaurantRepository.findById(id).get();
      restaurant.setOpened(!restaurant.isOpened());
      restaurantRepository.save(restaurant);

      if(restaurant.isOpened()){
          return " Retaurant is now Opend!..";
      }
      return " Restaurant is now Closed";
    }

    public RestaurantResponse addFoodItemtoRestaurant(MenuRequest menuRequest) throws RuntimeException {
        // Check the Restaurant is valid or Not
        if(!validateUtils.validateRestaurantId(menuRequest.getRestaurantId())){
            throw new RestaurantNotFoundException("Invalid Restaurant Id!");
        }
        Restaurant restaurant = restaurantRepository.findById(menuRequest.getRestaurantId()).get();
        MenuItem menuItem = FoodItemTransformer.foodRequestToFoodItem(menuRequest);
        menuItem.setRestaurant(restaurant);
        restaurant.getAvailableMenuItems().add(menuItem);
        Restaurant savedRestaurant  = restaurantRepository.save(restaurant);

        // Convert to Resposnse.
        return RestaurantTransformer.restaurantToRestaurantResponse(restaurant);

    }
}
