package TiendaVirtualDef;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PDFService {

    public static void generarPDF(Producto producto) {
        try {
            Document document = new Document();
            String filename = "Producto_" + producto.getId() + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(filename));

            document.open();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String fechaHora = sdf.format(new Date());

            Paragraph paragraph = new Paragraph();
            paragraph.add("Producto ID: " + producto.getId() + "\n");
            paragraph.add("Nombre: " + producto.getNombre() + "\n");
            paragraph.add("Descripción: " + producto.getDescripcion() + "\n");
            paragraph.add("Precio: " + producto.getPrecio() + "\n");
            paragraph.add("Categoría: " + producto.getCategoria() + "\n");
            paragraph.add("Imagen: " + producto.getImagen() + "\n");
            paragraph.add("Fecha de consulta: " + fechaHora);
            
            document.add(paragraph);
            document.close();

            System.out.println("PDF generado correctamente: " + filename);
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println("Error al generar el PDF: " + e.getMessage());
        }
    }
}
