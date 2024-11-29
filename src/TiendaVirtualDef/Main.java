package TiendaVirtualDef;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductoService productoService = new ProductoService();

        while (true) {
            System.out.println("*****************************************************");
            System.out.println("Bienvenido al catalogo de productos                *");
            System.out.println("* 1) Buscar productos                              *");
            System.out.println("* 2) Agregar producto                              *");
            System.out.println("* 3) Eliminar producto                             *");
            System.out.println("* 4) Salir                                         *");
            System.out.println("*****************************************************");
            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    productoService.buscarProductos(scanner);
                    break;
                case "2":
                    productoService.agregarProducto(scanner);
                    break;
                case "3":
                    productoService.eliminarProducto(scanner);
                    break;
                case "4":
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
