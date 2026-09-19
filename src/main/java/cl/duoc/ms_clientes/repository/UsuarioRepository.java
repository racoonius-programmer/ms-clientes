package cl.duoc.ms_clientes.repository;

import cl.duoc.ms_clientes.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEntraIdOid(String oid);
}
