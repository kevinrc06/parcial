package com.example.primer_parcial.Service;

import com.example.primer_parcial.models.Usuario;
import com.example.primer_parcial.repository.UsuarioRepository;
import com.example.primer_parcial.services.UsuarioService;
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
public class UsuarioServicioText {

    @InjectMocks
    private UsuarioServicelmpl usuarioServicelmpl;

    @Mock
    UsuarioRepository usuarioRepository;

    @Test
    void seDebeEncontrarUnUsuarioPorId(){
        // given
        Usuario usuario = new Usuario();
        usuario.setId(1l);
        usuario.setNombre("kevin");
        usuario.setApellidos("rivera");
        usuario.setDocumento("1003259419");
        usuario.setDireccion("calle 2");
        usuario.setFechaNacimiento(new Date(2000-02-10));
        usuario.setCorreo("kevin@gmail");
        usuario.setPassword("kevin123");





        // when
        when(usuarioRepository.findById(anyLong())).thenReturn(Optional.of(usuario));


         ResponseEntity<Usuario> usuarioRespuesta = usuarioServicelmpl.getUserById(anyLong());

        // then

        Assertions.assertNotNull(usuarioRespuesta);


    }
    @Test
    void seDebeEncontrarUnUsuarioPorNombre(){
        // given
        Usuario usuario = new Usuario();
        usuario.setId(1l);
        usuario.setNombre("kevin");
        usuario.setApellidos("rivera");
        usuario.setDocumento("1003259419");
        usuario.setDireccion("calle 2");
        usuario.setFechaNacimiento(new Date(2000-02-10));
        usuario.setCorreo("kevin@gmail");
        usuario.setPassword("kevin123");





        // when
        when(usuarioRepository.findAllByNombre(anyString()));
        //when(usuarioRepository.findById(anyLong())).thenReturn(Optional.of(usuario));


        //ResponseEntity<Usuario> usuarioRespuesta = usuarioServicelmpl.getUserById(anyLong());
        // ResponseEntity<List<Usuario>> usuarios = usuarioServicelmpl.allUsersByName(anyString());

        // then

        //Assertions.assertNotNull(usuarios);


    }

}
