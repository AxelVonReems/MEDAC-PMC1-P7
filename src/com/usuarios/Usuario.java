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

    public boolean login(String usuarioLogin, String passwordLogin) {
        // No esta permitido realizar ninguna operacion con los parametros salvo equals.
        usuarioLogin = usuarioLogin.toLowerCase();
        passwordLogin = passwordLogin.toLowerCase();
        // No esta permitido realizar ninguna operacion con los parametros salvo equals.
        if (credenciales.equals(usuarioLogin + ";" + passwordLogin)) {
            System.out.println("Bienvenido a tu cuenta!");
            return true;
        } else {
            System.out.println("Los credenciales no son válidos");
            return false;
        }
    }

    public static Usuario registrar(String username, String password) {
        username = username.toLowerCase();
        password = password.toLowerCase();

        if (validarUsuario(username) && validarPassword(username, password)) {
            System.out.println("Registro exitoso.\n");
            return new Usuario(username, password);
        }
        return null;
    }

    public static boolean validarUsuario(String username) {
        if (
            username.length() == 0 ||
            username.contains(" ") ||
            username.contains(";") ||
            // question about admins
            (username.charAt(0) == '_' && !username.equals("_administrador"))
            // question about admins
            ) {
            System.out.println(
                "Nombre del usuario no puede ser vacío, contener espacios, simbolos ';' ni empezar con guion bajo " +
                "si el ususario no sea el administrador"
            );
            return false;
        } else {
            return true;
        }
    }

    public static boolean validarPassword(String username, String password) {
        if (
            password.contains(" ") ||
            password.contains(";") ||
            // question about admins
            (username.equals("_administrador") && password.equals("admin")) ||
            // question about admins
            (password.length() < 4) ||
            (username.equals(password.toLowerCase()))
            ) {
            System.out.println(
                "Contraseña no puede ser vacía, igual al nombre del usuario, contener espacios, simbolos ';' ni ser " +
                "'admin' si el ususario no sea el administrador"
            );
            return false;
        } else {
            return true;
        }
    }

}
