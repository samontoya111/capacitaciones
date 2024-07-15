package sessiontwo.inventory.services.product;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sessiontwo.inventory.anotations.SaveHistorical;
import sessiontwo.inventory.anotations.enums.EnumMethodWebService;
import sessiontwo.inventory.constants.Constants;
import sessiontwo.inventory.entities.product.Product;
import sessiontwo.inventory.entities.product.ProductRepository;
import sessiontwo.inventory.entities.reserve.Reserve;
import sessiontwo.inventory.event.EventPublisher;
import sessiontwo.inventory.exception.CustomException;
import sessiontwo.inventory.rest.request.ProductRequest;
import sessiontwo.inventory.rest.request.SearchRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service

@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final EventPublisher eventPublisher;


    @SaveHistorical(method = EnumMethodWebService.ADD)
    public ResponseEntity<String> add(Product product) {
        productRepository.save(product);
        return new ResponseEntity<>(Constants.ADD_PRODUCT, HttpStatus.OK);
    }

    @SaveHistorical(method = EnumMethodWebService.LIST)

    public List<Product> list() {
        return (List<Product>) productRepository.findAll();
    }

    @SaveHistorical(method = EnumMethodWebService.UPDATE)
    public ResponseEntity<String> update(ProductRequest productRequest) throws CustomException {

        Product product = getProduct(productRequest.getId());
        product.setQuantity(productRequest.getQuantity());
        product.setPrice(product.getQuantity() + productRequest.getPrice());

        eventPublisher.publishProductEvent(product);


        return new ResponseEntity<>(Constants.UPDATE_PRODUCT, HttpStatus.OK);
    }



    private Product getProduct(Long id) throws CustomException {
        return productRepository.findById(id).orElseThrow(() -> new CustomException (Constants.PRODUCT_NOT_FOUND));
    }

    @SaveHistorical(method = EnumMethodWebService.SEARCH)
    public ResponseEntity<List<Product>> search(SearchRequest searchRequest) {
        List<Product> products = productRepository.findAllByCategoryOrPriceBetween(searchRequest.getCategory(), searchRequest.getPriceMin(), searchRequest.getPriceMax());
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    public ResponseEntity<String> create() {
        List<Product> products = new ArrayList<>();
        Product product1 = Product.builder()
                .name("botella")
                .category("casa")
                .quantity(3L)
                .price(1000L)
                .build();

        Product product2 = Product.builder()
                .name("posillo")
                .category("casa")
                .price(2000L)
                .quantity(3L)
                .build();

        products.add(product1);
        products.add(product2);

        productRepository.saveAll(products);
        return new ResponseEntity<>(Constants.ADD_PRODUCT, HttpStatus.OK);
    }

    @SaveHistorical(method = EnumMethodWebService.DELETE)
    public ResponseEntity<String> delete(Long id) throws CustomException {
        Product product = getProduct(id);
        if(Objects.equals(product.getQuantity(), Constants.QUANTITY_TO_DELETE)){
            productRepository.delete(product);
            return new ResponseEntity<>(Constants.DELETE_PRODUCT, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(Constants.DELETE_NOT_PRODUCT, HttpStatus.OK);

        }
    }

    public void updateQuantity(ProductRequest productRequest, Reserve reserve) throws CustomException {

        Product product = getProduct(productRequest.getId());

        if(reserve != null){
            product.setQuantity(product.getQuantity() + reserve.getQuantity());
        } else {
            if(product.getQuantity() -  productRequest.getQuantity() < 0){
                throw new CustomException(Constants.QUANTITY_NOT_RESERVE);
            }
            product.setQuantity(product.getQuantity() - productRequest.getQuantity());
        }

        productRepository.save(product);
    }


    public void resupply(Product product) {
        if(product.getQuantity() <= Constants.MIN_QUANTITY){
            product.setQuantity(product.getQuantity() + Constants.QUANTITY_TO_RESUPPLY);
            productRepository.save(product);
        }
    }

    public List<Product> getOutOfStockProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        return products.stream().filter(product->product.getQuantity() <= 3).toList();
    }
}
