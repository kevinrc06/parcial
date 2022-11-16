package com.example.primer_parcial.controllers;

import com.example.primer_parcial.models.Articulo;
import com.example.primer_parcial.repository.ArticuloRepository;
import com.example.primer_parcial.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticuloController {
    @Autowired
    private ArticuloRepository articuloRepository;
    @Autowired
    private ArticuloService articuloService;

    @PostMapping("/articulo")
    public ResponseEntity crearArticulo(@RequestBody Articulo articulo){
        return articuloService.createArticulo(articulo);
    }
    @GetMapping("/articulo/{codigo}")
    public ResponseEntity listaPorCodigo(@PathVariable String codigo){
        return articuloService.getArticuloByCodigo(codigo);
    }

    @PutMapping("/articulo/{codigo}")
    public ResponseEntity modificarArticulo(@PathVariable String codigo, @RequestBody Articulo articulo) {
        return articuloService.editArticulo(codigo,articulo);

    }

    @DeleteMapping("/articulo/{codigo}")
    public ResponseEntity eliminarArticulo(@PathVariable String codigo){
        return articuloService.deleteArticuloByCodigo(codigo);
    }
    @GetMapping("/articulos")
    public ResponseEntity listarArticulo(){
        return articuloService.allArticulos();

    }


}
