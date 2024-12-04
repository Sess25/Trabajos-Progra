package TiendaVirtualDef;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ProductoService {

    public ArrayList<Producto> productos = new ArrayList<>(); 

    public void cargarProductosDesdeAPI(String apiUrl) {
        try {
            String respuesta = enviarPeticionGet(apiUrl);
            if (respuesta != null) {
                parsearProductos(respuesta);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar productos desde la API: " + e.getMessage());
        }
    }

    public String enviarPeticionGet(String apiUrl) throws IOException {
        @SuppressWarnings("deprecation")
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

    public void parsearProductos(String json) {
        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonProducto = jsonArray.getJSONObject(i);
            Producto producto = new Producto(
                    jsonProducto.getInt("id"),
                    jsonProducto.getString("title"),
                    jsonProducto.getString("description"),
                    jsonProducto.getDouble("price"),
                    jsonProducto.getString("category"),
                    jsonProducto.getString("image")
            );
            productos.add(producto);
        }
    }

    public Producto buscarProductoPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public ArrayList<Producto> buscarProductosPorPrecio(double min, double max) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getPrecio() >= min && producto.getPrecio() <= max) {
                productosEncontrados.add(producto);
            }
        }
        return productosEncontrados;
    }

    public ArrayList<Producto> buscarProductosPorNombreDescripcion(String keyword) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getNombre().contains(keyword) || producto.getDescripcion().contains(keyword)) {
                productosEncontrados.add(producto);
            }
        }
        return productosEncontrados;
    }

    public ArrayList<Producto> buscarProductosPorCategoria(String categoria) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                productosEncontrados.add(producto);
            }
        }
        return productosEncontrados;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(int id) {
        Producto productoAEliminar = buscarProductoPorId(id);
        if (productoAEliminar != null) {
            productos.remove(productoAEliminar);
            System.out.println("Producto con ID " + id + " eliminado correctamente.");
        } else {
            System.out.println("No se encontró un producto con el ID " + id);
        }
    }

    public ArrayList<Producto> obtenerProductos() {
        return productos;
    }
}