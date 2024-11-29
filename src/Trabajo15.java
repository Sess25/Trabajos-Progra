import java.util. Random;
public class Trabajo15 {

    public static int Numazar(){
    Random random = new Random ();
    int NumAle = random.nextInt(500,1001);
    return NumAle;
}
public static void burbuja(int[] arreglo) {
    int n = arreglo.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arreglo[j] > arreglo[j + 1]) {
             
                int temp = arreglo[j];
                arreglo[j] = arreglo[j + 1];
                arreglo[j + 1] = temp;
            }
        }
    }
}   
public static void main(String[] args) {
    int[] arreglo = new int[100]; 

     for (int x = 0; x < arreglo.length; x++) {
        arreglo[x] = Numazar(); 
    }

    System.out.println("Arreglo antes de ordenar:");
    for (int x = 0; x < arreglo.length; x++) {
        System.out.print(arreglo[x] + " ");
    }

    burbuja(arreglo);

    System.out.println("\n\nArreglo después de ordenar:");
    for (int x = 0; x < arreglo.length; x++) {
        System.out.print(arreglo[x] + " ");
    }
}
}

  
