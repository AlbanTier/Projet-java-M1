INSERT INTO etat(id, nom)
VALUES   (1,'En cours'),
         (2,'Plannifié'),
         (3,'Terminé');

INSERT INTO tournoi (id, date, description, name,type,etat_id)
VALUES (1, '2023-01-24', 'Valorant Open Tour France', 'Le VALORANT OPEN TOUR FRANCE est le circuit compétitif français amateur sur VALORANT','payant',2),
       (2, '2012-09-20', 'Ultr_Team-League of Legends', 'Tournoi LOL','payant',3),
       (3, '2018-09-24', 'Overwatch Ligue', 'Tournoi Oberwatch US','payant',2),
       (4, '2022-12-24', 'DOJO', 'Tournoi Tekken','payant',1),
       (5, '2022-09-05', 'AWC', 'Tournoi World of Warcraft','payant',1),
       (6, '2023-01-13', 'MINISH 4.7', 'Tournoi Smash  Bros Ultimate','payant',1),
       (7, '2018-09-24', 'Nett Killing', 'Tournoi Animal Crossing','payant',1);




-- select * from tournoi

