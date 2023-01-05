package ila.project.tournament_manager.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @ManyToMany(mappedBy = "equipes")
    private List<Joueur> joueurs;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Tournoi> tournois;

}
