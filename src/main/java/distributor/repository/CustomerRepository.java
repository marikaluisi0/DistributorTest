package distributor.repository;

import distributor.CustomerType;
import distributor.entity.Customer;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends ListCrudRepository<Customer, String> {
    List<Customer> findByName(String name);

    List<Customer> findByType(CustomerType type);


}
