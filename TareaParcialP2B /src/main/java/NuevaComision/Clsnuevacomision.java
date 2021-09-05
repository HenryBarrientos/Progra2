/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevaComision;

import java.util.*;
import modelos.mdvendedor;

/**
 *
 * @author henryflores
 */
public class Clsnuevacomision {
public List<mdvendedor>todos = new ArrayList<mdvendedor>();
 Scanner t = new Scanner(System.in);
 



private mdvendedor ingreso_info(){
    mdvendedor vende = new mdvendedor();
    System.out.println("ingrese el nombre ");
    vende.nombre=t.nextLine();
    System.out.println("Enero ");
    vende.enero=t.nextDouble();
    System.out.println("Febrero ");
    vende.febrero=t.nextDouble();
    System.out.println("marzo ");
    vende.marzo=t.nextDouble();
    todos.add(vende);
    return vende;
               
}
 private void desplegardatos(){
  
     for(mdvendedor ele: todos){
         System.out.println("nombre ="+ele.nombre);
         
         System.out.println("Enero ="+ele.enero);
         
         System.out.println("Febrero ="+ele.febrero);
         
         System.out.println("Marzo ="+ele.marzo);
         
      
          ele.sumaventas=ele.enero+ele.febrero+ele.marzo;
          System.out.println("Total de ventas Q"+ele.sumaventas);
          
          ele.promedio=(ele.enero+ele.febrero+ele.marzo)/3;
          System.out.println("EL promedio de ventas de "+ele.nombre+" es de Q"+ele.promedio);
          
         
          
      
         System.out.println("-----------------");
         
      
     
    
    
      }
 }
 
 private void enero(){
     
     double MinEnero=0;
     double MaxEnero=0;
     String NomEnero=null;
     String NomEneroM=null;
     double TotalEnero=0;
     double PromedioEnero;
     
 for(mdvendedor vende: todos){
    
               
                if (vende.enero>MaxEnero) {
                       MaxEnero=vende.enero;
                       NomEneroM=vende.nombre;
                      
                       
                   }
             if (vende.enero<MaxEnero) {
                       MinEnero=vende.enero;
                       NomEnero=vende.nombre;
                      
                       
                   }
 }
 
 
   
 for(int i=0;i<todos.size();i++){
             
   TotalEnero= todos.get(i).enero+TotalEnero;
      }
     
         PromedioEnero=TotalEnero/todos.size();
     System.out.println("El total de ventas de enero es de "+TotalEnero);
     System.out.println("El promedio de ventas de enero es de "+PromedioEnero);
     System.out.println("La persona que mas vendio fue  "+NomEneroM+" con un total de Q"+MaxEnero);
     System.out.println("La persona que menos vendio fue  "+NomEnero+" con un total de Q"+MinEnero);
     
    
 }
 
  private void febrero(){
  double TotalFebrero=0;
  double PromedioFebrero;
  double MaxFebrero=0;
  double Minfebrero=0;
  String NombreFebrero=null;
  String NombreFebreroM=null;
  
  
  for(mdvendedor vende: todos){
    
               
                if (vende.febrero>MaxFebrero) {
                       MaxFebrero=vende.febrero;
                       NombreFebrero=vende.nombre;
                      
                       
                   }
             if (vende.febrero<MaxFebrero) {
                       Minfebrero=vende.febrero;
                       NombreFebreroM=vende.nombre;
                      
                       
                   }
 }
  
  
  
  
  
     for(int i=0;i<todos.size();i++){
             
             
       TotalFebrero= todos.get(i).febrero+TotalFebrero;
     }
     PromedioFebrero=TotalFebrero/todos.size();
     System.out.println("El total de ventas de febrero es de "+TotalFebrero);
     System.out.println("El promedio de ventas de febrero es de "+PromedioFebrero);
     System.out.println("La persona que mas vendio fue  "+NombreFebrero+" con un total de Q"+MaxFebrero);
     System.out.println("La persona que menos vendio fue  "+NombreFebreroM+" con un total de Q"+Minfebrero);
     
     
 }
  
   private void marzo(){
  double TotalMarzo=0;
  double PromedioMarzo;
   double MaxMarzo=0;
   double MinMarzo=0;
  String NombreMarzo=null; 
  String NombreMarzoM=null;
  
  
  for(mdvendedor vende: todos){
    
               
                if (vende.marzo>MaxMarzo) {
                       MaxMarzo=vende.marzo;
                       NombreMarzo=vende.nombre;
                      
                       
                   }
             if (vende.marzo<MaxMarzo) {
                       MinMarzo=vende.marzo;
                       NombreMarzoM=vende.nombre;
                      
                       
                   }
 }
  
  
  
  
  
  
  
  
  
  
  
     for(int i=0;i<todos.size();i++){
             
             
       TotalMarzo= todos.get(i).marzo+TotalMarzo;
     }
     PromedioMarzo=TotalMarzo/todos.size();
     System.out.println("El total de ventas de marzo es de "+TotalMarzo);
     System.out.println("El promedio de ventas de marzo es de "+PromedioMarzo);
     System.out.println("La persona que mas vendio fue  "+NombreMarzo+" con un total de Q"+MaxMarzo);
     System.out.println("La persona que menos vendio en marzo fue  "+NombreMarzoM+" con un total de Q"+MinMarzo);
 }
            
 
 
 

private void unidadprueba(String nom, double ene, double feb, double mar){
         mdvendedor vende = new mdvendedor();
         vende.nombre=nom;
         vende.enero=ene;
         vende.febrero=feb;
         vende.marzo=mar;
         todos.add(vende);
         
     } 



    
    
    
    
    
    
    
    

    public void menu(){
         String opc=" ";
         
         do{
             System.out.println("1-Ingresar datos");
             System.out.println("2-Mostrar datos ingresados");
             System.out.println("3-Mostrar totales del mes Enero");
             System.out.println("4-Mostrar totales del mes Febrero");
             System.out.println("5-Mostrar totales del mes Marzo");
             System.out.println("6 SALIR");
             opc=t.nextLine();
             
             switch(opc){
                 case "1": ingreso_info();
                 break;
                 case "2": desplegardatos();
                 break;
                 case "3": enero();
                 break;
                 case "4": febrero();
                 break;
                 case "5": marzo();
                 
             }
             
             
             
         }while(!opc.equals("6"));
           
    }
}
