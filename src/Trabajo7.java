import java.util.Scanner;

public class Trabajo7 {
    
    static float vol(float radio){
        return (float) ((4.0 / 3.0) * Math.PI * Math.pow(radio, 3));
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        System.out.println("Introduce el radio de la esfera");
        float radio = sc.nextFloat();
        System.out.println("El volumen de una esfera de radio " + radio + " es " + vol(radio));
        sc.close();
    }
}
