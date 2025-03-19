package com.main;

import java.util.Scanner;

import com.usuarios.Usuario;

public class App {
    public static void main(String[] args) {
        Usuario usuario;
        boolean resultadoLogin;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("=== REGISTRO ===");
            System.out.print("Usuario: ");
            String usuarioRegistro = scanner.nextLine();
            System.out.print("Password: ");
            String passwordRegistro = scanner.nextLine();
            usuario = Usuario.registrar(usuarioRegistro, passwordRegistro);
        } while (usuario == null);

        do {
            System.out.println("=== INICIO DE SESIÓN ===");
            System.out.print("Usuario: ");
            String usuarioLogin = scanner.nextLine();
            System.out.print("Password: ");
            String passwordLogin = scanner.nextLine();
            resultadoLogin = usuario.login(usuarioLogin, passwordLogin);
        } while (resultadoLogin == false);

        scanner.close();
    }
}
