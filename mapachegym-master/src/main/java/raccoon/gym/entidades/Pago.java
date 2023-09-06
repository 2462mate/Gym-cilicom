package raccoon.gym.entidades;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "pago")
public class Pago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_pago")
    private int idPago;

    @Column(name = "fecha_pago")
    private String fechaPago;

    @Column(name = "validez")
    private String validez;

    @Column(name = "valor_abonado")
    private double valorAbonado;

    // RELACION (N-1) CON MEMBRESIA
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "membresia")
    private Membresia membresia;

    // RELACION (N-1) CON CLIENTE
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente")
    private Cliente cliente;
}
