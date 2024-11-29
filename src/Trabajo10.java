public class Trabajo10 {

    public static int sumar(int num1, int num2){
        return num1 + num2;
    }
    public static int sumar(int num1, int num2, int num3){
        return num1 + num2 + num3;
    }
    public static int sumar(int num1, int num2, int num3, int num4){
        return num1 + num2 + num3 + num4;
    }


public static void main(String[] args) {
    
    System.out.println(sumar(5,6));
    System.out.println(sumar(5,6,7));
    System.out.println(sumar(5,6,7,8));
}
}
