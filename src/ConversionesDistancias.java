import java.util.*;
public class ConversionesDistancias {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Bienveindo al conversor de millas a cualquier distancia. Selecciona una opcion a realizar");
        System.out.println("1) Millas a Metro");
        System.out.println("2) Millas a decimetros");
        System.out.println("3) Millas a centimetros");
        System.out.println("4) Millas a kilometros");
        System.out.println("5) Salir");
        int Opcion = scn.nextInt();
        switch (Opcion){
            case 1:{
                Conversiones metro = new Conversiones();
                System.out.println("Ingrese las millas que desea convertir");
                double m = scn.nextDouble();
                m = metro.MillaMetro(m);
                System.out.println(m);
                break;
            }
            case 2:{
                Conversiones decimetros = new Conversiones();
                System.out.println("Ingrese las millas que desea convertir a decimetros");
                double g = scn.nextDouble();
                g = decimetros.MillaDecimetros(g);
                System.out.println(g);
                break;
            }
            case 3:{
                Conversiones centimetros = new Conversiones();
                System.out.println("Ingresa las millas que desea convertir a centimetros");
                double c = scn.nextDouble();
                c = centimetros.MillaCentimetros(c);
                System.out.println(c);
                break;
            }
            case 4:{
                Conversiones kilometros = new Conversiones();
                System.out.println("Ingresa las millas que desea convertir a kilometros");
                double e = scn.nextDouble();
                e = kilometros.MillaKilometros(e);
                System.out.println(e);
                break;
            }
            case 5:{
                System.out.println("Error");
                System.out.println("Error");
                System.out.println("Error");
                System.out.println("Borrando System32...");
                System.out.println("...");
                System.out.println("...");
                System.out.println("System32 fue eliminado exitosamente.");
                break;
            }
        }
        scn.close();
    } 
 
}
