package com.example.Swiggato.transformer;

import com.example.Swiggato.dto.response.FoodResponse;
import com.example.Swiggato.model.FoodItem;

public class FoodItemTransformer {

    public static FoodResponse foodItemToFoodResponse(FoodItem foodItem){
        return FoodResponse.builder()
                .dishName(foodItem.getItemName())
                .veg(foodItem.isVeg())
                .foodCategory(foodItem.getCategory())
                .price(foodItem.getCost())
                .build();
    }
}
