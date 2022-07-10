package ru.pigarev.market.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.pigarev.market.exceptions.CartExistProductException;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Cart {

    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {

        if (products.contains(product)) {
            throw new CartExistProductException("Продукт уже добавлен в корзину");
        } else {
            products.add(product);
        }
    }

    public void removeProduct(Long id) {

        for (Product prod : products) {
            if (prod.getId().equals(id)) {
               products.remove(prod);
                return;
            }
        }
    }
}
