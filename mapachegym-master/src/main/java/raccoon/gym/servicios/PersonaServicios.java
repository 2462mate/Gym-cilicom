package raccoon.gym.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raccoon.gym.entidades.Persona;
import raccoon.gym.repositorios.PersonaRepositorio;

@Service
public class PersonaServicios {

    @Autowired
    PersonaRepositorio personaRepositorio;

    public List<Persona> getAll() {
        List<Persona> lista = new ArrayList<Persona>();
        personaRepositorio.findAll().forEach(registro -> lista.add(registro));
        return lista;

    }

    public Persona getById(Long id) {
        return personaRepositorio.findById(id).get();
    }

    public void save(Persona persona) {
        personaRepositorio.save(persona);
    }

    public void delete(Long id) {
        personaRepositorio.deleteById(id);
    }
}
