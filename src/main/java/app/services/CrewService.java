package app.services;

import app.models.Crew;
import app.repositories.CrewRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrewService {

    private final CrewRepo crewRepo;

    public CrewService(CrewRepo crewRepo) {
        this.crewRepo = crewRepo;
    }

    public List<Crew> getAllCrewMembers() {
        return (List<Crew>) crewRepo.findAll();
    }
}
