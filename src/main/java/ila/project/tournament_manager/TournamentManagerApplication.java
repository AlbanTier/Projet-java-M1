package ila.project.tournament_manager;

import ila.api.TournoiController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "ila")
public class TournamentManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TournamentManagerApplication.class, args);
	}

}
