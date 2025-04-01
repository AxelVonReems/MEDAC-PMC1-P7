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
        String[] credencialesSeparados = credenciales.split(SEPARADOR);

        if (
            credencialesSeparados[0].equalsIgnoreCase(usuarioLogin.trim()) &&
            credencialesSeparados[1].equals(passwordLogin.trim())
            ) {
            System.out.println("Bienvenido a tu cuenta!");
            return true;
        } else {
            System.out.println("Las credenciales no son válidas");
            return false;
        }
    }

    public static Usuario registrar(String username, String password) {
        username = username.trim().toLowerCase();
        password = password.trim();

        if (validarUsuario(username) && validarPassword(username, password)) {
            System.out.println("Registro exitoso.\n");
            return new Usuario(username, password);
        }
        return null;
    }

    public static boolean validarUsuario(String username) {
        if (
            username.isEmpty() ||
            username.contains(" ") ||
            username.contains(";") ||
            (username.charAt(0) != '_' && !username.equals("administrador")) ||
            username.equals("_administrador")
            ) {
            System.out.println(
                "Nombre del usuario tiene que empezar con guion bajo si el ususario no sea el administrador, no " +
                "puede ser vacío, contener espacios, simbolos ';'"
            );
            return false;
        } else {
            return true;
        }
    }

    public static boolean validarPassword(String username, String password) {
        if (
            password.isEmpty() ||
            password.contains(" ") ||
            password.contains(";") ||
            (username.equals("administrador") && password.equals("admin")) ||
            password.length() < 4 ||
            username.equals("_" + password) ||
            username.equals(password)
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
