import java.util.Scanner;

public class Trabajo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce un número entero positivo: ");
        int numero = scanner.nextInt();
        
        if (numero <= 0) {
            System.out.println("Debes introducir un número entero positivo.");
        } else {
            int CantCifr = 0;
            while (numero > 0) {
                numero /= 10;
                CantCifr++;
            }
            
           
                System.out.println("El número tiene " + CantCifr + " cifra(s).");
            }
            scanner.close();
        }
        
    }
