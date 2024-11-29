import java.util.Scanner;
public class Trabajo6 {
    static float FarCel(float cel){
    return 32 + (9 * cel / 5);
}
public static void main(String[] args){
    Scanner sc = new Scanner (System.in);
    System.out.println("Introduce los grados celsius que deseas convertir");
    float cel = sc.nextFloat();
    System.out.println( cel + " grados celcius es igual a "  + FarCel(cel) + " grados farenheit");
    sc.close();
} }
