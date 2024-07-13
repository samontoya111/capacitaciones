package session2.inventory.rest.product.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private Long id;
    private Long quantity;
    private Long price;
}
