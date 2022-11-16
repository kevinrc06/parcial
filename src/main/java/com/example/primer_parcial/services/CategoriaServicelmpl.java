package com.example.primer_parcial.services;

import com.example.primer_parcial.models.Categoria;
import com.example.primer_parcial.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
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
}
