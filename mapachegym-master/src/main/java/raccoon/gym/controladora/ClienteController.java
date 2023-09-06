package raccoon.gym.controladora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import raccoon.gym.entidades.Cliente;

import raccoon.gym.servicios.ClienteServicios;

@Controller
public class ClienteController {

    @GetMapping("/nuevo-cliente")
    public String mostrarFormularioCliente(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "formulario_cliente";
    }

    @Autowired
    private ClienteServicios clienteServicios; // Asegúrate de que tienes el servicio inyectado

    @PostMapping("/guardar-cliente")
    public String guardarCliente(@ModelAttribute("cliente") @Valid Cliente cliente, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Si hay errores de validación, regresa al formulario de creación
            return "formulario_cliente";
        }

        // Llama al servicio para guardar el cliente
        clienteServicios.save(cliente);

        // Redirecciona a la página de confirmación o a la lista de clientes
        return "redirect:/lista-cliente";
    }

    @GetMapping("/lista-cliente")
    public String listarClientes(Model model) {
        List<Cliente> listaClientes = clienteServicios.obtenerTodosLosClientes();
        model.addAttribute("listaClientes", listaClientes);
        return "lista-cliente";
    }

    @GetMapping("/editar-cliente/{id}")
    public String editarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteServicios.getById(id);
        model.addAttribute("cliente", cliente);
        return "editar-cliente";
    }

    @PostMapping("/actualizar-cliente")
    public String actualizarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteServicios.save(cliente); // Guarda los cambios en la base de datos
        return "redirect:/lista-cliente";
    }

    @GetMapping("/eliminar-cliente/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteServicios.delete(id); // Elimina el cliente de la base de datos
        return "redirect:/lista-cliente";
    }
}
