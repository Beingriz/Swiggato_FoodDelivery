package com.example.Swiggato.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CustomerResponse {

    String name;
    String email;
    String mobileNo;
    String address;
    CartResponse Cart;

}
