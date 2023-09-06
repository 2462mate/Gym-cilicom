package raccoon.gym.repositorios;

import raccoon.gym.entidades.*;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {

    Object findByNombre(String string);

}
