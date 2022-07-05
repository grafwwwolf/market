package ru.pigarev.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.pigarev.market.dto.ProductDto;
import ru.pigarev.market.exceptions.ResourceNotFoundException;
import ru.pigarev.market.model.Product;
import ru.pigarev.market.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class ProductsController {

    private final ProductService productService;

    @GetMapping("/products")
    public Page<ProductDto> findAll(@RequestParam(name = "page", defaultValue = "1") int pageIndex) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return productService.findAll(pageIndex - 1, 10).map(ProductDto::new);
    }

    @GetMapping("/products/{id}")
    public ProductDto findById(@PathVariable Long id) {

        return new ProductDto(productService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product id = " + id + " not found")));
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto save(@RequestBody ProductDto productDto) {

        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setCost(productDto.getCost());
        productService.save(product);

        return new ProductDto(product);
    }

    @PutMapping("/products")
    public void update(@RequestBody ProductDto productDto) {

        productService.updateProductFromDto(productDto);
    }

    @DeleteMapping("/products/{id}")
    public void removeProduct(@PathVariable Long id) {

        productService.removeProduct(id);
    }
}
