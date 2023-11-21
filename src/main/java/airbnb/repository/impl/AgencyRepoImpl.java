package airbnb.repository.impl;

import airbnb.model.Agency;
import airbnb.model.Customer;
import airbnb.repository.AgencyRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class AgencyRepoImpl implements AgencyRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Agency agency) {
        entityManager.persist(agency);
    }
    @Override
    public List<Agency> getAllAgencies() {
        return entityManager.createQuery("select a from Agency a", Agency.class).getResultList();
    }

    @Override
    public void delete(long id) {
        Agency agency = entityManager.find(Agency.class, id);
        if (agency != null) {
            entityManager.remove(agency);
        }
    }

    @Override
    public String update(long id, Agency newAgency) {
    Agency agency = entityManager.find(Agency.class,id);
    agency.setName(newAgency.getName());
    agency.setCountry(newAgency.getCountry());
    agency.setEmail(newAgency.getEmail());
    agency.setPhoneNumber(newAgency.getPhoneNumber());
    entityManager.persist(agency);
    return "successfully!";
    }

    @Override
    public String getHousesAndCustomersByAgencyId(long id) {
        return null;
    }

    @Override
    public Agency getById(long id) {
        return entityManager.find(Agency.class,id);
    }

    @Override
    public void assign(Long agencyId, Long customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        Agency agency = entityManager.find(Agency.class, agencyId);
        customer.getAgencies().add(agency);
        agency.getCustomers().add(customer);
        entityManager.merge(customer);
        entityManager.merge(agency);
    }

    @Override
    public List<Agency> searchAgencies(String searchTerm) {
        return entityManager.createQuery("select a from Agency a where lower(a.name) like :searchTerm " +
                        "or lower(a.email) like :searchTerm " +
                        "or lower(a.country) like :searchTerm", Agency.class)
                .setParameter("searchTerm", "%" + searchTerm.toLowerCase() + "%")
                .getResultList();
      //  return entityManager.createQuery("select a from Agency a where a.name=:searchTerm",Agency.class).getResultList();
    }
}
