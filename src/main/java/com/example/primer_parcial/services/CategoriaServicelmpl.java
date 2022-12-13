package com.example.primer_parcial.services;

import com.example.primer_parcial.models.Articulo;
import com.example.primer_parcial.models.Categoria;
import com.example.primer_parcial.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicelmpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public ResponseEntity<Categoria> createCategoria(Categoria categoria) {
        try {
            categoriaRepository.save(categoria);
            return new ResponseEntity(categoria, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();

        }
    }

    @Override
    public ResponseEntity<List<Categoria>> allCategorias() {
        List<Categoria> categorias= categoriaRepository.findAll();
        if(categorias.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(categorias,HttpStatus.OK);


    }

    @Override
    public ResponseEntity<Categoria> getCategoriaById(Long id_categoria) {
        Optional<Categoria> categoria= categoriaRepository.findById(id_categoria);

        if (categoria.isPresent()){
            return new ResponseEntity(categoria, HttpStatus.OK);
        }
        return  ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<Categoria>> allCategoriasByName(String nombre) {
        List<Categoria> categorias= categoriaRepository.findAllByNombre(nombre);

        if(categorias.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(categorias,HttpStatus.OK);
    }
}
