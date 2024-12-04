package TiendaVirtualFinalVer;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProductoService productoService = new ProductoService();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);


        String apiUrl = "https://fakestoreapi.com/products";
        productoService.cargarProductosDesdeAPI(apiUrl);

        while (true) {
            System.out.println("*****************************************************");
            System.out.println("Bienvenido al catálogo de productos                *");
            System.out.println("* 1) Buscar productos                              *");
            System.out.println("* 2) Agregar producto(funciona cuando le da la gana)*");
            System.out.println("* 3) Eliminar producto                             *");
            System.out.println("* 4) Salir                                         *");
            System.out.println("*****************************************************");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("1) Buscar productos por:");
                    System.out.println("   a) ID");
                    System.out.println("   b) Categoría");
                    System.out.println("   c) Nombre/Descripción");
                    System.out.println("   d) Rango de precio (tambien funciona cuando le da la gana)");
                    System.out.print("Selecciona una opción: ");
                    String opcionBusqueda = scanner.nextLine();

                    switch (opcionBusqueda) {
                        case "a":
                            System.out.print("Ingresa el ID del producto: ");
                            int id = scanner.nextInt();
                            Producto producto = productoService.buscarProductoPorId(id);
                            if (producto != null) {
                                System.out.println("Producto encontrado:");
                                System.out.println(producto);
                                PDFService.generarPDF(producto);
                            } else {
                                System.out.println("Producto no encontrado...");
                            }
                            break;
                        case "b":
                            System.out.print("Ingresa la categoría: ");
                            String categoria = scanner.nextLine();
                            ArrayList<Producto> productosPorCategoria = productoService.buscarProductosPorCategoria(categoria);
                            if (productosPorCategoria.isEmpty()) {
                                System.out.println("No se encontraron productos en esta categoría.");
                            } else {
                                for (Producto prod : productosPorCategoria) {
                                    System.out.println(prod);
                                    PDFService.generarPDF(prod);
                                }
                            }
                            break;
                        case "c":
                            System.out.print("Ingresa el nombre o descripción: ");
                            String keyword = scanner.nextLine();
                            ArrayList<Producto> productosPorNombre = productoService.buscarProductosPorNombreDescripcion(keyword);
                            if (productosPorNombre.isEmpty()) {
                                System.out.println("No se encontraron productos con esa palabra clave.");
                            } else {
                                for (Producto prod : productosPorNombre) {
                                    System.out.println(prod);
                                    PDFService.generarPDF(prod);
                                }
                            }
                            break;
                        case "d":
                            System.out.print("Ingresa el precio mínimo: ");
                            double precioMin = scanner.nextDouble();
                            System.out.print("Ingresa el precio máximo: ");
                            double precioMax = scanner.nextDouble();
                            ArrayList<Producto> productosPorPrecio = productoService.buscarProductosPorPrecio(precioMin, precioMax);
                            if (productosPorPrecio.isEmpty()) {
                                System.out.println("No se encontraron productos en este rango de precio.");
                            } else {
                                for (Producto prod : productosPorPrecio) {
                                    System.out.println(prod);
                                    PDFService.generarPDF(prod);
                                }
                            }
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;
                case 2:
                    System.out.print("Ingresa el ID del nuevo producto: ");
                    int idNuevo = scanner.nextInt();
                    scanner.nextLine();  // Consumir salto de línea
                    System.out.print("Ingresa el nombre: ");
                    String nombreNuevo = scanner.nextLine();
                    System.out.print("Ingresa la descripción: ");
                    String descripcionNuevo = scanner.nextLine();
                    System.out.print("Ingresa el precio: ");
                    double precioNuevo = scanner.nextDouble();
                    scanner.nextLine();  // Consumir salto de línea
                    System.out.print("Ingresa la categoría: ");
                    String categoriaNuevo = scanner.nextLine();
                    System.out.print("Ingresa la URL de la imagen: ");
                    String imagenNuevo = scanner.nextLine();

                    Producto nuevoProducto = new Producto(idNuevo, nombreNuevo, descripcionNuevo, precioNuevo, categoriaNuevo, imagenNuevo);
                    productoService.agregarProducto(nuevoProducto);
                    System.out.println("Producto agregado correctamente.");
                    break;
                case 3:
                    System.out.print("Ingresa el ID del producto a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    productoService.eliminarProducto(idEliminar);
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    } 
}
