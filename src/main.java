import models.Navegation;
import utils.NavegationUtils;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        NavegationUtils navegador = new NavegationUtils();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        System.out.println("--- Simulador de Navegación Web ---");

        while (!salir) {
            System.out.println("\nElija una opción:");
            System.out.println("1. Visitar nueva página");
            System.out.println("2. Retroceder (Atrás)");
            System.out.println("3. Avanzar (Adelante)");
            System.out.println("4. Ver estado actual");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            int opcion = 0;

            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                scanner.next();
                continue;
            }

            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la URL de la nueva página: ");
                    String url = scanner.nextLine();
                    navegador.goToNewPage(new Navegation(url));
                    navegador.mostrarEstadoActual();
                    break;
                case 2:
                    navegador.goBackwards();
                    navegador.mostrarEstadoActual();
                    break;
                case 3:
                    navegador.goForwards();
                    navegador.mostrarEstadoActual();
                    break;
                case 4:
                    navegador.mostrarEstadoActual();
                    break;
                case 5:
                    salir = true;
                    System.out.println("Cerrando el navegador. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}