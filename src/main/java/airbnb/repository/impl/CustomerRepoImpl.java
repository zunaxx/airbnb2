package airbnb.repository.impl;

import airbnb.model.Customer;
import airbnb.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class CustomerRepoImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return entityManager.createQuery("select c from Customer c", Customer.class).getResultList();
    }

    @Override
    public String delete(Long id) {
        entityManager.remove(entityManager.find(Customer.class,id));
        return "successfully";
    }

    @Override
    public String update(Long id, Customer newCustomer) {
        Customer customer = entityManager.find(Customer.class,id);
        customer.setName(newCustomer.getName());
        customer.setSurName(newCustomer.getSurName());
        customer.setEmail(newCustomer.getEmail());
        customer.setPhoneNumber(newCustomer.getPhoneNumber());
        entityManager.persist(customer);
        return "successfully";
    }

    @Override
    public Customer getById(Long id) {
        return entityManager.find(Customer.class,id);
    }
}
