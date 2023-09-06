package raccoon.gym.controladora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InControladora {
    @GetMapping("/index")
    public String mostrarPagina(Model model) {
      model.addAttribute("mensaje", "¡Hola desde el controlador!");
      return "index"; // nombre de la plantilla Thymeleaf sin extensión
    }
}
