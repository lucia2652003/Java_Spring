package com.example.app.servicies;

import com.example.app.repositories.ICursoRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class CursoServiceTest {

    //Inyeccion mocks
    @InjectMocks
    ICursoService service;

    //Simulacion mock
    @Mock
     ICursoRepository repository;
}
