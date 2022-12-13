package com.example.primer_parcial.services;

import com.example.primer_parcial.models.Articulo;
import com.example.primer_parcial.models.Categoria;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface CategoriaService {
    ResponseEntity<Categoria> createCategoria(Categoria categoria);

    ResponseEntity<List<Categoria>> allCategorias();

    ResponseEntity<Categoria> getCategoriaById(Long id_categoria);

    ResponseEntity<List<Categoria>> allCategoriasByName(String nombre);
}
