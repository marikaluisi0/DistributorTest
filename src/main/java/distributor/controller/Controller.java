package distributor.controller;

import distributor.ContractType;
import distributor.CustomerType;
import distributor.entity.Contract;
import distributor.entity.Customer;
import distributor.repository.ContractRepository;
import distributor.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/distributor")
public class Controller {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customer/{codicefiscale}")
    public Customer addContract(@PathVariable("codicefiscale") String id, @RequestBody Contract contract) {
        Customer customer = customerRepository.findById(id).get();
        customer.setUserContract(contract);
        return customerRepository.save(customer);

    }

    @GetMapping("/customer/{name}")
    public List<Customer> searchCustomer(@PathVariable("name") String name) {
        List<Customer> customers = customerRepository.findByName(name);
        if (customers.size() <= 0) {
            return null;
        }
        return customers;
    }

    @GetMapping("/contract/{startDate}")
    public List<Contract> searchByStartDate(@PathVariable("startDate") Date date) {
        List<Contract> contracts = contractRepository.findByDate(date);
        if (contracts.size() <= 0) {
            return null;
        }
        return contracts;
    }

    @GetMapping("/contract/{type}")
    public List<Contract> searchByContractType(@PathVariable("type") ContractType type) {
        List<Contract> contracts = contractRepository.findByType(type);
        if (contracts.size() <= 0) {
            return null;
        }
        return contracts;
    }

    @GetMapping("/customer/{type}")
    public List<Customer> searchByCustomerType(@PathVariable("type") CustomerType type) {
        List<Customer> customers = customerRepository.findByType(type);
        if (customers.size() <= 0) {
            return null;
        }
        return customers;
    }

    @GetMapping("/contract/{codiceFiscale}")
    public List<Contract> searchByCustomer(@PathVariable("codiceFiscale") String codiceFiscale) {
        return customerRepository.findById(codiceFiscale).get().getContracts();
    }
}


