package TiendaVirtualDef;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class Utils {

    public static String enviarPeticionGet(String apiUrl) {
        try {
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
                System.out.println("Error en la respuesta: Código " + codigoRespuesta);
            }
        } catch (Exception e) {
            System.out.println("Error al enviar la petición GET: " + e.getMessage());
        }
        return null;
    }

    public static Producto parseProducto(String json) {
        try {
            json = json.trim();
            if (json.startsWith("{") && json.endsWith("}")) {
                json = json.substring(1, json.length() - 1);
            }

            String[] pares = json.split(",(?=\")");
            int id = 0;
            String title = "";
            double price = 0.0;
            String description = "";
            String category = "";
            String image = "";

            for (String par : pares) {
                String[] claveValor = par.split(":", 2);
                String clave = claveValor[0].trim().replace("\"", "");
                String valor = claveValor[1].trim().replace("\"", "");

                switch (clave) {
                    case "id":
                        id = Integer.parseInt(valor);
                        break;
                    case "title":
                        title = valor;
                        break;
                    case "price":
                        price = Double.parseDouble(valor);
                        break;
                    case "description":
                        description = valor;
                        break;
                    case "category":
                        category = valor;
                        break;
                    case "image":
                        image = valor;
                        break;
                }
            }
            return new Producto(id, title, price, description, category, image);

        } catch (Exception e) {
            System.out.println("Error al parsear el JSON: " + e.getMessage());
            return null;
        }
    }
}
