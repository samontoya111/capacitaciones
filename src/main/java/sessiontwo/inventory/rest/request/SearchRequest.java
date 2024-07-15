package sessiontwo.inventory.rest.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequest {
    private String category;
    private Long priceMin;
    private Long priceMax;
}
