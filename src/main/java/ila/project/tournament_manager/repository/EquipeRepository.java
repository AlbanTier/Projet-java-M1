package ila.project.tournament_manager.repository;

import ila.project.tournament_manager.model.Equipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    Page<Equipe> findAll(Pageable page);
    Page<Equipe> findAllByTeamName(String name, Pageable page);
}
