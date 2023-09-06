package raccoon.gym.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
@jakarta.persistence.Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 8)
    private String dni;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;
}