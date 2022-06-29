package ru.pigarev.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pigarev.market.model.Product;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String title;
    private Double cost;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.cost = product.getCost();
    }
}
