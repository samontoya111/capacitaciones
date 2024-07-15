package sessiontwo.inventory.rest;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sessiontwo.inventory.entities.product.Product;
import sessiontwo.inventory.exception.CustomException;
import sessiontwo.inventory.rest.request.ProductRequest;
import sessiontwo.inventory.rest.request.SearchRequest;
import sessiontwo.inventory.services.product.ProductService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/create")
    public ResponseEntity<String> createProducts() {
         return productService.create();
    }
    @GetMapping("/add")
    public ResponseEntity<String> add(@RequestBody Product product) {
        return productService.add(product);
    }
    @GetMapping("/list")
    public List<Product> list() {
        return productService.list();
    }
    @GetMapping("/update")
    public ResponseEntity<String> update(@RequestBody ProductRequest productRequest) throws CustomException {
        return productService.update(productRequest);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Product>> search(@RequestBody SearchRequest searchRequest) {
        return productService.search(searchRequest);
    }
    @GetMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) throws CustomException {
        return productService.delete(id);
    }
}
