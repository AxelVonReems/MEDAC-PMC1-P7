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
    public void testValidarAdminCorrecto() {
        assertTrue(Usuario.validarUsuario("administrador"));
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
    public void testRegistrarUsuarioCorrecto() {
        assertNotNull(Usuario.registrar("_username", "password"));
    }

    @Test
    public void testRegistrarAdminCorrecto() {
        assertNotNull(Usuario.registrar("administrador", "password"));
    }

    @Test
    public void testRegistrarUsuarioErroneo() {
        assertNull(Usuario.registrar("_usrnme", "pass;word"));
    }

    @Test
    public void testRegistrarAdminErroneo() {
        assertNull(Usuario.registrar("administrador", "pass;word"));
    }

    @Test
    public void testLoginUsuarioCorrecto() {
        Usuario testUser = Usuario.registrar("_username", "password");
        assertTrue(testUser.login("_userNAME", "password"));
    }

    @Test
    public void testLoginUsuarioErroneo() {
        Usuario testUser = Usuario.registrar("_username", "password");
        assertFalse(testUser.login("_usrNAME", "drowssap"));
    }

    @Test
    public void testLoginAdminCorrecto() {
        Usuario testAdmin = Usuario.registrar("administrador", "password");
        assertTrue(testAdmin.login("ADMINistrador", "password"));
    }

    @Test
    public void testLoginAdminErroneo() {
        Usuario testAdmin = Usuario.registrar("administrador", "password");
        assertFalse(testAdmin.login("ADMIistrador", "drowssap"));
    }

    @Test
    public void testGetCredenciales() {
        Usuario testUser = Usuario.registrar("_username", "password");
        assertTrue(testUser.getCredenciales().equals("_username;password"));
    }
}
