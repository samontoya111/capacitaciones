package session2.inventory.services.historical;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import session2.inventory.anotations.enums.EnumMethodWebService;
import session2.inventory.entities.hitorical.Historical;
import session2.inventory.entities.hitorical.HistoricalRepository;
import session2.inventory.entities.product.Product;
import session2.inventory.entities.product.ProductRepository;
import session2.inventory.rest.product.request.ProductRequest;
import session2.inventory.rest.product.request.SearchRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service

@AllArgsConstructor
public class HistoricalService {
    private final HistoricalRepository historicalRepository;

    public void save(EnumMethodWebService enumMethodWebService) {
        Historical historical = Historical.builder()
                .date(LocalDateTime.now())
                .method(enumMethodWebService)

                .build();

        historicalRepository.save(historical);
    }
}
