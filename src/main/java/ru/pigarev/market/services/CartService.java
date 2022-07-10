package ru.pigarev.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pigarev.market.model.Cart;
import ru.pigarev.market.model.Product;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CartService {

    private final Cart cart;

    public void saveToCart(Product product) {

        cart.addProduct(product);
    }

    public void removeFromCart(Long id) {

        cart.removeProduct(id);
    }

    public List<Product> showCart() {
        return cart.getProducts();
    }
}
