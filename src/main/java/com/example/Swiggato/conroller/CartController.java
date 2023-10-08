package com.example.Swiggato.conroller;

import com.example.Swiggato.dto.request.FoodRequest;
import com.example.Swiggato.dto.response.CartStatusResponse;
import com.example.Swiggato.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    final CartService cartService;
    @Autowired

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    public ResponseEntity addFoodItemToCart(FoodRequest foodRequest){
        CartStatusResponse cartStatusResponse = cartService.addFootItemToCart(foodRequest);
    }

}
