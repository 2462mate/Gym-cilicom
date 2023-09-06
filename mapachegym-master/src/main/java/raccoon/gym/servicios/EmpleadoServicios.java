package raccoon.gym.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import raccoon.gym.entidades.Empleado;
import raccoon.gym.repositorios.EmpleadoRepositorio;

@Service
public class EmpleadoServicios implements UserDetailsService {

    @Autowired
    EmpleadoRepositorio empleadoRepositorio;
    public Object getAllEmpleados;

    public List<Empleado> getAll() {
        List<Empleado> lista = new ArrayList<Empleado>();
        empleadoRepositorio.findAll().forEach(registro -> lista.add(registro));
        return lista;

    }

    public Empleado getById(Long id) {
        return empleadoRepositorio.findById(id).get();
    }

    public void save(Empleado empleado) {
        empleadoRepositorio.save(empleado);
    }

    public void delete(Long id) {
        empleadoRepositorio.deleteById(id);
    }

    public void guardarEmpleado(@Valid Empleado empleado) {
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Empleado em = empleadoRepositorio.findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException("[!] El usuario no ha sido encontrado. Usuario: " + email));
        return User.builder()
                .username(em.getEmail())
                .password(em.getContrasenia())
                .authorities(em.getTipoEmpleado())
                .build();
    }

    public List<Empleado> obtenerTodosLosEmpleados() {
        List<Empleado> listaEmpleados = new ArrayList<Empleado>();
        empleadoRepositorio.findAll().forEach(registro -> listaEmpleados.add(registro));
        return listaEmpleados;
    }

}
