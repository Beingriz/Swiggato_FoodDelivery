package com.example.Swiggato.dto.response;

import com.example.Swiggato.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class FoodResponse {
    String dishName;
    double price;
    FoodCategory foodCategory;
    boolean veg;
}
