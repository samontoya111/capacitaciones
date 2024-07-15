package sessiontwo.inventory.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import sessiontwo.inventory.entities.product.Product;

@Getter
public class CustomEvent extends ApplicationEvent {
    private Product product;

    public CustomEvent(Object source,  Product product) {
        super(source);
        this.product = product;
    }
}
