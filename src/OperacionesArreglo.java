import java.util.ArrayList;

public class OperacionesArreglo {

    public static int SumaDeValores(int[] arreglo) {
        int suma = 0;
        for (int valor : arreglo) { 
            suma += valor;
        }
        return suma;
    }


    public static int ValoresUnicos(Object[] arreglo) {
        ArrayList<Object> elementosUnicos = new ArrayList<>();
        for (Object o : arreglo) {
            if (!elementosUnicos.contains(o)) {
                elementosUnicos.add(o);
            }
        }
        return elementosUnicos.size();
    }
}