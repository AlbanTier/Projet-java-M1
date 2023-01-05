package ila.project.tournament_manager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tournoi")
@ToString
public class Tournoi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private String type;
    private String description;
    private String name;
    @ManyToOne
    private Etat etat;
    @ManyToMany(mappedBy = "tournois")
    private List<Equipe> equipes;

}
