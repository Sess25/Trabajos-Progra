import java.util.Scanner;
public class Vocales { 
    public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String texto = scn.next();
    int contadorVocales = contarVocales(texto);
    
    System.out.println("El número de vocales es: " + contadorVocales);
    scn.close();
}

public static int contarVocales(String texto) {
    int contador = 0;
    String vocales = "aeiouAEIOU";
    
    for (int i = 0; i < texto.length(); i++) {
        char c = texto.charAt(i);
        if (vocales.contains(String.valueOf(c))) {
            contador++;
        }
    }
    return contador;
}
}
