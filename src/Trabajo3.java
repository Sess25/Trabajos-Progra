import java.lang.String;
import java.util.Scanner;
public class Trabajo3 {
    public static void main(String[] args) {
        Scanner snr = new Scanner (System.in); 
        String nm = snr.nextLine();

        System.out.println("Bienvenido, " + nm);
        snr.close();
    }
    
}
