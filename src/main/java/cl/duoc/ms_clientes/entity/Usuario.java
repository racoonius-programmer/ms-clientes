package cl.duoc.ms_clientes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entra_id_oid", nullable = false, unique = true)
    private String entraIdOid;

    private String nombre;

    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RolUsuario rol = RolUsuario.USER;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaRegistro;

    public Usuario() {
    }

    public Usuario(String entraIdOid, String nombre, String email, RolUsuario rol) {
        this.entraIdOid = entraIdOid;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    @PrePersist
    public void prePersist() {
        if (rol == null) {
            rol = RolUsuario.USER;
        }

        if (fechaRegistro == null) {
            fechaRegistro = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntraIdOid() {
        return entraIdOid;
    }

    public void setEntraIdOid(String entraIdOid) {
        this.entraIdOid = entraIdOid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
