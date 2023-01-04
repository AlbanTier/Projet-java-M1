package ila.project.tournament_manager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String pseudo;
    private String adresse;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Equipe> equipes;

    public Joueur(Long id, String pseudo, String adresse) {
        this.id = id;
        this.pseudo = pseudo;
        this.adresse = adresse;
    }
}
