package TiendaVirtualDef;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class PDFService {

    public void generarPDF(String contenido, String fechaHora) {
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
}
