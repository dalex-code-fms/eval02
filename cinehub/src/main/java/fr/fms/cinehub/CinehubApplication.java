package fr.fms.cinehub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinehubApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CinehubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//generateData();
	}

	private void generateData(){

	}

}
