package ila.project.tournament_manager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import ila.project.tournament_manager.model.Tournoi;

public class TournoiRepository extends JpaRepository<Tournoi>, Long>{

  /*   Page<Tournoi> findAllByTournoiNameStartingWithOrEquipeStartingWith(String name, String equipe, PageRequest page);
    Page<Tournoi> findAllByTournoiNameEndingWithOrEquipeEndingWith(String name, String identity, PageRequest page);
    Page<Tournoi> findAllByTournoiNameOrEquipe(String name, String identity, PageRequest page);
    Page<Tournoi> findAllByTournoiContainsOrEquipeContains(String name, String equipe, PageRequest page);
    
    chercher le bon attribut de tournoi (pas name*/

}
