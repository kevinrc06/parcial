package com.example.primer_parcial.services;

import com.example.primer_parcial.models.Articulo;
import com.example.primer_parcial.models.Categoria;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface ArticuloService {
    ResponseEntity<Articulo> createArticulo(Articulo articulo);

    ResponseEntity<Articulo> getArticuloByCodigo(String codigo);

    ResponseEntity<Articulo> editArticulo(String codigo, Articulo articulo);

    ResponseEntity<Articulo> deleteArticuloByCodigo(String codigo);

    ResponseEntity<List<Articulo>> allArticulos();
}