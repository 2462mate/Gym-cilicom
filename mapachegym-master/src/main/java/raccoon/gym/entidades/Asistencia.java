package raccoon.gym.entidades;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "asistencia")
public class Asistencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_asistencia")
    private int idAsistencia;

    @Column(name = "dia")
    private String dia;

    @Column(name = "hora_inicio")
    private String horaInicio;

    @Column(name = "hora_fin")
    private String horaFin;

    @Column(name = "fecha")
    private String fecha;

    // RELACION (N-1) CON EMPLEADO
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_empleado")
    private Empleado asistenciaEmpleado;

    // RELACION (N-1) CON CLIENTE
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_cliente")
    private Cliente asistenciaCliente;

}
