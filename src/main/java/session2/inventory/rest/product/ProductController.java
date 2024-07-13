package session2.inventory.rest.product;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import session2.inventory.entities.product.Product;
import session2.inventory.rest.product.request.ProductRequest;
import session2.inventory.rest.product.request.SearchRequest;
import session2.inventory.services.product.ProductService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/create")
    public void createProducts() {
        productService.create();
    }
    @GetMapping("/add")
    public void add(@RequestBody Product product) {
        productService.add(product);
    }
    @GetMapping("/list")
    public List<Product> list() {
        return productService.list();
    }
    @GetMapping("/update")
    public void update(@RequestBody ProductRequest productRequest) {
        productService.update(productRequest);
    }
    @GetMapping("/search")
    public List<Product> search(@RequestBody SearchRequest searchRequest) {
        return productService.search(searchRequest);
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        return productService.delete(id);
    }
}
