import java.util.Scanner;

public class aburrido {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.print("Escribe el primer número: ");
        int min1 = scan.nextInt();

        System.out.print("Escribe el segundo número: ");
        int min2 = scan.nextInt();

        if (min2 < min1) {
            int temp = min1;
            min1 = min2;
            min2 = temp;
        }


        System.out.print("Escribe el tercer número: ");
        int num3 = scan.nextInt();
        if (num3 < min1) {
            min2 = min1;
            min1 = num3;
        } else if (num3 < min2) {
            min2 = num3;
        }

        System.out.print("Escribe el cuarto número: ");
        int num4 = scan.nextInt();
        if (num4 < min1) {
            min2 = min1;
            min1 = num4;
        } else if (num4 < min2) {
            min2 = num4;
        }


        System.out.print("Escribe el quinto número: ");
        int num5 = scan.nextInt();
        if (num5 < min1) {
            min2 = min1;
            min1 = num5;
        } else if (num5 < min2) {
            min2 = num5;
        }

 
        System.out.println("Los dos números menores son " + min1 + " y " + min2);
        scan.close();
    }
}
