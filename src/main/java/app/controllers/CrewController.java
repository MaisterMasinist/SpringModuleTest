package app.controllers;

import app.models.Crew;
import app.services.CrewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CrewController {

    private final CrewService crewService;

    public CrewController(CrewService crewService) {
        this.crewService = crewService;
    }

    @GetMapping("/crewmembers")
    public String getCrewMembers(@RequestParam(required = false, defaultValue = "") String search, Model model) {

        List<Crew> crewList;

        if(!search.isBlank()) {
            crewList = crewService.getCrewMembersContaining(search);
        } else {
            crewList = crewService.getAllCrewMembers();
        }

        model.addAttribute("crew", crewList);

        return "crewmembers";
    }


}
