package app.services;

import app.models.SpaceShip;
import app.repositories.SpaceShipRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceShipService {

    private final SpaceShipRepo spaceShipRepo;

    public SpaceShipService(SpaceShipRepo spaceShipRepo) {
        this.spaceShipRepo = spaceShipRepo;
    }

    public List<SpaceShip> getAllSpaceShip() {
        return (List<SpaceShip>) spaceShipRepo.findAll();
    }

    public List<SpaceShip> getAllSpaceShipWhereIsActive(boolean isActive) {
        return spaceShipRepo.findSpaceShipByActive(isActive);
    }

}
