package airbnb.repository;

public interface BookingRepo {
    boolean booked(Long id);
    boolean unBooked(Long id);
}
