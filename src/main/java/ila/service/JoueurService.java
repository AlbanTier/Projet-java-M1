package ila.service;

import ila.project.tournament_manager.model.Joueur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface JoueurService {
    Page<Joueur> getAllJoueurs(String name, PageRequest page);

    Optional<Joueur> getJoueurById(Long id);

    Joueur saveJoueur(Joueur joueur);
}
