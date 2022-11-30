package com.example.primer_parcial.Service;

import com.example.primer_parcial.models.Usuario;
import com.example.primer_parcial.repository.UsuarioRepository;
import com.example.primer_parcial.services.UsuarioServicelmpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
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
    void whenNoEncuentraUnUsuarioPorId(){
        Usuario usuario = null;


        //given




        //when
        when(usuarioRepository.findById(anyLong())).thenReturn(Optional.ofNullable(usuario));

        //then
        Usuario usuarioOptional = usuarioServicelmpl.getUserById(anyLong()).getBody();
        Assertions.assertEquals(null, usuarioOptional);

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
        when(usuarioRepository.findAllByNombre("kevin")).thenReturn(List.of(usuario));
        //when(usuarioRepository.findById(anyLong())).thenReturn(Optional.of(usuario));


        ResponseEntity<List<Usuario>> usuarioRespuesta = usuarioServicelmpl.allUsersByName("kevin");
        // ResponseEntity<List<Usuario>> usuarios = usuarioServicelmpl.allUsersByName(anyString());

        // then

        Assertions.assertNotNull(usuarioRespuesta);


    }
    @Test
    void whenNoEncuentraUnUsuarioPorNombre(){
        Usuario usuario = null;


        //given




        //when
        when(usuarioRepository.findAllByNombre(anyString())).thenReturn(Collections.emptyList());

        //then
        List<Usuario> usuarioOptional = usuarioServicelmpl.allUsersByName(anyString()).getBody();
        Assertions.assertEquals(null, usuarioOptional);

    }


    @Test
    void seDebeEncontrarUnUsuarioPorApellido(){
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
        when(usuarioRepository.findAllByApellidos("rivera")).thenReturn(List.of((usuario)));
        //when(usuarioRepository.findAllByNombre("kevin")).thenReturn(List.of(usuario));
        //when(usuarioRepository.findById(anyLong())).thenReturn(Optional.of(usuario));

        ResponseEntity<List<Usuario>> usuarioRespuesta = usuarioServicelmpl.allUsersByLastName("rivera");
        //ResponseEntity<List<Usuario>> usuarioRespuesta = usuarioServicelmpl.allUsersByName("kevin");
        // ResponseEntity<List<Usuario>> usuarios = usuarioServicelmpl.allUsersByName(anyString());

        // then

        Assertions.assertNotNull(usuarioRespuesta);


    }

    @Test
    void whenNoEncuentraUnUsuarioPorApellido(){
        Usuario usuario = null;


        //given




        //when
        when(usuarioRepository.findAllByApellidos(anyString())).thenReturn(Collections.emptyList());

        //then
        List<Usuario> usuarioOptional = usuarioServicelmpl.allUsersByLastName(anyString()).getBody();
        Assertions.assertEquals(null, usuarioOptional);

    }


    @Test
    void seDebeEncontrarUnUsuarioPorNombreYApellido(){
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
        when(usuarioRepository.findAllByNombreAndApellidos("kevin","rivera")).thenReturn(List.of(usuario));
        //when(usuarioRepository.findAllByNombre("kevin")).thenReturn(List.of(usuario));
        //when(usuarioRepository.findById(anyLong())).thenReturn(Optional.of(usuario));

        ResponseEntity<List<Usuario>> usuarioRespuesta = usuarioServicelmpl.allUsersByNameAndLastName("kevin","rivera");
        //ResponseEntity<List<Usuario>> usuarioRespuesta = usuarioServicelmpl.allUsersByName("kevin");
        // ResponseEntity<List<Usuario>> usuarios = usuarioServicelmpl.allUsersByName(anyString());

        // then

        Assertions.assertNotNull(usuarioRespuesta);


    }
    @Test
    void whenNoEncuentraUnUsuarioPorNombreYapellido(){
        Usuario usuario = null;


        //given




        //when
        when(usuarioRepository.findAllByNombreAndApellidos(anyString(),anyString())).thenReturn(Collections.emptyList());

        //then
        List<Usuario> usuarioOptional = usuarioServicelmpl.allUsersByNameAndLastName(anyString(),anyString()).getBody();
        Assertions.assertEquals(null, usuarioOptional);

    }

    @Test
    void seDebeListarLosUsuarios() {
        //Given
        Usuario usuario = new Usuario();
        usuario.setId(1l);
        usuario.setNombre("kevin");
        usuario.setApellidos("rivera");
        usuario.setDocumento("1003259419");
        usuario.setDireccion("calle 2");
        usuario.setFechaNacimiento(new Date(2000-02-10));
        usuario.setCorreo("kevin@gmail");
        usuario.setPassword("kevin123");

        //when

        when(usuarioRepository.findAll()).thenReturn(List.of(usuario));




        ResponseEntity<List<Usuario>> usuarioP= usuarioServicelmpl.allUsers();

        //then
        Assertions.assertNotNull(usuarioP);
    }

    @Test
    void whenNoEncuentraNingunUsuario() {
        Usuario usuario = null;

        //When
        when(usuarioRepository.findAll()).thenReturn(Collections.emptyList());

        List<Usuario> usuarioP = usuarioServicelmpl.allUsers().getBody();


        //Then
        Assertions.assertEquals(null, usuarioP);

    }

    @Test
    void seDebeActualizarUnUsuario() {
        // Given
        Usuario usuario = new Usuario();
        usuario.setId(1l);
        usuario.setNombre("kevin");
        usuario.setApellidos("rivera");
        usuario.setDocumento("1003259419");
        usuario.setDireccion("calle 2");
        usuario.setFechaNacimiento(new Date(2000-02-10));
        usuario.setCorreo("kevin@gmail");
        usuario.setPassword("kevin123");

        Usuario usuarioActualizado = new Usuario();

        usuarioActualizado.setId(1l);
        usuarioActualizado.setNombre("julian");
        usuarioActualizado.setApellidos("contreras");
        usuarioActualizado.setDocumento("1003259419");
        usuarioActualizado.setDireccion("calle 3");
        usuarioActualizado.setFechaNacimiento(new Date(2001-02-10));
        usuarioActualizado.setCorreo("kevin2@gmail");
        usuarioActualizado.setPassword("kevin1234");

        given(usuarioRepository.findById(usuario.getId())).willReturn(Optional.of(usuario));


        given(usuarioRepository.save(usuarioActualizado)).willReturn(usuarioActualizado);



        ResponseEntity<Usuario> userSave = usuarioServicelmpl.editUser(usuario.getId(), usuarioActualizado);

        //Then
        Assertions.assertNotNull(userSave);
    }


}
