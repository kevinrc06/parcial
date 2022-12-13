package com.example.primer_parcial.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;
    @Column (length = 50,nullable = false)
    private String nombre;
    @Column (length = 100,nullable = false)
    private String descripcion;

}
