package com.example.Swiggato.conroller;

import com.example.Swiggato.dto.request.CustomerRequest;
import com.example.Swiggato.dto.response.CustomerResponse;
import com.example.Swiggato.model.Customer;
import com.example.Swiggato.service.CustomerService;
import com.example.Swiggato.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

//    // Customer Injection ==  Field Injection   //  Used in corporates for Mocking the Bean during the testing.
//    @Autowire
//    final CustomerService customerService;
//    public CustomerController(CustomerService customerService){
//        this.customerService = customerService;
//
//    }

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse customerResponse =  customerService.addCustomer(customerRequest);
        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);

    }

    //Find customer By Mobile
    @GetMapping("/find/mobile/{mobile}")
    public ResponseEntity findCustomerByMobile(@PathVariable String mobile){
        try {
            CustomerResponse customerResponse = customerService.findCustomerByMobile(mobile);
            return new ResponseEntity<>(customerResponse, HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }
}
