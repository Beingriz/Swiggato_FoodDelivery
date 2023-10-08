package com.example.Swiggato.transformer;

import com.example.Swiggato.dto.request.RestaurantRequest;
import com.example.Swiggato.dto.response.MenuResponse;
import com.example.Swiggato.dto.response.RestaurantResponse;
import com.example.Swiggato.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantTransformer {
    public static Restaurant restaurantResquesttoRestaurant(RestaurantRequest restaurantRequest){
            return Restaurant.builder()
                    .name(restaurantRequest.getName())
                    .location(restaurantRequest.getLocation())
                    .contactNo(restaurantRequest.getContactNo())
                    .restaurantCategory(restaurantRequest.getRestaurantCategory())
                    .opened(true)
                    .availableMenuItems(new ArrayList<>())
                    .orders(new ArrayList<>())
                    .build();
    }

    public static RestaurantResponse restaurantToRestaurantResponse(Restaurant restaurant){


        //Creating the List of Food Response from list of Food items of Restaurant usiing Steam API
        List<MenuResponse> menu = restaurant.getAvailableMenuItems()
                .stream()
                .map(foodItem -> FoodItemTransformer.foodItemToFoodResponse(foodItem))
                .toList();


        return RestaurantResponse.builder()
                .name(restaurant.getName())
                .contactNo(restaurant.getContactNo())
                .location(restaurant.getLocation())
                .opened(restaurant.isOpened())
                .menu(menu)
                .build();
    }
}
