package app.services;

import app.models.SpaceShip;
import app.repositories.SpaceShipRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceShipService {

    private final SpaceShipRepo spaceShipRepo;

    public SpaceShipService(SpaceShipRepo spaceShipRepo) {
        this.spaceShipRepo = spaceShipRepo;
    }

    public List<SpaceShip> getAllSpaceShip() {
        return (List<SpaceShip>) spaceShipRepo.findAll();
    }

    public SpaceShip getById(long id) {

        Optional<SpaceShip> spaceship = spaceShipRepo.findById(id);

        return spaceship.orElseGet(SpaceShip::new);
    }

    public List<SpaceShip> getAllSpaceShipWhereIsActive(boolean isActive) {
        return spaceShipRepo.findSpaceShipByActive(isActive);
    }

    public void saveNewSpaceShip(SpaceShip spaceShip){
        spaceShipRepo.save(spaceShip);
    }

}
