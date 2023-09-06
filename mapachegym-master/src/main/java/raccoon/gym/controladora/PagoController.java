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
import raccoon.gym.entidades.Pago;
import raccoon.gym.servicios.PagoServicios;

@Controller
public class PagoController {

    @GetMapping("/nuevo-pago")
    public String mostrarFormularioPago(Model model) {
        Pago pago = new Pago();
        model.addAttribute("pago", pago);
        return "formulario_pago";
    }
    @Autowired
    private PagoServicios pagoServicios; // Asegúrate de que tienes el servicio inyectado

    @PostMapping("/guardar-pago")
    public String guardarPago(@ModelAttribute("pago") @Valid Pago pago, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Si hay errores de validación, regresa al formulario de creación
            return "formulario_pago";
        }

        // Llama al servicio para guardar el pago
        pagoServicios.save(pago);

        // Redirecciona a la página de confirmación o a la lista de pagos
        return "redirect:/lista-pago";
    }

    @GetMapping("/lista-pago")
    public String listarPagos(Model model) {
        List<Pago> listaPagos = pagoServicios.obtenerTodosLosPagos();
        model.addAttribute("listaPagos", listaPagos);
        return "lista-pago";
    }

    @GetMapping("/editar-pago/{id}")
    public String editarPago(@PathVariable Long id, Model model) {
        Pago pago = pagoServicios.getById(id);
        model.addAttribute("pago", pago);
        return "editar-pago";
    }

    @PostMapping("/actualizar-pago")
    public String actualizarPago(@ModelAttribute("pago") Pago pago) {
        pagoServicios.save(pago); // Guarda los cambios en la base de datos
        return "redirect:/lista-pago";
    }

    @GetMapping("/eliminar-pago/{id}")
    public String eliminarPago(@PathVariable Long id) {
        pagoServicios.delete(id); // Elimina el pago de la base de datos
        return "redirect:/lista-pago";
    }
}
