package ila.service;

import ila.project.tournament_manager.model.Equipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface EquipeService {
    Page<Equipe> getAllEquipes(PageRequest page);

    Optional<Equipe> getEquipeById(Long id);

    Equipe saveEquipe(Equipe equipe);
}
