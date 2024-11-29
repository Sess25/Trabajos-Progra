import java.util.Arrays;

public class Burbuja {

    public static void main(String[] args) {
        int[] arreglo = {4, 8 ,5, 1};
        System.out.println("Antes de ordenar: " + Arrays.toString(arreglo));

        int temp;
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) { 
                if (arreglo[j] > arreglo[j + 1]) {

                    temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }

        System.out.println("Después de ordenar: " + Arrays.toString(arreglo));
    }
}
