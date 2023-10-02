package com.example.Swiggato.transformer;

import com.example.Swiggato.dto.request.CustomerRequest;
import com.example.Swiggato.dto.response.CartResponse;
import com.example.Swiggato.dto.response.CustomerResponse;
import com.example.Swiggato.model.Customer;

public class CustomerTransformer {
    public static Customer customerRequesttoCustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .address(customerRequest.getAddress())
                .phoneNo(customerRequest.getMobileNo())
                .gender(customerRequest.getGender())
                .build();
    }

    public static CustomerResponse customerToCustomerResponse(Customer customer){
        CartResponse cartResponse = CartTransformer.cartTocartResponse(customer.getCart());
        return CustomerResponse.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .mobileNo(customer.getPhoneNo())
                .Cart(cartResponse)
                .build();
    }
}
