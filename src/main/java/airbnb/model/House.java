package airbnb.model;

import airbnb.enums.HouseType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@AllArgsConstructor
@ToString
@Table(name = "houses")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "house_gen")
    @SequenceGenerator(name = "house_gen",
            sequenceName = "house_seq",
            allocationSize = 1)
    private Long id;
    private String address;
    private int price;
    private int room;
    private String country;
    private String description;
    private boolean isBooked;
    @Enumerated
    private HouseType houseType;
    private String image;
    @OneToOne()
    private Booking booking;
    @ManyToOne()
    private Agency agency;

    public House() {
    }

    public House(String address, int price, int room, String country, String description, boolean isBooked, HouseType houseType, String image, Agency agency) {
        this.address = address;
        this.price = price;
        this.room = room;
        this.country = country;
        this.description = description;
        this.isBooked = isBooked;
        this.houseType = houseType;
        this.image = image;
        this.agency = agency;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public void setRoom(int room) {
        this.room = room;
    }


    public void setCountry(String country) {
        this.country = country;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public void setAgency(Agency agency) {
        this.agency = agency;
    }
}
