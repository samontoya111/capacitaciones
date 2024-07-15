package sessiontwo.inventory.event;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import sessiontwo.inventory.entities.product.Product;

@Component
@AllArgsConstructor
public class EventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publishProductEvent(final Product product) {
        CustomEvent customEvent = new CustomEvent(this, product);
        applicationEventPublisher.publishEvent(customEvent);
    }
}
