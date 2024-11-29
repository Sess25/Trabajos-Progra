public class Trabajo18 {

    public static void main(String[] args) throws Exception {
        Object[] datos = {
            10.55, true, "Lunes", 5.5f, 45, 'S'
        };
      for (Object o : datos) {
        System.out.println(o.getClass().getSimpleName());
        
      }

        
    }
    
}
