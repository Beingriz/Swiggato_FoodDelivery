package com.example.Swiggato.dto.request;

import com.example.Swiggato.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FoodRequest {
    int restaurantId;
    String itemName;
    double cost;
    FoodCategory category;
    boolean available;
    boolean veg;

}
