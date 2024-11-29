import java.util.Scanner;
public class Trabajo5 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Escribe el 1er numer");
        int mayor = scn.nextInt();
        System.out.println("Escribe el 2do numer");
        int num2 = scn.nextInt();
          if (num2>mayor){
            mayor = num2;
          }
        System.out.println("Escribe el 3er numer");
        int num3 = scn.nextInt();
          if (num3>mayor){
            mayor = num3;
          }
     System.out.println("El numero mayor es " + mayor);
     scn.close();
    }

}
