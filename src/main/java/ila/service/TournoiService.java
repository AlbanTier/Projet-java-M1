package ila.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ila.project.tournament_manager.model.Tournoi;

public interface TournoiService {
    Page<Tournoi> getAllTournois(String name, PageRequest page);

    Optional<Tournoi> getTournoiById(Long id);

    Tournoi saveTournoi(Tournoi superhero);
}
