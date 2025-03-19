package com.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.usuarios.Usuario;

public class UsuarioTests {

    @Test
    public void testValidarUsuarioCorrecto() {
        assertTrue(Usuario.validarUsuario("_username"));
    }

    @Test
    public void testValidarUsuarioErroneo() {
        assertFalse(Usuario.validarUsuario(""));
        assertFalse(Usuario.validarUsuario("_user   name"));
        assertFalse(Usuario.validarUsuario("_user;name"));
        assertFalse(Usuario.validarUsuario("username"));
        assertFalse(Usuario.validarUsuario("_administrador"));
    }

    @Test
    public void testValidarPasswordCorrecto() {
        assertTrue(Usuario.validarPassword("_username", "password"));
    }

    @Test
    public void testValidarPasswordErroneo() {
        assertFalse(Usuario.validarPassword("_username", ""));
        assertFalse(Usuario.validarPassword("_username", "pass  word"));
        assertFalse(Usuario.validarPassword("_username", "pass;word"));
        assertFalse(Usuario.validarPassword("administrador", "admin"));
        assertFalse(Usuario.validarPassword("_username", "pas"));
        assertFalse(Usuario.validarPassword("_username", "username"));
        assertFalse(Usuario.validarPassword("_username", "_username"));
    }

    @Test
    public void testRegistrarCorrecto() {
        assertNotNull(Usuario.registrar("_username", "PassWord"));
    }

    @Test
    public void testRegistrarErroneo() {
        assertNull(Usuario.registrar("_username", "pass;word"));
    }
}
