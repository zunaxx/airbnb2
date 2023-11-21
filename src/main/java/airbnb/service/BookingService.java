package airbnb.service;

public interface BookingService {
    boolean booked(Long id);
    boolean unBooked(Long id);
}
