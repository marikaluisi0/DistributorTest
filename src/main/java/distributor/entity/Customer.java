package distributor.entity;

import distributor.CustomerType;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String codiceFiscale;
    private String name;
    private CustomerType type;
    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;

    public Customer() {
    }

    public Customer(String codiceFiscale, String name, CustomerType type, List<Contract> contracts) {
        this.codiceFiscale = codiceFiscale;
        this.name = name;
        this.type = type;
        this.contracts = contracts;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public void setUserContract(Contract contract) {
        contract.setCustomer(this);
        contracts.add(contract);
    }
}
