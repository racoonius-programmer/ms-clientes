package cl.duoc.ms_clientes.service;

import cl.duoc.ms_clientes.dto.UsuarioRequest;
import cl.duoc.ms_clientes.entity.RolUsuario;
import cl.duoc.ms_clientes.entity.Usuario;
import cl.duoc.ms_clientes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final String adminOid;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          @Value("${app.admin-oid:32a7ca6e-5a16-4dd0-9cc5-7ad24350eca3}") String adminOid) {
        this.usuarioRepository = usuarioRepository;
        this.adminOid = adminOid;
    }

    public Usuario buscarPorOid(String oid) {
        return usuarioRepository.findByEntraIdOid(oid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
    }

    public Usuario buscarOCrearUsuario(UsuarioRequest request) {
        return usuarioRepository.findByEntraIdOid(request.oid())
                .map(usuarioExistente -> {
                    usuarioExistente.setNombre(request.nombre());
                    usuarioExistente.setEmail(request.email());
                    usuarioExistente.setRol(resolverRolUsuario(request.oid()));
                    return usuarioRepository.save(usuarioExistente);
                })
                .orElseGet(() -> {
                    Usuario nuevoUsuario = new Usuario(request.oid(), request.nombre(), request.email(), resolverRolUsuario(request.oid()));
                    return usuarioRepository.save(nuevoUsuario);
                });
    }

    private RolUsuario resolverRolUsuario(String oid) {
        return adminOid.equalsIgnoreCase(oid) ? RolUsuario.ADMIN : RolUsuario.USER;
    }
}
