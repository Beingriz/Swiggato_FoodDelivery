package com.example.Swiggato.transformer;

import com.example.Swiggato.dto.request.MenuRequest;
import com.example.Swiggato.dto.response.MenuResponse;
import com.example.Swiggato.model.MenuItem;

public class FoodItemTransformer {
    public static MenuItem foodRequestToFoodItem(MenuRequest menuRequest){
        return MenuItem.builder()
                .itemName(menuRequest.getItemName())
                .category(menuRequest.getCategory())
                .cost(menuRequest.getCost())
                .available(menuRequest.isAvailable())
                .build();
    }
    public static MenuResponse foodItemToFoodResponse(MenuItem menuItem){
        return MenuResponse.builder()
                .dishName(menuItem.getItemName())
                .veg(menuItem.isVeg())
                .foodCategory(menuItem.getCategory())
                .price(menuItem.getCost())
                .build();
    }
}
