package com.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "competition") // ejemplo
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", columnDefinition = "VARCHAR(150)") // ejemplo de columnDefinition
    private String name;
    /**
     * La anotacion @Column tiene diferentes propiedades ademas del name
     * La propiedad length indica el tamaño del campo
     * La propiedad nullable indica que no puede ser null el campo
     * La propiedad unique indica que este campo sera unico en la base de datos, ejemplo un correo o username
     */
    @Column(name = "quantity_price", length = 10, nullable = false, unique = true)
    private Integer quantityPrice;
    @Column(name = "start_date", columnDefinition = "DATE") // columnDefinition especificamos el tipo de dato que tener en la tabla
    private LocalDate startDate;
    @Column(name = "end_date", columnDefinition = "DATE")
    private LocalDate endDate;
    /*@ManyToMany(targetEntity = Club.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_club")
    private List<Club> clubs;*/
}
