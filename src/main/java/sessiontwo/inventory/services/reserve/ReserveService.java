package sessiontwo.inventory.services.reserve;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sessiontwo.inventory.constants.Constants;
import sessiontwo.inventory.entities.reserve.Reserve;
import sessiontwo.inventory.entities.reserve.ReserveRepository;
import sessiontwo.inventory.exception.CustomException;
import sessiontwo.inventory.rest.request.ProductRequest;
import sessiontwo.inventory.services.product.ProductService;

@Service

@AllArgsConstructor
public class ReserveService {
    private final ProductService productService;
    private final ReserveRepository reserveRepository;


    public ResponseEntity<String> reserve(ProductRequest productRequest) throws CustomException {

        productService.updateQuantity(productRequest, null);

        Reserve reserve = getReserve(productRequest.getId());
        if (reserve == null) {
            reserve = Reserve.builder()
                    .idProduct(productRequest.getId())
                    .quantity(productRequest.getQuantity())
                    .build();
        } else {
            reserve.setQuantity(reserve.getQuantity() + productRequest.getQuantity());
        }

        reserveRepository.save(reserve);
        return new ResponseEntity<>(Constants.RESERVE, HttpStatus.OK);

    }

    public ResponseEntity<String> release(ProductRequest productRequest) throws CustomException {

        Reserve reserve = getReserve(productRequest.getId());
        productService.updateQuantity(productRequest, reserve);

        reserve.setQuantity(0L);


        reserveRepository.save(reserve);
        return new ResponseEntity<>(Constants.RELEASE_RESERVE, HttpStatus.OK);

    }

    public Reserve getReserve(Long productID) {
        return reserveRepository.findByIdProduct(productID);

    }
}
