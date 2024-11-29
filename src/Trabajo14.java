public class Trabajo14 {

    public static void main(String[] args) {
        
        int [] arreglo = new int[100];
        final int constante = 1000;
        for(int x = 0 ;  x < arreglo.length ; x++){
            arreglo[x] = x + constante;
        }
        for(int x = 99 ; x >= 0 ; x--){
            System.out.println(arreglo [x]);

        }
    
}
}