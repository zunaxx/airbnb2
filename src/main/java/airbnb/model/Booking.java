package airbnb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_gen")
    @SequenceGenerator(name = "booking_gen",
            sequenceName = "booking_seq",
            allocationSize = 1)
    private Long id;

    private boolean status;

    @OneToOne()
    @JoinColumn(name = "house_id")
    private House house;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Booking() {
    }
}
