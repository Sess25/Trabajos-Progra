public class TablasMultiplicar {
    public static void main(String[] args) {

        int[][] tablas = new int[100][100];

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                tablas[i - 1][j - 1] = i * j;
            }
        }

        System.out.println("Tablas de multiplicar del 1 al 100:");
        for (int i = 1; i <= 100; i++) {
            System.out.println("Tabla del " + i + ":");
            for (int j = 1; j <= 100; j++) {
                System.out.println(i + " x " + j + " = " + tablas[i - 1][j - 1]);
            }
            System.out.println();
    }
}
}