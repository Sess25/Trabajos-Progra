package Modulo;
import java.util.Scanner;
public class Leer {
    Scanner scanner;
    public Leer(){
        scanner = new Scanner(System.in);
    }
    public String LeerTexto(){
        return scanner.nextLine();

    }
    public int LeerNumeroEntero(){
        return scanner.nextInt();

    }
    public double LeerNumeroDecimal(){
        return scanner.nextDouble();

    }
    

}
