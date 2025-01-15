package fr.fms.cinehub.web;

import fr.fms.cinehub.dao.CinemaRepository;
import fr.fms.cinehub.dao.CityRepository;
import fr.fms.cinehub.entities.Cinema;
import fr.fms.cinehub.entities.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String home(
            Model model,
            @RequestParam(name = "keyword", defaultValue = "") String keyword){

        try {
            if (keyword.matches("[a-zA-Z ]+")) {
                List<Cinema> listOfCinemasByCountry = cinemaRepository.findAllByCityName(keyword);
                List<Cinema> listOfCinemasByName =
                        cinemaRepository.findAllByNameContaining(keyword);
                model.addAttribute("listOfCinemasByCountry", listOfCinemasByCountry);
                model.addAttribute("listOfCinemasByName", listOfCinemasByName);
                model.addAttribute("keyword", keyword);
            } else {
                model.addAttribute("error", "Veuillez entrer un nom de ville ou de cinema correct.");
            }
        } catch (Exception e) {
            logger.error("[HOME CONTROLLER : / ] : {} ", e.getMessage());
        }
        return "home";
    }

}
