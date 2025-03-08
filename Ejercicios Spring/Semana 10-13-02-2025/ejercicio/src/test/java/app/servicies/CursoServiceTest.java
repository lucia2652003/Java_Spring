package app.servicies;

import app.dtos.CursoDTO;
import app.entities.Curso;
import app.repositories.ICursoRepository;
import app.services.CursoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CursoServiceTest {

    //Inyeccion mock en servico
    @InjectMocks
    private CursoService servicio;

    //Simulacion mock para repositorio
    @Mock
    private ICursoRepository repository;

    @Test
    @DisplayName("Listado de los curso")
    void listarCurso(){

        List<Curso> todosCurso = List.of(
                new Curso(1L, "Java Avanzado", Curso.TipoCurso.MEDIO, LocalDate.now(),null),
                new Curso(2L, "Java Basico", Curso.TipoCurso.BASICO, LocalDate.now(),null),
                new Curso(3L, "Spring Boot", Curso.TipoCurso.SUPERIOR,LocalDate.now() ,null));


        //LLamar al repositorio
        when(repository.findAll()).thenReturn(todosCurso);

        //Llamar al servicio
        List<CursoDTO> listadoCurso = servicio.mostrarInfo();

        //Verificacion
        assertThat(listadoCurso.get(0).getIdentificadorCurso()).isEqualTo(1L);
        assertThat(listadoCurso.get(0).getNombre()).contains("Java");

    }


}
