import java. util. Random;
import java.util.Scanner;
public class Trabajo2 {
    public static void main(String[] args) {
        
Random random = new Random();
Scanner sn = new Scanner (System.in);   
int NumAle = random.nextInt(100) +1;
int intentos = 10;
System.out.println("Adivine el numero secreto entre 1 y 100 en 10 intentos o menos");
while (intentos>0){
    System.out.println("Ingrese un numero");
    int num = sn.nextInt(); //smn
    if (num == NumAle) {
        System.out.println("Bien hecho!");
        break;
    } else if (num<NumAle){
        System.out.println("Vuelve a intentarlo, el numero secreto es mayor");

    } else {
        System.out.println("Vuelve a intetnarlo. El numero secreto es menor");
    
    }
    intentos --;
    System.out.println("Te quedan " + intentos + " intentos");
    if (intentos<=0){
        System.out.println("Mejor suerte a la proxima. El numero secreto era " + NumAle);
    }
    }
    sn.close();
    }
}
