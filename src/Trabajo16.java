import java.util.ArrayList;
import java.util.Scanner;

public class Trabajo16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();
        int suma = 0;

        while (true) {
            System.out.print("Ingresa un número entero (ingresa un número negativo para salir): ");
            int numero = scanner.nextInt();

            if (numero < 0) {
                break;
            }

            if (!numeros.contains(numero)) {
                numeros.add(numero); 
                suma += numero;
            } else {
                System.out.println("Número duplicado, no se agrega.");
            }
        }

        System.out.println("La suma de todos los números es: " + suma);

        scanner.close();
    }
}
