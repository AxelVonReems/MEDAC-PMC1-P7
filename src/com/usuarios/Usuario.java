package com.usuarios;

public class Usuario {
    private String credenciales;
    private static final String SEPARADOR = ";";

    private Usuario(String username, String password) {
        this.credenciales = username + SEPARADOR + password;
    }

    public String getCredenciales() {
        return credenciales;
    }

    // public boolean login(String usuarioLogin, String passwordLogin) {
    //     // TODO
    //     // No esta permitido realizar ninguna operacion con los parametros salvo equals.
    // }

    public static Usuario registrar(String username, String password) {
        // TODO

        if (validarUsuario(username) && validarPassword(username, password)) {
            System.out.println("Registro exitoso.\n");
            return new Usuario(username, password);
        }
        return null;
    }

    // public static boolean validarUsuario(String username) {
    //     // TODO
    // }

    // public static boolean validarPassword(String username, String password) {
    //     // TODO
    // }

}
