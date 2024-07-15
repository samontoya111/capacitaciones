package sessiontwo.inventory.entities.product;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllByCategoryOrPriceBetween(String category, Long priceMin , Long PriceMax);
}
