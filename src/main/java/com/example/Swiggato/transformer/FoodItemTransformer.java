package com.example.Swiggato.transformer;

import com.example.Swiggato.dto.request.FoodRequest;
import com.example.Swiggato.dto.response.FoodResponse;
import com.example.Swiggato.model.FoodItem;

public class FoodItemTransformer {
    public static FoodItem foodRequestToFoodItem(FoodRequest foodRequest){
        return FoodItem.builder()
                .itemName(foodRequest.getItemName())
                .category(foodRequest.getCategory())
                .cost(foodRequest.getCost())
                .available(foodRequest.isAvailable())
                .build();
    }
    public static FoodResponse foodItemToFoodResponse(FoodItem foodItem){
        return FoodResponse.builder()
                .dishName(foodItem.getItemName())
                .veg(foodItem.isVeg())
                .foodCategory(foodItem.getCategory())
                .price(foodItem.getCost())
                .build();
    }
}
