package raccoon.gym.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import raccoon.gym.entidades.Cliente;
import raccoon.gym.entidades.Empleado;
import raccoon.gym.repositorios.ClienteRepositorio;

@Service
public class ClienteServicios {

    @Autowired
    ClienteRepositorio clienteRepositorio;

    public List<Cliente> getAll() {
        List<Cliente> lista = new ArrayList<Cliente>();
        clienteRepositorio.findAll().forEach(registro -> lista.add(registro));
        return lista;

    }

    public Cliente getById(Long id) {
        return clienteRepositorio.findById(id).get();
    }

    public void save(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }
    public void guardarCliente(@Valid Cliente cliente) {
    }

    public void delete(Long id) {
        clienteRepositorio.deleteById(id);
    }
    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        clienteRepositorio.findAll().forEach(registro -> listaClientes.add(registro));
        return listaClientes;
    }
}
