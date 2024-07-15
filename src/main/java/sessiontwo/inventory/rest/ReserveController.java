package sessiontwo.inventory.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import sessiontwo.inventory.exception.CustomException;
import sessiontwo.inventory.rest.request.ProductRequest;
import sessiontwo.inventory.services.reserve.ReserveService;

@RequestMapping("/api/reserve")
@AllArgsConstructor
public class ReserveController {
    private final ReserveService reserveService;

    @GetMapping("")
    public ResponseEntity<String> createProducts(@RequestBody ProductRequest productRequest) throws CustomException {
        return reserveService.reserve(productRequest);
    }
    @GetMapping("/release")
    public ResponseEntity<String> add(@RequestBody ProductRequest productRequest) throws CustomException {
        return reserveService.release(productRequest);
    }

}
