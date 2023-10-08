package com.example.Swiggato.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FoodRequest {
    int requiredQuantity;
    String mobileNo;
    int menuId;
}
