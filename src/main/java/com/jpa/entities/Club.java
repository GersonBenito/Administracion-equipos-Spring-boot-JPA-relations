package com.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//@Data // en este caso no usaremos el combo de data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    /**
     * Relacion de 1 a 1 en JPA, debe de ir a donde va quedar la clave foranea
     * Cascade es el compotamiento en cascada, cuando se ingrese un Club se va ingresar un Coach
     * y cuando se elimine un club el coach no se va a eliminar
     */
    @OneToOne(targetEntity = Coach.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_coach") // personalizar el id de la relacion
    private Coach coach;

    /**
     * Relacion de uno a muchos en JPA
     * Fetch de tipo LAZY nos sirve para obtener la lista de jugadores cuando sea requerido, el EAGER trae la
     * lista completo de jugadores en el momento que se instancia la clase.
     * El mappedBy nos sirve para indicarle a JPA con cual atributo de la otra clase se va a mappear
     */
    @OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY, mappedBy = "club") // relacion de 1 a n
    private List<Player> players;
    @ManyToOne(targetEntity = FootballAssociation.class)
    @JoinColumn(name = "id_association")
    private FootballAssociation footballAssociation;
    @ManyToMany(targetEntity = Competition.class, fetch = FetchType.LAZY) // relacion de n a n

    /**
     * La anotacion @JoinTable permite personalizar la tabla intermedio que se crea con una relacion de muchos a muchos
     * La propiedad inverseJoinColumns nos permite tomar la llave foranea inverso de la tabla con la que se esta haciendo la relacion
     */
    @JoinTable(name = "club_competition", joinColumns = @JoinColumn(name = "id_club"), inverseJoinColumns = @JoinColumn(name = "id_competition"))
    private List<Competition> footballCompetitions;
}
