package com.example.Swiggato.service;

import com.example.Swiggato.dto.request.CustomerRequest;
import com.example.Swiggato.dto.response.CustomerResponse;
import com.example.Swiggato.exception.CustomerNotFoundException;
import com.example.Swiggato.model.Cart;
import com.example.Swiggato.model.Customer;
import com.example.Swiggato.repisoory.CustomerRepository;
import com.example.Swiggato.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired CustomerRepository customerRepository;
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        // DTO to Customer Model through transfored
        Customer customer = CustomerTransformer.customerRequesttoCustomer(customerRequest);

        // allocate card
        Cart cart = Cart.builder()
                .cartTotal(0).build();

        // Save Both Cart and Customer
        Customer savedCustomer  = customerRepository.save(customer);

        // Customer to Custome Response
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public CustomerResponse findCustomerByMobile(String mobile) {
        Customer customer = customerRepository.findByPhoneNo(mobile);
        if(customer == null){
             throw new CustomerNotFoundException("Invalid mobile No !!..");
        }
        return CustomerTransformer.customerToCustomerResponse(customer);
    }
}
