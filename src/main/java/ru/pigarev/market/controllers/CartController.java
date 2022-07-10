package ru.pigarev.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.pigarev.market.dto.ProductDto;
import ru.pigarev.market.exceptions.ResourceNotFoundException;
import ru.pigarev.market.model.Product;
import ru.pigarev.market.services.CartService;
import ru.pigarev.market.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
@RestController
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> showCart() {

        return cartService.showCart().stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @GetMapping("/add")
    public void saveToCart(@RequestParam(name = "productIdToCart") Long id) {
        Product product = productService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product id = " + id + " not found"));
        cartService.saveToCart(product);
    }

    @DeleteMapping("/products/{id}")
    public void removeFromCart(@PathVariable Long id) {

        cartService.removeFromCart(id);
    }
}
