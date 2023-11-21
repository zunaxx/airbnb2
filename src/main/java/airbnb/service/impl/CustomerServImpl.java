package airbnb.service.impl;

import airbnb.model.Customer;
import airbnb.repository.CustomerRepository;
import airbnb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void save(Customer customer) {
    customerRepository.save(customer);
    }
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public String delete(Long id) {
        return customerRepository.delete(id);
    }

    @Override
    public String update(Long id, Customer newCustomer) {
        return customerRepository.update(id, newCustomer);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.getById(id);
    }
}
