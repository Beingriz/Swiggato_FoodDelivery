package com.example.Swiggato.dto.request;

import com.example.Swiggato.Enum.RestaurantCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RestaurantRequest {
    String name;
    String location;
    RestaurantCategory restaurantCategory;
    String contactNo;
    boolean opened;
}
