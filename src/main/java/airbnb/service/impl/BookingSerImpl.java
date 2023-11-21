package airbnb.service.impl;

import airbnb.repository.BookingRepo;
import airbnb.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingSerImpl implements BookingService {
    @Autowired
    private BookingRepo bookingRepo;

    @Override
    public boolean booked(Long id) {
        return bookingRepo.booked(id);
    }

    @Override
    public boolean unBooked(Long id) {
        return bookingRepo.unBooked(id);
    }
}
