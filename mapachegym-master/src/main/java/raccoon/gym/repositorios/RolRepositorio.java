package raccoon.gym.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import raccoon.gym.entidades.Rol;

public interface RolRepositorio extends CrudRepository<Rol, Long> {

    Optional<Rol> findByNombre(String string);

}
