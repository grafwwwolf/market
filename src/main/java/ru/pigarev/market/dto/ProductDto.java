package ru.pigarev.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import ru.pigarev.market.model.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;

    @NotNull(message = "Поле 'Наименование продукта' должно быть заполнено")
    @Length(min = 3, max = 255, message = "Название продукта должно содержать от 3 до 255 символов. Проверьте длину.")
    private String title;
    @NotNull
    @Min(value = 1, message = "Цена товара не должна быть меньше 1 рубля.")
    private Double cost;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.cost = product.getCost();
    }
}
