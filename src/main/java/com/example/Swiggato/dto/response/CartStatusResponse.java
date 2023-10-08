package com.example.Swiggato.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CartStatusResponse {
    String CustomerName;
    String CustomerMobile;
    String Address;
    int Total;

    List<FoodResponse> foodList;
    String RestaurantName;

}
