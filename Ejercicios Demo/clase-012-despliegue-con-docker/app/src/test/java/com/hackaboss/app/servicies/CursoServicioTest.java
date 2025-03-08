package com.hackaboss.app.servicies;

import com.hackaboss.app.dtos.CursoDTO;
import com.hackaboss.app.entities.Curso;
import com.hackaboss.app.repositories.CursoRepositorioInterfaz;
import com.hackaboss.app.services.CursoServicio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CursoServicioTest {

    //Crear un mock al repositorio
    @Mock
    private CursoRepositorioInterfaz reposiroty;

    //inyectarlo al servicio
    @InjectMocks
    CursoServicio service;

    //los test unitarios
    @Test
    @DisplayName("Encontrar lista de cursos")
    void encontrarTodosLosCursos(){

        //enviar el mock simulado
        List<Curso> cursosMock = List.of(
                new Curso(1L, "Java Basico", "Teorico", LocalDate.now(),new ArrayList<>()),
                new Curso(2L, "Java Avanzado", "Practico", LocalDate.now(),new ArrayList<>())
        );

        //when yo llame a mi metodo del repo devualve el mock creado
        when(reposiroty.findAll()).thenReturn(cursosMock);

        //llamar el metodo del service
        List<CursoDTO> cursosDelServices = service.buscarTodos();

        //los assserts
        assertThat(cursosDelServices.get(0).getIdentificador()).isEqualTo(1L);
        assertThat(cursosDelServices.get(0).getNombre()).isEqualTo("Java Basico");
        assertThat(cursosDelServices.get(0).getTipoCurso()).isEqualTo("Teorico");
        assertThat(cursosDelServices.get(0).getFechaFinalizacion()).isEqualTo("2025-02-17");
        assertThat(cursosDelServices.get(0).getTemas().size()).isEqualTo(0);
    }

    @Test
    @DisplayName("Encontrar un curso por ID")
    void buscarPorCurso(){
        //enviar el mock simulado
        Long idBuscado = 1L;
        Curso cursoParaValidar = new Curso(idBuscado, "Nuevo Curso", "Teorico", LocalDate.now(), new ArrayList<>());

        //when yo llame a mi metodo del repo devualve el mock creado
        when(reposiroty.findById(idBuscado)).thenReturn(Optional.of(cursoParaValidar));

        //llamar el metodo del service
        CursoDTO productoObtenido = service.buscarPorCurso(idBuscado);

        //recuperar entidad
         Curso cursoEncontrado = service.convertirHaciaEntidad(productoObtenido);

        //los assserts
        assertThat(cursoEncontrado.getIdCurso()).isEqualTo(1L);
        assertThat(cursoEncontrado.getNombre()).isEqualTo("Nuevo Curso");
        assertThat(cursoEncontrado.getTipoCurso()).isEqualTo("Teorico");
        assertThat(cursoEncontrado.getFechaFinalizacion()).isEqualTo("2025-02-17");
        assertThat(cursoEncontrado.getTemas().size()).isEqualTo(0L);
    }
}
