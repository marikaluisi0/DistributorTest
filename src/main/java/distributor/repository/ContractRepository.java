package distributor.repository;

import distributor.ContractType;
import distributor.entity.Contract;
import distributor.entity.Customer;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContractRepository extends ListCrudRepository<Contract, Integer> {
    List<Contract> findByDate(Date startDate);

    List<Contract> findByType(ContractType type);


}
