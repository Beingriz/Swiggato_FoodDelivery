package com.example.Swiggato.utils;

import com.example.Swiggato.model.MenuItem;
import com.example.Swiggato.model.Restaurant;
import com.example.Swiggato.repisoory.CustomerRepository;
import com.example.Swiggato.repisoory.MenuRepository;
import com.example.Swiggato.repisoory.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidateUtils {
    final RestaurantRepository restaurantRepository;
    final CustomerRepository customerRepository;

    final MenuRepository menuRepository;
    @Autowired
    public ValidateUtils(RestaurantRepository restaurantRepository, CustomerRepository customerRepository, MenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.customerRepository = customerRepository;
        this.menuRepository = menuRepository;
    }

    public boolean validateRestaurantId(int id){
        Optional<Restaurant> optionalRestaurant =  restaurantRepository.findById(id);
        return optionalRestaurant.isPresent();
    }

    public boolean ValidateCustomerMobileNo(String mobile){
        if(customerRepository.findByPhoneNo(mobile) !=null){
            return true;
        }
        return false;
    }


    public boolean ValidateMenuItemId(int id){
        Optional<MenuItem> optionalMenuItem = menuRepository.findById(id);
        return optionalMenuItem.isPresent();
    }
}
