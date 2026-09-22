package cl.duoc.ms_clientes.dto;

import cl.duoc.ms_clientes.entity.Usuario;

public record UsuarioResponse(
        String oid,
        String nombre,
        String email,
        String rol) {

    public static UsuarioResponse from(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getEntraIdOid(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getRol().toValue());
    }
}