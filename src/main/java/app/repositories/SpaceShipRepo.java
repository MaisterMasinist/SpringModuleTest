package app.repositories;

import app.models.SpaceShip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpaceShipRepo extends CrudRepository<SpaceShip, Long> {

    @Query("SELECT s FROM SpaceShip s WHERE s.isActive = :isActive")
    List<SpaceShip> findSpaceShipByActive(boolean isActive);

}
