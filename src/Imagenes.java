import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URI;
import java.io.IOException;

public class Imagenes extends Frame {
    private Image imagen;

    public Imagenes(String url) {
        try {
            imagen = Toolkit.getDefaultToolkit().getImage(URI.create(url).toURL());
            setSize(1920, 1500);
            setVisible(true);

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        } catch (IOException e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
    }

    @Override
    public void paint(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        String url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOqTxkfO_fS8pE0091z4xOQvzgOfjK1b6kKg&s";
        new Imagenes(url);
    }
}
