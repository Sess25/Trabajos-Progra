import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class PdfGenerator1 {

    // Método para generar el PDF usando iText 5
    public static void generateProductPdf(Product product) {
        try {
            // Crear un documento PDF
            Document pdfDoc = new Document();
            PdfWriter.getInstance(pdfDoc, new FileOutputStream("Producto_" + product.id + ".pdf"));
            pdfDoc.open();

            // Agregar título
            pdfDoc.add(new Paragraph("Detalles del Producto"));

            // Agregar detalles del producto
            pdfDoc.add(new Paragraph("ID: " + product.id));
            pdfDoc.add(new Paragraph("Título: " + product.title));
            pdfDoc.add(new Paragraph("Precio: $" + product.price));
            pdfDoc.add(new Paragraph("Descripción: " + product.description));
            pdfDoc.add(new Paragraph("Categoría: " + (product.category != null ? product.category.name : "No disponible")));
            pdfDoc.add(new Paragraph("Imágenes: " + String.join(", ", product.images)));

            // Cerrar el documento
            pdfDoc.close();

            System.out.println("PDF generado con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al generar el PDF.");
        }
    }
}
