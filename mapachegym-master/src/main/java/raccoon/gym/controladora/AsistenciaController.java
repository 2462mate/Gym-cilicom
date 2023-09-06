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
import raccoon.gym.entidades.Asistencia;

import raccoon.gym.servicios.AsistenciaServicios;

@Controller
public class AsistenciaController {

    @GetMapping("/nuevo-asistencia")
    public String mostrarFormularioAsistencia(Model model) {
        Asistencia asistencia = new Asistencia();
        model.addAttribute("asistencia", asistencia);
        return "formulario_asistencia";
    }
    @Autowired
    private AsistenciaServicios asistenciaServicios; // Asegúrate de que tienes el servicio inyectado

    @PostMapping("/guardar-asistencia")
    public String guardarAsistencia(@ModelAttribute("asistencia") @Valid Asistencia asistencia, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Si hay errores de validación, regresa al formulario de creación
            return "formulario_asistencia";
        }

        // Llama al servicio para guardar el asistencia
        asistenciaServicios.save(asistencia);

        // Redirecciona a la página de confirmación o a la lista de asistencias
        return "redirect:/lista-asistencia";
    }

    @GetMapping("/lista-asistencia")
    public String listarAsistencias(Model model) {
        List<Asistencia> listaAsistencias = asistenciaServicios.obtenerTodosLosAsistencias();
        model.addAttribute("listaAsistencias", listaAsistencias);
        return "lista-asistencia";
    }

    @GetMapping("/editar-asistencia/{id}")
    public String editarAsistencia(@PathVariable Long id, Model model) {
        Asistencia asistencia = asistenciaServicios.getById(id);
        model.addAttribute("asistencia", asistencia);
        return "editar-asistencia";
    }

    @PostMapping("/actualizar-asistencia")
    public String actualizarAsistencia(@ModelAttribute("asistencia") Asistencia asistencia) {
        asistenciaServicios.save(asistencia); // Guarda los cambios en la base de datos
        return "redirect:/lista-asistencia";
    }

    @GetMapping("/eliminar-asistencia/{id}")
    public String eliminarAsistencia(@PathVariable Long id) {
        asistenciaServicios.delete(id); // Elimina el asistencia de la base de datos
        return "redirect:/lista-asistencia";
    }
}
