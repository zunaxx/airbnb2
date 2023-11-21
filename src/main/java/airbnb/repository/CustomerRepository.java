package airbnb.repository;

import airbnb.model.Customer;

import java.util.List;

public interface CustomerRepository {
    void save(Customer customer);
    List<Customer> getAllCustomers();
    String delete(Long id);
    String update(Long id, Customer newCustomer);
    Customer getById(Long id);
}
