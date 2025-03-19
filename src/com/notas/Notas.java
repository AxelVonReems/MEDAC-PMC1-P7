package com.notas;

import java.util.HashMap;
import java.util.Scanner;

public class Notas {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        HashMap<String, Double> gradesList = new HashMap<String, Double>();

        Double grade = 0.0, gradeTotal = 0.0, gradeAvg, gradeMax = 0.0, gradeMin = 10.0;
        String subjectMax = "NONE", subjectMin = "NONE", subject = "NONE", ans = "n";

        // Printing welcome message

        System.out.println(
            "¡NOTATRON 3000 te saluda!\n" +
            "Voy a calcular tu nota media. Las notas no pueden ser menores de 1 ni mayores de 10. Para detener el " +
            "proceso de introducción de notas, escribe 'stop' como nombre de asignatura o introduce una nota menor de 1."
        );

        // Getting user notes

        do {
            System.out.println("Introduce el nombre de la asignatura:");
            subject = input.nextLine();
            while (subject.isEmpty()) {
                System.out.println("El nombre de la asignatura no puede estar vacío. Introduce una asignatura:");
                subject = input.nextLine();
            }
            if (subject.equalsIgnoreCase("stop")) {
                break;
            }
            System.out.println("Introduce una nota. Para los números decimales, usa una coma.:");
            grade = input.nextDouble();
            input.nextLine();
            while (grade > 10) {
                System.out.println("No puedes tener una nota mayor a 10. No puedo guardar la última nota.");
                grade = input.nextDouble();
                input.nextLine();
            }
            if (grade < 1) {
                break;
            }
            gradesList.put(subject, grade);
        } while (grade >= 1);

        // Exiting the programm if first grade is less than 1

        if (gradesList.isEmpty()) {
            System.out.println("No has introducido ninguna nota correcta. Termino la ejecución.");
            input.close();
            return;
        }

        // Printing grade list

        System.out.println("Tus notas son: " + gradesList);

        // Change grades loop

        System.out.println("¿Quieres cambiar alguna nota? [s/n]");
        ans = input.nextLine().toLowerCase();
        while (ans.equals("s")) {
            System.out.println("Introduce el nombre de la asignatura:");
            subject = input.nextLine();
            while (!gradesList.containsKey(subject)) {
                System.out.println("El nobre de la asignatura es incorrecto. Introduce el nombre de la asignatura:");
                subject = input.nextLine();
            }
            System.out.println("Introduce nuevo valor:");
            grade = input.nextDouble();
            while (1> grade || grade > 10) {
                System.out.println("Las notas no pueden ser menores de 1 ni mayores de 10. Introduce nuevo valor:");
                grade = input.nextDouble();
            }
            gradesList.replace(subject, grade);
            System.out.println("Tus notas son: " + gradesList);
            System.out.println("¿Quieres cambiar otra nota? [s/n]");
            input.nextLine();
            ans = input.nextLine().toLowerCase();
        }

        // Delete grades loop

        System.out.println("¿Quieres eliminar alguna nota? [s/n]");
        ans = input.nextLine().toLowerCase();
        while (ans.equals("s")) {
            System.out.println("Introduce el nombre de la asignatura:");
            subject = input.nextLine();
            while (!gradesList.containsKey(subject)) {
                System.out.println("El nobre de la asignatura incorrecto. Introduce el nombre de la asignatura:");
                subject = input.nextLine();
            }
            gradesList.remove(subject);

            // Exiting the programm if user has deleted all grades

            if (gradesList.isEmpty()) {
                System.out.println("Has eliminado todas las notas. Termino la ejecución.");
                input.close();
                return;
            }
            System.out.println("Tus notas son: " + gradesList + "\n¿Quieres eliminar otra nota? [s/n]");
            ans = input.nextLine().toLowerCase();
        }

        // Closing Scanner

        input.close();

        // Getting average, maximum and minimum grades

        for (Double i : gradesList.values()) {
            gradeTotal += i;
        }
        gradeAvg = gradeTotal / gradesList.size();

        for (String i : gradesList.keySet()) {
            Double value = gradesList.get(i);
            if (value > gradeMax) {
                subjectMax = i;
                gradeMax = value;
            }
        }

        for (String i : gradesList.keySet()) {
            Double value = gradesList.get(i);
            if (value < gradeMin) {
                subjectMin = i;
                gradeMin = value;
            }
        }

        // Printing average, maximum and minimum grades

        System.out.println(
            "Tus notas son: " + gradesList + "\n\nTu nota media es: " + gradeAvg + "\nTu nota más alta es de la asignatura: " +
            subjectMax + " - " + gradeMax + "\nTu nota mas baja es de la asignatura: " + subjectMin + " - " + gradeMin
        );
    }
}
