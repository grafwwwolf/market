package ru.pigarev.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pigarev.market.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCostAfter(Double minCost);
    List<Product> findByCostBefore(Double maxPrice);
    List<Product> findByCostBetween(Double minCost, Double maxPrice);
}
