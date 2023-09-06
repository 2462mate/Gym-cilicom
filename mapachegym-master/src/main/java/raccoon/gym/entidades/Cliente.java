package raccoon.gym.entidades;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente extends Persona implements Serializable {

    @Column(name = "dias_disponibles")
    private int diasDisponibles;

    @Column(name = "status")
    private String status;

    // RELACION (N-1) CON MEMBRESIA
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_membresia")
    private Membresia membresia;

    // RELACION (1-N) CON ASISTENCIA
    @OneToMany(mappedBy = "asistenciaCliente")
    private List<Asistencia> asistencia;

    // RELACION (1-N) CON PAGOS
    @OneToMany(mappedBy = "cliente")
    private List<Pago> pago;

    public void setEmail(Object email) {
    }

    public void setPassword(Object encode) {
    }
}
