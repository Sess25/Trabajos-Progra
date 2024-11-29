import java.util.Scanner;
public class Trabajo8{
    public static void main(String a[])
    {
        // Leer por teclado un número entero, se deberá dibujar una flecha apuntando hacia
        // la derecha con asteriscos
        // donde el número ingresado sea la cantidad máxima de asteriscos dibujados.
        /*
         *      cantidad = 5
         *      *
         *      **
         *      ***
         *      ****
         *      *****
         *      ****   cantidad - 1
         *      ***
         *      **
         *      *
         */

        Scanner s = new Scanner(System.in);
        short cantidad = s.nextShort();
        short contador = 1;

        // Parte creciente de la flecha
        while(contador <= cantidad)
        {
            short subContador = contador;
            while(subContador > 0)
            {
                System.out.print("*");
                subContador--;
            }
            System.out.println();
            contador++;
        }

        // Parte decreciente de la flecha
        contador = (short) (cantidad - 1);
        while(contador > 0)
        {
            short subContador = contador;
            while(subContador > 0)
            {
                System.out.print("*");
                subContador--;
            }
            System.out.println();
            contador--;
        }

        s.close();
    }
   
    

}

