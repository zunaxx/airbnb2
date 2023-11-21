package airbnb.repository;

import airbnb.model.Agency;

import java.util.List;

public interface AgencyRepository {
    void save(Agency agency);
    List<Agency> getAllAgencies();
    void delete(long id);
    String update(long id, Agency newAgency);
    String getHousesAndCustomersByAgencyId(long id);
    Agency getById(long id);
    void assign(Long agencyId, Long customerId);
    public List<Agency> searchAgencies(String searchTerm);
}
