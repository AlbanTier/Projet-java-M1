package ila.project.tournament_manager.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ila.project.tournament_manager.model.Tournoi;

import java.util.Date;

public interface TournoiRepository extends JpaRepository<Tournoi, Long>{

    Page<Tournoi> findAll(Pageable page);
    Page<Tournoi> findAllByType(String type, Pageable page);
    Page<Tournoi> findAllByDate(Date date, Pageable page);
    Page<Tournoi> findAllByName(String name, Pageable page);
    Tournoi save(Tournoi tournoi);
}
