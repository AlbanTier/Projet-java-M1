package ila.project.tournament_manager.repository;

import ila.project.tournament_manager.model.Equipe;
import ila.project.tournament_manager.model.Joueur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface JoueurRepository extends JpaRepository<Joueur, Long> {
    Page<Joueur> findAll(Pageable page);
    Page<Joueur> findAllByPseudo(String pseudo, Pageable page);
    Page<Joueur> findAllByAdresse(String adresse, Pageable page);
    Page<Joueur> findAllByEquipes(Equipe equipename, Pageable page);
    Optional<Joueur> findPlayerById(Long id);
    Joueur save(Joueur joueur);
}
