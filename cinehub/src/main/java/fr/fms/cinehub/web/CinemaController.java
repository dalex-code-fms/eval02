package fr.fms.cinehub.web;

import fr.fms.cinehub.dao.CinemaRepository;
import fr.fms.cinehub.entities.Cinema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CinemaController {

    @Autowired
    CinemaRepository cinemaRepository;

    private final Logger logger = LoggerFactory.getLogger(CinemaController.class);

    @GetMapping("/cinema")
    public String cinema(Model model, @RequestParam(name = "id") Long id){

        Optional<Cinema> cinema = cinemaRepository.findById(id);

        if (cinema.isPresent()){

        }

        return "cinema";
    }
}
