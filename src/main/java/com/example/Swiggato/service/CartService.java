package com.example.Swiggato.service;

import com.example.Swiggato.dto.request.FoodRequest;
import com.example.Swiggato.dto.response.CartStatusResponse;
import com.example.Swiggato.exception.CustomerNotFoundException;
import com.example.Swiggato.exception.MenuItemNotFoundException;
import com.example.Swiggato.model.MenuItem;
import com.example.Swiggato.model.Restaurant;
import com.example.Swiggato.repisoory.CustomerRepository;
import com.example.Swiggato.repisoory.MenuRepository;
import com.example.Swiggato.repisoory.RestaurantRepository;
import com.example.Swiggato.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    final ValidateUtils validateUtils;
    final CustomerRepository customerRepository;
    final MenuRepository menuRepository;
    final RestaurantRepository restaurantRepository;
    @Autowired

    public CartService(ValidateUtils validateUtils, CustomerRepository customerRepository, MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.validateUtils = validateUtils;
        this.customerRepository = customerRepository;
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public CartStatusResponse addFootItemToCart(FoodRequest foodRequest) {
        // Check the Customer is Available or Not by the Given Mobile Number
        if(!validateUtils.ValidateCustomerMobileNo(foodRequest.getMobileNo())){
            throw new CustomerNotFoundException("Invalid Mobile Numebr!..");
        }

        // Check the Given Menu id is Valid or Not
        if(!validateUtils.ValidateMenuItemId(foodRequest.getMenuId())){
            throw new MenuItemNotFoundException("Menu Item Not Found for Given Id : "+foodRequest.getMenuId());
        }

        // Check if the Given Menu has the Item or Not
        MenuItem menuItem =  menuRepository.findById(foodRequest.getMenuId()).get();
        if(!menuItem.getRestaurant().isOpened() ||  !menuItem.isAvailable() ){
            throw new MenuItemNotFoundException("Given Dish is Out of Stock");
        }

        // Create Food Item to Add to cArt

    }
}
