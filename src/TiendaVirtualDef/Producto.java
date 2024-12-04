package TiendaVirtualDef;
public class Producto {
    public int id;
    public String nombre;
    public String descripcion;
    public double precio;
    public String categoria;
    public String imagen;

    public Producto(int id, String nombre, String descripcion, double precio, String categoria, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.imagen = imagen;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getImagen() {
        return imagen;
    }
    @Override
    public String toString() {
        return "ID: " + id + "\nNombre: " + nombre + "\nPrecio: " + precio + "\nDescripción: " + descripcion + "\nCategoría: " + categoria + "\nImagen: " + imagen;
    }
}
