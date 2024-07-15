package sessiontwo.inventory.entities.reserve;

import org.springframework.data.repository.CrudRepository;



public interface ReserveRepository extends CrudRepository<Reserve, Long> {
    Reserve findByIdProduct(Long productId);
}
