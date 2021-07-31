public class NewClass {
    
    private static String [][] comisiones= new String [4][6];
    //final es para declarar constantes
    private static final int NOMBRE=0;
    private static final int ENERO=1;
    private static final int FEBRERO=2;
    private static final int MARZO=3;
    private static final int TOTAL=4;
    private static final int PROMEDIO=5;
    
     //metodo que carga informacion
    private static void cargar(int fila){
    Scanner t= new Scanner(System.in);
    
    System.out.println("Ingrese nombre 1"+(fila+1));
    comisiones[fila][NOMBRE]=t.nextLine();
    System.out.println("Ingrese ENERO 1");
    comisiones[fila][ENERO]=t.nextLine();
    System.out.println("Ingrese FEBRERO 1");
    comisiones[fila][FEBRERO]=t.nextLine();
    System.out.println("Ingrese MARZO 1");
    comisiones[fila][MARZO]=t.nextLine();
    
    int A=Integer.parseInt(comisiones[fila][ENERO]);
    int b=Integer.parseInt(comisiones[fila][FEBRERO]);
     int c=Integer.parseInt(comisiones[fila][MARZO]);
    
     
  int suma=A+b+c;
  int promedio=suma/3;
  int s=suma;
     String sa=Integer.toString(s);
     String re=Integer.toString(promedio);
     comisiones[fila][TOTAL]=sa;
     comisiones[fila][PROMEDIO]=re;   
    
     
      
      
        
    }
    
    public static void imprimirDecorado(String[][] ma){
       for (int x = 0; x < ma.length; x++) {
            System.out.print("|");
            for (int y = 0; y < ma[x].length; y++) {
                System.out.print(ma[x][y]);
                if (y != ma[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
   }
    
    public static void main(String[] args){
        for(int i=0 ; i<3;i++    ){
          cargar(i);
      }
       imprimirDecorado(comisiones);
 
    }

}
