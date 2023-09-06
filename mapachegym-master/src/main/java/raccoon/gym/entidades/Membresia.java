package raccoon.gym.entidades;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "membresia")
public class Membresia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_membresia")
    private int idMembresia;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo_membresia")
    private String tipoMembresia;

    @Column(name = "precio")
    private double precio;

    // RELACION (1-N) CON CLIENTE
    @OneToMany(mappedBy = "membresia")
    private List<Cliente> cliente;

    // RELACION (1-n) CON PAGOS
    @OneToMany(mappedBy = "membresia")
    private List<Pago> pago;
}