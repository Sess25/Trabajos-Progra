import java.util.*;
public class Trabajo17 {
    public static void main(String[] args) {
        int [] arreglo = new int[100];
        for (int x = 1 ; x < 101; x++){
            arreglo [x-1] = x;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1 ; i < 101; i++){
            arreglo [i-1] = i;
          arrayList.add(i+100);
        }
     
     ArrayList<Integer> arrayList2 = new ArrayList<>();
     for (int valor : arreglo) {
        arrayList2.add(valor);
    }
    arrayList2.addAll(arrayList);
     System.out.println(Arrays.toString(arreglo));
     System.out.println(arrayList);
     System.out.println(arrayList2);

    }
   




}


    