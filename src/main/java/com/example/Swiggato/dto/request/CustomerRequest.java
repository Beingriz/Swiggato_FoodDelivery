package com.example.Swiggato.dto.request;

import com.example.Swiggato.Enum.Gender;
import com.example.Swiggato.dto.response.CartResponse;
import com.example.Swiggato.dto.response.CustomerResponse;
import com.example.Swiggato.model.Cart;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CustomerRequest {
    String name;

    String email;

    String address;

    String mobileNo;

    Gender gender;


}
