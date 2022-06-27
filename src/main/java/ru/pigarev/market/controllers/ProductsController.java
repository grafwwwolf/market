package ru.pigarev.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.pigarev.market.dto.ProductDto;
import ru.pigarev.market.model.Product;
import ru.pigarev.market.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class ProductsController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> findAll() {

        return productService.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @GetMapping("/products/after/{minPrice}")
    public List<Product> findByCostAfter(@PathVariable Double minPrice) {

        return productService.findByCostAfter(minPrice);
    }

    @GetMapping("/products/before/{maxPrice}")
    public List<Product> findByCostBefore(@PathVariable Double maxPrice) {

        return productService.findByCostBefore(maxPrice);
    }

    @GetMapping("/products/between")
    public List<Product> findByCostBetween(@RequestParam(name = "min") Double minPrice,
                                           @RequestParam(name = "max") Double maxPrice) {

        return productService.findByCostBetween(minPrice, maxPrice);
    }

    @GetMapping("/products/{id}")
    public ProductDto findById(@PathVariable Long id) {

        return new ProductDto(productService.findById(id).get());
    }

    @PostMapping("/products")
    public ProductDto save(@RequestBody ProductDto productDto) {

        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setCost(productDto.getCost());
        productService.save(product);

        return new ProductDto(product);
    }

    @GetMapping("/products/delete/{id}")
    public void removeProduct(@PathVariable Long id) {

        productService.removeProduct(id);

    }
}
