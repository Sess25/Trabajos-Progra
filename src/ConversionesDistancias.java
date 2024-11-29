import java.util.*;
public class ConversionesDistancias {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Conversiones metro = new Conversiones();
        System.out.println("Ingrese las millas que desea convertir");
        double m = scn.nextDouble();
        m = metro.MillaMetro(m);
        System.out.println(m);

        Conversiones decimetros = new Conversiones();
        System.out.println("Ingrese las millas que desea convertir a decimetros");
        double g = scn.nextDouble();
        g = decimetros.MillaDecimetros(g);
        System.out.println(g);


        Conversiones centimetros = new Conversiones();
        System.out.println("Ingresa las millas que desea convertir a centimetros");
        double c = scn.nextDouble();
        c = centimetros.MillaCentimetros(c);
        System.out.println(c);

        Conversiones kilometros = new Conversiones();
        System.out.println("Ingresa las millas que desea convertir a kilometros");
        double e = scn.nextDouble();
        e = kilometros.MillaKilometros(e);
        System.out.println(e);
        scn.close();
    } 
}
