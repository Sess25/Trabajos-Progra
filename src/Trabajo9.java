import java.util.Scanner;
public class Trabajo9 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        byte mes;
        
        do{
            System.out.println("Escribe un numero entre el 1 y el 12");
            mes = scan.nextByte();

        }while (mes<1 || mes>12 );

        switch (mes) {
            case 1:
                
                break;
        
            default:
                break;
        }
        scan.close();
    }
   
}
