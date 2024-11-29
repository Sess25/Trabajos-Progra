public class PruebaModulos {

    public static void main(String[] args) {
        int[] arregloEnteros = {1, 2, 3, 4, 5};
        int suma = Prueba2.sumaValores(arregloEnteros);
        System.out.println("Suma de valores: " + suma);

        Object[] arregloObjetos = {1, "a", 2, "a", 3, 1, 4};
        int valoresUnicos = Prueba2.valoresUnicos(arregloObjetos);
        System.out.println("Valores únicos: " + valoresUnicos);
    }
}
