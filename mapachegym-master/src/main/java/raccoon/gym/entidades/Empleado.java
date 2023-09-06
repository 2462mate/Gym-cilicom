package raccoon.gym.entidades;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado extends Persona implements Serializable {
     // Administrador, Usuario, y Instructor
     @Column(name = "tipo_empleado")
     @Pattern(regexp = "^(Administrador|Usuario|Instructor)$", message = "usuario no valido")
     private String tipoEmpleado;

     @Column(name = "legajo")
     private String legajo;

     @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9.-]+$")
     @Column(name = "email")
     private String email;

     @Column(name = "contrasenia")
     private String contrasenia;

     // RELACION BIDERECCIONAL (1-N) CON ASISTENCIA
     @OneToMany(mappedBy = "asistenciaEmpleado")
     private List<Asistencia> asistencia;
}
