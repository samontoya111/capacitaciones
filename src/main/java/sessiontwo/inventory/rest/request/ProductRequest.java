package sessiontwo.inventory.rest.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private Long id;
    private Long quantity;
    private Long price;
}
