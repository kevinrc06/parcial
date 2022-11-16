package com.example.primer_parcial.controllers;

import com.example.primer_parcial.models.Articulo;
import com.example.primer_parcial.models.Categoria;
import com.example.primer_parcial.repository.CategoriaRepository;
import com.example.primer_parcial.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/categoria")
    public ResponseEntity crearCategoria(@RequestBody Categoria categoria){
        return categoriaService.createCategoria(categoria);

    }
    @GetMapping("/categorias")
    public ResponseEntity listarCategoria() {
        return categoriaService.allCategorias();
    }

}
