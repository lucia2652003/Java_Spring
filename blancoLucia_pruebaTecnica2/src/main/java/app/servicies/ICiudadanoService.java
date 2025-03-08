package app.servicies;

import app.dtos.CiudadanoDTO;
import app.entities.Ciudadano;

import java.util.List;

public interface ICiudadanoService {

    //Obtener lista de ciudadanos
    List<CiudadanoDTO> mostrarCiudadanos();

    //Añadir ciudadano
    List<CiudadanoDTO> crearCiudadano(CiudadanoDTO ciudadanoDTO);

    //Buscar ciudadano
    CiudadanoDTO buscarCiudadano(Long id);

    //Actualizar Ciudadano
    CiudadanoDTO actualizar(Long id, CiudadanoDTO entidad);

    //Eliminar Ciudadano
    List<CiudadanoDTO> eliminar(Long id);

    CiudadanoDTO conversorCiudadanoToCiudadanoDTO(Ciudadano ciudadano);
    Ciudadano conversorCiudadanoDTOToCiudadano(CiudadanoDTO ciudadanoDTO);
}
