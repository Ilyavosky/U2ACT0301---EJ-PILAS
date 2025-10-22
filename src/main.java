import models.Navegation;
import utils.NavegationUtils;
import models.TextEditor;
import utils.TextEditorUtils;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salirPrograma = false;

        while (!salirPrograma) {
            System.out.println("\n===== MENÚ PRINCIPAL ====");
            System.out.println("1. Simulador de Navegacion");
            System.out.println("2. Simulador de Editor de Texto");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");

            int opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1:
                    iniciarSimuladorNavegacion(scanner);
                    break;
                case 2:
                    iniciarSimuladorEditor(scanner);
                    break;
                case 3:
                    salirPrograma = true;
                    System.out.println("Adios.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }
        scanner.close();
    }

    public static void iniciarSimuladorNavegacion(Scanner scanner) {
        NavegationUtils navegador = new NavegationUtils();
        boolean salir = false;
        System.out.println("\n--- Simulador Navegacion ---");

        while (!salir) {
            System.out.println("\n1. Visitar pagina");
            System.out.println("2. Retroceder");
            System.out.println("3. Avanzar");
            System.out.println("4. Ver estado");
            System.out.println("5. Volver al menu principal");
            System.out.print("Opcion: ");

            int opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1:
                    System.out.print("URL: ");
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
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }
    }

    public static void iniciarSimuladorEditor(Scanner scanner) {
        TextEditorUtils editor = new TextEditorUtils();
        boolean salir = false;
        System.out.println("\n--- Simulador Editor ---");
        editor.ShowStatus();

        while (!salir) {
            System.out.println("\n1. Escribir texto");
            System.out.println("2. Deshacer");
            System.out.println("3. Rehacer");
            System.out.println("4. Ver estado");
            System.out.println("5. Volver al menu principal");
            System.out.print("Opcion: ");

            int opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1:
                    System.out.print("Texto: ");
                    String texto = scanner.nextLine();
                    editor.revertAction(new TextEditor(texto));
                    editor.ShowStatus();
                    break;
                case 2:
                    editor.undoAction();
                    editor.ShowStatus();
                    break;
                case 3:
                    editor.redoAction();
                    editor.ShowStatus();
                    break;
                case 4:
                    editor.ShowStatus();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }
    }

    private static int leerOpcion(Scanner scanner) {
        int opcion = -1;
        try {
            opcion = scanner.nextInt();
        } catch (Exception e) {
        }
        scanner.nextLine();
        return opcion;
    }
}