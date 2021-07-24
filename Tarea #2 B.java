 public class NewClass {

private static Scanner teclado = new Scanner (System.in);
    
    public static void CodigoA(){
    String texto;
    int codigo=0;
    System.out.println("Ingresa un numero");
    texto=teclado.nextLine();
    codigo=Integer.parseInt(texto);
    char caracter=(char)codigo;
    System.out.println("Caracter == "  + caracter);
    }
    
     public static String codificador(String palabra){
         
         int codificar=0;
         String Resultado="";
         int llave=10;
         for ( int x=0;x<palabra.length();x++){
             
          codificar=(int)palabra.charAt(x);
          codificar=codificar+llave;
          char carecter=(char)codificar;
          Resultado = Resultado+carecter;
         }
      return Resultado;
    }
     
     public static String resuelto(String hola ){
         int codificar=0;
         String Resultado="";
         int llave=10;
         for ( int x=0;x<hola.length();x++){
             
          codificar=(int)hola.charAt(x);
          codificar=codificar-llave;
          char carecter=(char)codificar;
          Resultado = Resultado+carecter;
         }
      return Resultado;
     }
      public static void main(String[] arg) {		
		//CodigoA();
               
               String pal;
               String res;
               System.out.println("Ingresa Una Palabra" );
               pal=teclado.nextLine();
               res=codificador(pal);
               System.out.println("Res Palabra = " + res );
               
               String A;
               String B;
               
               System.out.println("ingresa palabra incriptada = " );
               A=teclado.nextLine();
               B=resuelto(A);
               System.out.println("La palabra es : "+B);
	}
}
