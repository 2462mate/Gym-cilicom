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
import raccoon.gym.entidades.Empleado;
import raccoon.gym.servicios.EmpleadoServicios;

@Controller
public class EmpleadoControladora {
    @GetMapping("/nuevo-empleado")
    public String mostrarFormularioEmpleado(Model model) {
        Empleado empleado = new Empleado();
        model.addAttribute("empleado", empleado);
        return "formulario_empleado";
    }

    @Autowired
    private EmpleadoServicios empleadoServicios; // Asegúrate de que tienes el servicio inyectado

    @PostMapping("/guardar-empleado")
    public String guardarEmpleado(@ModelAttribute("empleado") @Valid Empleado empleado, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Si hay errores de validación, regresa al formulario de creación
            return "formulario_empleado";
        }

        // Llama al servicio para guardar el empleado
        empleadoServicios.save(empleado);

        // Redirecciona a la página de confirmación o a la lista de empleados
        return "redirect:/lista-empleado";
    }

    @GetMapping("/lista-empleado")
    public String listarEmpleados(Model model) {
        List<Empleado> listaEmpleados = empleadoServicios.obtenerTodosLosEmpleados();
        model.addAttribute("listaEmpleados", listaEmpleados);
        return "lista-empleado";
    }

    @GetMapping("/editar-empleado/{id}")
    public String editarEmpleado(@PathVariable Long id, Model model) {
        Empleado empleado = empleadoServicios.getById(id);
        model.addAttribute("empleado", empleado);
        return "editar-empleado";
    }

    @PostMapping("/actualizar-empleado")
    public String actualizarEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        empleadoServicios.save(empleado); // Guarda los cambios en la base de datos
        return "redirect:/lista-empleado";
    }

    @GetMapping("/eliminar-empleado/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        empleadoServicios.delete(id); // Elimina el empleado de la base de datos
        return "redirect:/lista-empleado";
    }
}
