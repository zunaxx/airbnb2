package airbnb.repository.impl;

import airbnb.model.House;
import airbnb.repository.HouseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class HouseRepoImpl implements HouseRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(House house) {
        entityManager.persist(house);
    }

    @Override
    public List<House> getAllHouses() {
        return entityManager.createQuery("select h from House h",House.class).getResultList();
    }

    @Override
    public String delete(Long id) {
        entityManager.remove(entityManager.find(House.class,id));
        return "successfully";
    }

    @Override
    public String update(Long id, House newHouse) {
        House house = entityManager.find(House.class,id);
        house.setAddress(newHouse.getAddress());
        house.setDescription(newHouse.getDescription());
        house.setImage(newHouse.getImage());
        house.setCountry(newHouse.getCountry());
        house.setPrice(newHouse.getPrice());
        house.setRoom(newHouse.getRoom());
        return house+" ";
    }

    @Override
    public House getById(Long id) {
        return entityManager.find(House.class,id);
    }
}
