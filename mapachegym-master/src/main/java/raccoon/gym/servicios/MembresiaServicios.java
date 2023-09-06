package raccoon.gym.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

import raccoon.gym.entidades.Membresia;
import raccoon.gym.repositorios.MembresiaRepositorio;

@Service
public class MembresiaServicios {

    @Autowired
    MembresiaRepositorio membresiaRepositorio;

    public List<Membresia> getAll() {
        List<Membresia> lista = new ArrayList<Membresia>();
        membresiaRepositorio.findAll().forEach(registro -> lista.add(registro));
        return lista;

    }

    public Membresia getById(Long id) {
        return membresiaRepositorio.findById(id).get();
    }

    public void save(Membresia membresia) {
        membresiaRepositorio.save(membresia);
    }
       public void guardarMembresia(@Valid Membresia membresia) {
    }

    public void delete(Long id) {
        membresiaRepositorio.deleteById(id);
    }


    public List<Membresia> obtenerTodosLasMembresias() {
        List<Membresia> listaMembresia = new ArrayList<Membresia>();
        membresiaRepositorio.findAll().forEach(registro -> listaMembresia.add(registro));
        return listaMembresia;
    }
}
