import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Product {

    public int id;
    public String title;
    public double price;
    public String description;
    public List<String> images;

    @SerializedName("category")
    public Category category;  // Aquí se espera un objeto de tipo Category

    // Constructor, getters y setters si son necesarios
}
