package session2.inventory.services.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import session2.inventory.anotations.SaveHistorical;
import session2.inventory.anotations.enums.EnumMethodWebService;
import session2.inventory.entities.product.Product;
import session2.inventory.entities.product.ProductRepository;
import session2.inventory.rest.product.request.ProductRequest;
import session2.inventory.rest.product.request.SearchRequest;

import java.util.ArrayList;
import java.util.List;

@Service

@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @SaveHistorical(method = EnumMethodWebService.ADD)
    public void add(Product product) {
        productRepository.save(product);
    }

    @SaveHistorical(method = EnumMethodWebService.LIST)

    public List<Product> list() {
        return (List<Product>) productRepository.findAll();
    }

    @SaveHistorical(method = EnumMethodWebService.UPDATE)
    public void update(ProductRequest productRequest) {

        Product product = getProduct(productRequest.getId());

        product.setQuantity(productRequest.getQuantity());
        product.setPrice(productRequest.getPrice());
        productRepository.save(product);
    }



    private Product getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return product;
    }

    @SaveHistorical(method = EnumMethodWebService.SEARCH)
    public List<Product> search(SearchRequest searchRequest) {
        return productRepository.findAllByCategoryOrPriceBetween(searchRequest.getCategory(), searchRequest.getPriceMin(), searchRequest.getPriceMax());

    }

    public void create() {
        List<Product> products = new ArrayList<>();
        Product product1 = Product.builder()
                .name("botella")
                .category("casa")
                .quantity(10L)
                .price(1000L)
                .build();

        Product product2 = Product.builder()
                .name("posillo")
                .category("casa")
                .price(2000L)
                .quantity(0L)
                .build();

        products.add(product1);
        products.add(product2);

        productRepository.saveAll(products);
    }

    @SaveHistorical(method = EnumMethodWebService.DELETE)
    public String delete(Long id) {
        Product product = getProduct(id);
        if(product.getQuantity() == 0){
            productRepository.delete(product);
            return "OK";
        } else {
            return "NooK";
        }
    }
}
