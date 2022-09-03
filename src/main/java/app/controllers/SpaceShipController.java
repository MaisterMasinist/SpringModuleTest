package app.controllers;

import app.models.SpaceShip;
import app.models.SpaceShipClass;
import app.services.SpaceShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SpaceShipController {

    private final SpaceShipService spaceShipService;

    public SpaceShipController(SpaceShipService spaceShipService) {
        this.spaceShipService = spaceShipService;
    }

    @GetMapping(value = {"/spaceship"})
    public String saveNewSpaceShip(Model model) {
        model.addAttribute("newShip", new SpaceShip());
        model.addAttribute("shipClasses", SpaceShipClass.values());

        return "spaceship_new";
    }

    @GetMapping("/spaceships")
    public String searchSpaceShip(@RequestParam(required = false, defaultValue = "") String active, Model model) {

        List<SpaceShip> spaceships;

        if(active.equals("true")) {
            spaceships = spaceShipService.getAllSpaceShipWhereIsActive(true);
        } else if(active.equals("false")) {
            spaceships = spaceShipService.getAllSpaceShipWhereIsActive(false);
        } else {
            spaceships = spaceShipService.getAllSpaceShip();
        }

        model.addAttribute("spaceships", spaceships);
        model.addAttribute("active", active);

        return "spaceships";
    }

}
