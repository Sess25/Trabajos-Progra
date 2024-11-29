package TiendaVirtualDef;

public class Producto {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    // Constructor
    public Producto(int id, String title, double price, String description, String category, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
    }



    @Override
    public String toString() {
        return "Producto encontrado:\n" +
               "ID: " + id + "\n" +
               "Nombre: " + title + "\n" +
               "Precio: $" + price + "\n" +
               "Descripción: " + description + "\n" +
               "Categoría: " + category + "\n" +
               "Imagen: " + image + "\n";
    }
}
