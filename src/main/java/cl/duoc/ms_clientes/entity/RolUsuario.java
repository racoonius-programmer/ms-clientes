package cl.duoc.ms_clientes.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RolUsuario {
    ADMIN,
    USER;

    @JsonCreator
    public static RolUsuario fromValue(String value) {
        if (value == null) {
            return null;
        }

        return RolUsuario.valueOf(value.trim().toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return name().toLowerCase();
    }
}
