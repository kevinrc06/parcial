package com.example.primer_parcial.Service;

import com.example.primer_parcial.models.Articulo;
import com.example.primer_parcial.models.Categoria;
import com.example.primer_parcial.models.Usuario;
import com.example.primer_parcial.repository.ArticuloRepository;
import com.example.primer_parcial.repository.CategoriaRepository;
import com.example.primer_parcial.repository.UsuarioRepository;
import com.example.primer_parcial.services.ArticuloServicelmpl;
import com.example.primer_parcial.services.UsuarioServicelmpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ArticuloServicioText {

    @InjectMocks
    private ArticuloServicelmpl articuloServicelmpl;

    @Mock
    ArticuloRepository articuloRepository;
    @Mock
    CategoriaRepository categoriaRepository;

    @Test
    void seDebeEncontrarUnArticuloPorCodigo(){
        // given
        Articulo articulo= new Articulo();
        Categoria categoria= new Categoria();
        categoria.setId(2l);
        categoria.setNombre("peppe");
        categoria.setDescripcion("jjj");
        articulo.setId(1l);
        articulo.setCodigo("100");
        articulo.setNombre("kevin");
        articulo.setDescripcion("prubea");
        articulo.setFecha_registro(new Date(2000-02-10));
        articulo.setStock(10);
        articulo.setCategoria(categoria);
        articulo.setPrecio_compra(new Float(20.000));
        articulo.setPrecio_venta(new Float(20.000));



        // when
        when(articuloRepository.findByCodigo(anyString())).thenReturn(Optional.of(articulo));


        ResponseEntity<Articulo> articuloRespuesta = articuloServicelmpl.getArticuloByCodigo(anyString());

        // then
        Assertions.assertNotNull(articuloRespuesta);


    }

    @Test
    void whenNoEncuentraUnArticuloPorCodigo(){
         Articulo articulo = null;


        //given




        //when

        when(articuloRepository.findByCodigo(anyString())).thenReturn(Optional.ofNullable(articulo));

        //then
        //Usuario usuarioOptional = usuarioServicelmpl.getUserById(anyLong()).getBody();
        Articulo articuloOptional = articuloServicelmpl.getArticuloByCodigo(anyString()).getBody();

        Assertions.assertEquals(null, articuloOptional);


    }
}
