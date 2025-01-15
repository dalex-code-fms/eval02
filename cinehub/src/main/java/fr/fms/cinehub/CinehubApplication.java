package fr.fms.cinehub;

import fr.fms.cinehub.dao.CinemaRepository;
import fr.fms.cinehub.dao.CityRepository;
import fr.fms.cinehub.dao.MovieRepository;
import fr.fms.cinehub.dao.SeanceRepository;
import fr.fms.cinehub.entities.Cinema;
import fr.fms.cinehub.entities.City;
import fr.fms.cinehub.entities.Movie;
import fr.fms.cinehub.entities.Seance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class CinehubApplication implements CommandLineRunner {

	@Autowired
	private CinemaRepository cinemaRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private SeanceRepository seanceRepository;

	@Autowired
	private CityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(CinehubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//generateData();

	}

	private void generateData(){
		// Villes
		City paris = new City("Paris", "Ile-de-France", "France");
		City lyon = new City("Lyon", "Rhône", "France");
		City marseille = new City("Marseille", "Bouches-du-Rhône", "France");

		cityRepository.saveAll(Arrays.asList(paris, lyon, marseille));

//		// Cinémas
		Cinema cinemaParis = new Cinema("Cinema Paris", "1454 avenu de la liberté, Paris", paris);
		Cinema cinepolisParis = new Cinema("Cinépolis", "123 rue de Paris, Paris", paris);
		Cinema ugcLyon = new Cinema("UGC", "456 avenue de Lyon, Lyon", lyon);
		Cinema patheMarseille = new Cinema("Pathé", "789 boulevard de Marseille, Marseille", marseille);

		cinemaRepository.saveAll(Arrays.asList(cinemaParis, cinepolisParis, ugcLyon,patheMarseille));
//
//		// Films
		Movie inception = new Movie("Inception");
		Movie theDarkKnight = new Movie("The Dark Knight");
		Movie interstellar = new Movie("Interstellar");
		Movie titanic = new Movie("Titanic");
//
		movieRepository.saveAll(Arrays.asList(inception, theDarkKnight, interstellar, titanic));
//
//		// Liaisons Cinéma-Film
		cinepolisParis.setMovies(Arrays.asList(inception, theDarkKnight));
		ugcLyon.setMovies(Arrays.asList(theDarkKnight, interstellar));
		patheMarseille.setMovies(Arrays.asList(interstellar, titanic));
		cinemaParis.setMovies(Arrays.asList(inception, interstellar));

		cinemaRepository.saveAll(Arrays.asList(cinepolisParis, ugcLyon, patheMarseille, cinemaParis));

		// Séances

		Seance seance1 = new Seance(LocalDateTime.of(2025, 1, 15, 14, 0), inception, cinepolisParis);
		Seance seance2 = new Seance(LocalDateTime.of(2025, 1, 15, 16, 30), theDarkKnight, cinepolisParis);
		Seance seance3 = new Seance(LocalDateTime.of(2025, 1, 16, 18, 0), interstellar, ugcLyon);
		Seance seance4 = new Seance(LocalDateTime.of(2025, 1, 17, 20, 0), titanic, patheMarseille);
		Seance seance5 = new Seance(LocalDateTime.of(2025, 1, 15, 14, 0), inception, cinemaParis);

		seanceRepository.saveAll(Arrays.asList(seance1, seance2, seance3, seance4, seance5));
	}
}
