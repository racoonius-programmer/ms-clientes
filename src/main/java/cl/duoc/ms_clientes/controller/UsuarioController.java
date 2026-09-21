package cl.duoc.ms_clientes.controller;

import cl.duoc.ms_clientes.dto.UsuarioRequest;
import cl.duoc.ms_clientes.dto.UsuarioResponse;
import cl.duoc.ms_clientes.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{oid}")
    public UsuarioResponse buscarPorOid(@PathVariable String oid) {
        return UsuarioResponse.from(usuarioService.buscarPorOid(oid));
    }

    @PostMapping
    public UsuarioResponse buscarOCrearUsuario(@RequestBody UsuarioRequest request) {
        return UsuarioResponse.from(usuarioService.buscarOCrearUsuario(request));
    }
}