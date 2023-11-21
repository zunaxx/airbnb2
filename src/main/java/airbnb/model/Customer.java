package airbnb.model;

import airbnb.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_gen")
    @SequenceGenerator(name = "customer_gen",
            sequenceName = "customer_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String surName;
    @Column(unique = true)
    private String email;
    @Column(length = 13)
    private String phoneNumber;
    @Enumerated
    private Gender gender;
    private LocalDate dateOfBirth;
    @Column(length = 200000)
    private String image;

    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings;

    @ManyToMany()
    private List<Agency> agencies;

    public Customer() {
    }

    public Customer(String name, String surName, String email, String phoneNumber, Gender gender, LocalDate dateOfBirth, String image) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.image = image;
    }
}

