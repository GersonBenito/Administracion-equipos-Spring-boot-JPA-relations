package com.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
//@Table(name = "entrenador") // para especificar un nombre personalizado, por default toma el de la clase
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name") // para tener la nomenclatura de sql snake_case y para Java quedara con camelCase
    private String lastName;
    private String nationality;
    private Integer age;
}
