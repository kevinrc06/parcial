package com.example.primer_parcial.repository;

import com.example.primer_parcial.models.Articulo;
import com.example.primer_parcial.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    List<Categoria> findAllByNombre(String nombre);


}
