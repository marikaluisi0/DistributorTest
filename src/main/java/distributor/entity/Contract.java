package distributor.entity;

import distributor.ContractType;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private ContractType type;
    private Date startDate;

    @ManyToOne
    @JoinColumn(name = "customer_codicefiscale")
    private Customer customer;

    public Contract() {

    }

    public Contract(int id, ContractType type, Date startDate, Customer customer) {
        this.id = id;
        this.type = type;
        this.startDate = startDate;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContractType getType() {
        return type;
    }

    public void setType(ContractType type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
