package app.servicies;

import app.dtos.CiudadanoDTO;
import app.entities.Ciudadano;
import app.repositories.ICiudadanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class CiudadanoService implements ICiudadanoService{

    @Autowired
    ICiudadanoRepository repositorio;

    @Override
    public List<CiudadanoDTO> mostrarCiudadanos() {
        List<Ciudadano> lista = repositorio.findAll();
        return lista.stream()
                     .map(this::conversorCiudadanoToCiudadanoDTO)
                     .toList();
    }

    @Override
    public List<CiudadanoDTO> crearCiudadano(CiudadanoDTO ciudadanoDTO) {
        repositorio.save(this.conversorCiudadanoDTOToCiudadano(ciudadanoDTO));
        return mostrarCiudadanos();
    }

    @Override
    public CiudadanoDTO buscarCiudadano(Long id) {
        Optional<Ciudadano> existe = repositorio.findById(id);

       return existe.map(this::conversorCiudadanoToCiudadanoDTO)
               .orElse(new CiudadanoDTO(null, null, null));

    }

    @Override
    public CiudadanoDTO actualizar(Long id, CiudadanoDTO entidad) {
        Optional<Ciudadano> existe = repositorio.findById(id);

        if(existe.isPresent()){
            Ciudadano encontrado = existe.get();

            encontrado.setNombre(entidad.getNombre());
            encontrado.setApellido(entidad.getApellido());

            //Actualizado en la BD
            Ciudadano actualizado = repositorio.save(encontrado);
            return this.conversorCiudadanoToCiudadanoDTO(actualizado);
        }

        else throw new RuntimeException("No se podido hacer la actualización, no existe el ID: "+id);
    }

    @Override
    public List<CiudadanoDTO> eliminar(Long id) {
        try {
            repositorio.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("No se ha podido realizar la eliminación");
        }
        return this.mostrarCiudadanos();
    }

    @Override
    public CiudadanoDTO conversorCiudadanoToCiudadanoDTO(Ciudadano ciudadano) {
        return new CiudadanoDTO(ciudadano.getId(), ciudadano.getNombre(), ciudadano.getApellido());
    }

    @Override
    public Ciudadano conversorCiudadanoDTOToCiudadano(CiudadanoDTO ciudadanoDTO) {
        return new Ciudadano(ciudadanoDTO.getIdentificador(), ciudadanoDTO.getNombre(), ciudadanoDTO.getApellido(), null);
    }
}
