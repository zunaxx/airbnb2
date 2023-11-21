package airbnb.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "agencies")
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agency_gen")
    @SequenceGenerator(name = "agency_gen",
            sequenceName = "agency_seq",
            allocationSize = 1)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String email;
    @Column(length = 200000)
    private String image;

    @OneToMany(mappedBy = "agency")
    private List<House> houses;

    @ManyToMany(mappedBy = "agencies")
    private List<Customer> customers;

    public Agency() {
    }
    public Agency(String name, String country, String phoneNumber, String email) {
        this.name = name;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
