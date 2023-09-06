package raccoon.gym.repositorios;

import raccoon.gym.entidades.*;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface EmpleadoRepositorio extends CrudRepository<Empleado, Long> {

    void save(Persona persona);
    Optional<Empleado> findByEmail(String email);

}
