package Aplicacion;

import Modulo.Leer;

public class App2 {
    public static void main(String[] args) {
        Leer leer = new Leer();
        String texto = leer.LeerTexto();
        System.out.println("Escribiste " + texto);
        int numero = leer.LeerNumeroEntero();
        System.out.println("Escribiste " + numero);



    }
}
