package sessiontwo.inventory.services.historical;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sessiontwo.inventory.anotations.enums.EnumMethodWebService;
import sessiontwo.inventory.entities.hitorical.Historical;
import sessiontwo.inventory.entities.hitorical.HistoricalRepository;

import java.time.LocalDateTime;

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
