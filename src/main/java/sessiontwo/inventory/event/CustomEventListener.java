package sessiontwo.inventory.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import sessiontwo.inventory.entities.product.Product;
import sessiontwo.inventory.services.product.ProductService;

@Component
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    private final ProductService productService;

    public CustomEventListener(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void onApplicationEvent(CustomEvent event) {
        Product product = event.getProduct();
        productService.resupply(product);
    }
}
