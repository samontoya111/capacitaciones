package session2.inventory.rest.product.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequest {
    private String category;
    private Long priceMin;
    private Long priceMax;
}
