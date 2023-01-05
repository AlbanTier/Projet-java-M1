package ila.project.tournament_manager.service.impl;

import ila.project.tournament_manager.model.Tournoi;
import ila.project.tournament_manager.repository.TournoiRepository;
import ila.project.tournament_manager.service.TournoiService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TournoiServiceImpl implements TournoiService {
    public final TournoiRepository tournoiRepository;


    @Override
    public Page<Tournoi> getAllTournois(String name, PageRequest page) {
        if (name == null) {
            return tournoiRepository.findAll(page);
        } else {
            return tournoiRepository.findAllByName(name, page);
        }
    }
    public Page<Tournoi> getTournoisByType(String type, PageRequest page) {
        if (type == null) {
            return tournoiRepository.findAll(page);
        } else {
            return tournoiRepository.findAllByType(type, page);
        }
    }
    public Page<Tournoi> getTournoisByDate(Date date, PageRequest page) {
        if (date == null) {
            return tournoiRepository.findAll(page);
        } else {
            return tournoiRepository.findAllByDate(date, page);
        }
    }
    @Override
    public Optional<Tournoi> getTournoiById(Long id) {
        return this.tournoiRepository.findById(id);
    }
    @Override
    public Tournoi saveTournoi(Tournoi tournoi) {
        return this.tournoiRepository.save(tournoi);
    }
}
