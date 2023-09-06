package raccoon.gym.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raccoon.gym.entidades.Rol;
import raccoon.gym.repositorios.RolRepositorio;

@Service
public class RolServicios {

    @Autowired
    RolRepositorio rolRepositorio;

    public List<Rol> getAll() {
        List<Rol> lista = new ArrayList<Rol>();
        rolRepositorio.findAll().forEach(registro -> lista.add(registro));
        return lista;
    }

    public Rol getById(Long id) {
        return rolRepositorio.findById(id).get();
    }

    public void save(Rol rol) {
        rolRepositorio.save(rol);
    }

    public void delete(Long id) {
        rolRepositorio.deleteById(id);
    }

}