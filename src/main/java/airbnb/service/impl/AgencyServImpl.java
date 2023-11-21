package airbnb.service.impl;

import airbnb.model.Agency;
import airbnb.repository.AgencyRepository;
import airbnb.repository.CustomerRepository;
import airbnb.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AgencyServImpl implements AgencyService {
    @Autowired
    private AgencyRepository agencyRepository;

    private CustomerRepository customerRepository;

    @Override
    public void save(Agency agency) {
    agencyRepository.save(agency);
    }

    @Override
    public List<Agency> getAllAgencies() {
        return agencyRepository.getAllAgencies();
    }

    @Override
    public void delete(long id) {
        agencyRepository.delete(id);
    }

    @Override
    public String update(long id, Agency newAgency) {
        return agencyRepository.update(id, newAgency);
    }

    @Override
    public String getHousesAndCustomersByAgencyId(long id) {
        return agencyRepository.getHousesAndCustomersByAgencyId(id);
    }

    @Override
    public Agency getById(long id) {
        return agencyRepository.getById(id);
    }

    @Override
    public void assign(Long agencyIdId, Long customerId) {
        agencyRepository.assign(agencyIdId,customerId);
    }

    @Override
    public List<Agency> searchAgencies(String searchTerm) {
        return agencyRepository.searchAgencies(searchTerm);
    }
}
