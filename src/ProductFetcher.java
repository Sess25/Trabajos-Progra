import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProductFetcher {

    public static void main(String[] args) {
        // Pedir al usuario el ID del producto
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto: ");
        int productId = scanner.nextInt();

        // URL base de la API
        String baseUrl = "https://fake-store-api-2no73ornoa-uc.a.run.app/api/products/";
        String apiUrl = baseUrl + productId;

        try {
            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear solicitud GET
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            // Enviar solicitud y obtener respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Validar código de respuesta
            if (response.statusCode() == 200) {
                // Extraer información del JSON usando cadenas
                String json = response.body();

                String name = extractValue(json, "title");
                String description = extractValue(json, "description");
                double price = Double.parseDouble(extractValue(json, "price"));
                String imageUrl = extractValue(json, "image");

                // Obtener hora actual
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDate = now.format(formatter);

                // Imprimir resultados
                System.out.println("Producto encontrado:");
                System.out.println("Nombre: " + name);
                System.out.println("Descripción: " + description);
                System.out.println("Precio: $" + price);
                System.out.println("Imagen: " + imageUrl);
                System.out.println("Hora de consulta: " + formattedDate);
            } else {
                System.out.println("Error: No se pudo obtener el producto. Código de estado: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al realizar la solicitud: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Método para extraer valores de un JSON usando cadenas
    private static String extractValue(String json, String key) {
        String[] parts = json.split("\"" + key + "\":");
        if (parts.length > 1) {
            String value = parts[1].split(",")[0];
            return value.replace("\"", "").replace("}", "").trim();
        }
        return "";
    }
}
