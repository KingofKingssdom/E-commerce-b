package com.laptrinhweb.backend.Service;

import com.laptrinhweb.backend.Entity.Cart;
import com.laptrinhweb.backend.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private CartRepository cartRepository;
    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart findCartById(int id) {
        return cartRepository.findById(id).orElseThrow();
    }
    public void addCart(Cart cart) {
        cartRepository.save(cart);
    }
    public List<Cart> findAllCart(){
        return cartRepository.findAll();
    }
    public void deleteCartById(Cart cart){
        cartRepository.delete(cart);
    }
}
