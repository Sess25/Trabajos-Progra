package TiendaVirtualDef;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ProductoService {

    public void buscarProductos(Scanner scanner) {
        System.out.println("1) Buscar productos por:");
        System.out.println("   a) ID");
        System.out.println("   b) Categoría");
        System.out.println("   c) Nombre/Descripción");
        System.out.println("   d) Rango de precio");
        System.out.print("Selecciona una opción: ");
        String subOpcion = scanner.nextLine().toLowerCase();

        try {
            String apiUrl = "https://fakestoreapi.com/products";

            if (subOpcion.equals("a")) {
                System.out.print("Ingresa el ID del producto: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                apiUrl += "/" + id;
                String respuesta = enviarPeticionGet(apiUrl);
                if (respuesta != null) {
                    mostrarProducto(respuesta);
                } else {
                    System.out.println("Producto no encontrado...");
                }
            } else if (subOpcion.equals("b")) {
                System.out.print("Ingresa la categoría a buscar: ");
                String categoria = scanner.nextLine();
                apiUrl += "/category/" + categoria;
                String respuesta = enviarPeticionGet(apiUrl);
                if (respuesta != null && !respuesta.equals("[]")) {
                    mostrarProductos(respuesta);
                } else {
                    System.out.println("Productos no encontrados...");
                }
            } else if (subOpcion.equals("c")) {
                System.out.print("Ingresa el nombre o descripción a buscar: ");
                String palabraClave = scanner.nextLine().toLowerCase();
                String respuesta = enviarPeticionGet(apiUrl);
                if (respuesta != null) {
                    buscarPorNombreODescripcion(respuesta, palabraClave);
                } else {
                    System.out.println("Error al buscar productos...");
                }
            } else if (subOpcion.equals("d")) {
                System.out.print("Ingresa el precio mínimo: ");
                double precioMinimo = scanner.nextDouble();
                System.out.print("Ingresa el precio máximo: ");
                double precioMaximo = scanner.nextDouble();
                scanner.nextLine();
                String respuesta = enviarPeticionGet(apiUrl);
                if (respuesta != null) {
                    buscarPorRangoDePrecio(respuesta, precioMinimo, precioMaximo);
                } else {
                    System.out.println("Error al buscar productos...");
                }
            } else {
                System.out.println("Opción no válida.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void agregarProducto(Scanner scanner) {
        System.out.println("*****************************************************");
        System.out.print("Ingresa el ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingresa el Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa el Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Producto agregado tentativamente (solo simulación):");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("*****************************************************");
    }

    public void eliminarProducto(Scanner scanner) {
        System.out.print("Ingresa el ID del producto a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            String apiUrl = "https://fakestoreapi.com/products/" + id;
            HttpURLConnection conexion = (HttpURLConnection) new URL(apiUrl).openConnection();
            conexion.setRequestMethod("DELETE");

            int codigoRespuesta = conexion.getResponseCode();
            if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
                System.out.println("Producto con ID " + id + " eliminado correctamente.");
            } else {
                System.out.println("Error al eliminar el producto. Código: " + codigoRespuesta);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private String enviarPeticionGet(String apiUrl) throws IOException {
        HttpURLConnection conexion = (HttpURLConnection) new URL(apiUrl).openConnection();
        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("Accept", "application/json");

        int codigoRespuesta = conexion.getResponseCode();
        if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder respuesta = new StringBuilder();
            String linea;
            while ((linea = in.readLine()) != null) {
                respuesta.append(linea);
            }
            in.close();
            return respuesta.toString();
        } else {
            return null;
        }
    }

    private void mostrarProductos(String json) {
        String[] productos = json.substring(1, json.length() - 1).split("\\},\\{");
        for (String producto : productos) {
            mostrarProducto("{" + producto + "}");
        }
    }

    private void mostrarProducto(String json) {
        String fechaHoraConsulta = obtenerFechaHoraActual();

        String titulo = extraerValor(json, "title");
        String precio = extraerValor(json, "price");
        String descripcion = extraerValor(json, "description");
        String categoria = extraerValor(json, "category");
        String imagenUrl = extraerValor(json, "image");

        StringBuilder informacion = new StringBuilder();
        informacion.append("Consulta realizada el: ").append(fechaHoraConsulta).append("\n");
        informacion.append("Producto encontrado:\n");
        informacion.append("Nombre: ").append(titulo).append("\n");
        informacion.append("Precio: $").append(precio).append("\n");
        informacion.append("Descripción: ").append(descripcion).append("\n");
        informacion.append("Categoría: ").append(categoria).append("\n");
        informacion.append("Imagen: ").append(imagenUrl).append("\n");
        informacion.append("Para abrir la imagen, copia el enlace y pégalo en tu navegador.\n");

        System.out.println(informacion);

        generarPDF(informacion.toString(), fechaHoraConsulta);
    }

    private void generarPDF(String contenido, String fechaHora) {
        try {
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream("productos.pdf"));
            documento.open();

            documento.add(new Paragraph("Catálogo de Productos", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
            documento.add(new Paragraph("Consulta realizada el: " + fechaHora));
            documento.add(new Paragraph("\n"));

            for (String linea : contenido.split("\n")) {
                documento.add(new Paragraph(linea, FontFactory.getFont(FontFactory.HELVETICA, 12)));
            }

            documento.close();
            System.out.println("PDF generado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al generar el PDF: " + e.getMessage());
        }
    }

    private String obtenerFechaHoraActual() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formato.format(new Date());
    }

    private String extraerValor(String json, String clave) {
        try {
            String[] partes = json.split("\"" + clave + "\":");
            if (partes.length > 1) {
                String valor = partes[1].split(",")[0];
                if (valor.startsWith("\"")) {
                    valor = valor.substring(1, valor.length() - 1);
                }
                return valor;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private void buscarPorNombreODescripcion(String json, String palabraClave) {
        String[] productos = json.substring(1, json.length() - 1).split("\\},\\{");
        boolean encontrado = false;
        for (String producto : productos) {
            if (producto.toLowerCase().contains(palabraClave)) {
                mostrarProducto("{" + producto + "}");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado...");
        }
    }

    private void buscarPorRangoDePrecio(String json, double precioMinimo, double precioMaximo) {
        String[] productos = json.substring(1, json.length() - 1).split("\\},\\{");
        boolean encontrado = false;
        for (String producto : productos) {
            double precio = Double.parseDouble(extraerValor("{" + producto + "}", "price"));
            if (precio >= precioMinimo && precio <= precioMaximo) {
                mostrarProducto("{" + producto + "}");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron productos en el rango de precio.");
        }
    }
}