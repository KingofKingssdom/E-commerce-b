package com.laptrinhweb.backend.Controller;

import com.laptrinhweb.backend.Entity.Cart;
import com.laptrinhweb.backend.Entity.Product;
import com.laptrinhweb.backend.Service.CartService;
import com.laptrinhweb.backend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;
    private ProductService productService;
    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }
    @PostMapping("/addCart")
    public ResponseEntity<?> addCart(@RequestBody Cart cart) {
        try {
            cartService.addCart(cart);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public List<Cart> getAll() {
        return cartService.findAllCart();

    }
    @DeleteMapping("{id}")
    public void deleteCart(@PathVariable int id){
        Cart cart = cartService.findCartById(id);
        cartService.deleteCartById(cart);

    }

}
