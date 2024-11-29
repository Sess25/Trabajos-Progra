import java.util.Scanner;

public class Trabajo12 {

    static double Triangulo(float base, float altura) {
        return (base * altura) / 2;
    }

    static double Cuadrado(float lado) {
        return lado * lado;
    }

    static double Circulo(float radio) {
        return Math.PI * radio * radio;
    }

    static double Rectangulo(float base, float altura) {
        return base * altura;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Escribe la operacion que quieres realizar:");
            System.out.println("1 Triangulo");
            System.out.println("2 Cuadrado");
            System.out.println("3 Circulo");
            System.out.println("4 Rectangulo");
            System.out.println("5 Salir");
            byte operacion = scn.nextByte();

            switch (operacion) {
                case 1: 
                    System.out.println("Introduce la base del triángulo:");
                    float baseTri = scn.nextFloat();
                    System.out.println("Introduce la altura del triángulo:");
                    float alturaTri = scn.nextFloat();
                    System.out.println("El área del triángulo es: " + Triangulo(baseTri, alturaTri));
                    break;

                case 2:
                    System.out.println("Introduce el lado del cuadrado:");
                    float lado = scn.nextFloat();
                    System.out.println("El área del cuadrado es: " + Cuadrado(lado));
                    break;

                case 3:
                    System.out.println("Introduce el radio del círculo:");
                    float radio = scn.nextFloat();
                    System.out.println("El área del círculo es: " + Circulo(radio));
                    break;

                case 4: 
                    System.out.println("Introduce la base del rectángulo:");
                    float baseRec = scn.nextFloat();
                    System.out.println("Introduce la altura del rectángulo:");
                    float alturaRec = scn.nextFloat();
                    System.out.println("El área del rectángulo es: " + Rectangulo(baseRec, alturaRec));
                    break;

                case 5:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

            System.out.println();
        }

        scn.close();
    }
}
