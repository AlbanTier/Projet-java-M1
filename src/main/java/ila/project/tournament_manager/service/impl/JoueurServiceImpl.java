package ila.project.tournament_manager.service.impl;

import ila.project.tournament_manager.model.Joueur;
import ila.project.tournament_manager.repository.JoueurRepository;
import ila.project.tournament_manager.service.JoueurService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JoueurServiceImpl implements JoueurService {
    public final JoueurRepository joueurRepository;

    @Override
    public Page<Joueur> getAllJoueurs(String name, PageRequest page) {
        if (name == null) {
            return joueurRepository.findAll(page);
        } else {
            return joueurRepository.findAllByPseudo(name, page);
        }
    }

    @Override
    public Optional<Joueur> getJoueurById(Long id) {
        return joueurRepository.findById(id);
    }

    @Override
    public Joueur saveJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }
}

