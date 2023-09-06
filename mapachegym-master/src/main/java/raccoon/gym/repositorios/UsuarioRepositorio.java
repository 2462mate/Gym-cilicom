package raccoon.gym.repositorios;

import org.springframework.data.repository.CrudRepository;
import raccoon.gym.entidades.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    boolean existsByEmail(String email);

}
