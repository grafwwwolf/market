package ru.pigarev.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.pigarev.market.model.Product;
import ru.pigarev.market.repositories.ProductRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public Page<Product> findAll(int pageIndex, int pageSize) {

        return productRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }

    public Optional<Product> findById(Long id) {

        return productRepository.findById(id);
    }

    public Product save(Product product) {

        return productRepository.save(product);
    }

//    public Product update(Product product) {
//
//        Product uprateProduct = findById(product.getId()).orElse()
//
//        return productRepository.save(product);
//    }

    public void removeProduct(Long id) {
        Product product = productRepository.findById(id).get();
        if (Objects.nonNull(product)) {
            productRepository.delete(product);
        }
    }

    public List<Product> findByCostAfter(Double minCost) {

        return productRepository.findByCostAfter(minCost);
    }

    public List<Product> findByCostBefore(Double maxPrice) {

        return productRepository.findByCostBefore(maxPrice);
    }

    public List<Product> findByCostBetween(Double minCost, Double maxPrice) {
        return productRepository.findByCostBetween(minCost, maxPrice);
    }
}
