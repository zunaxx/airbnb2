package airbnb.repository.impl;

import airbnb.repository.BookingRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class BookingRepoImpl implements BookingRepo {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public boolean booked(Long id) {
        return false;
    }

    @Override
    public boolean unBooked(Long id) {
        return false;
    }
}
