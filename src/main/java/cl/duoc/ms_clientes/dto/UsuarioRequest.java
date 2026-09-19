package cl.duoc.ms_clientes.dto;

public record UsuarioRequest(
        String oid,
        String nombre,
        String email,
        String rol) {
}
