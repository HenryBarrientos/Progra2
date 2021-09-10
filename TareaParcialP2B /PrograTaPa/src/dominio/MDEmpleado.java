/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;



/**
 *
 * @author henry flores
 */
public class MDEmpleado {
  String Nombre;
  double enero;
  double febrero;
  double marzo;
  double ToTal;
  double Promedio;
 
  public MDEmpleado(String Nombre, double enero, double febrero, double marzo){
      
      this.Nombre=Nombre;
      this.enero=enero;
      this.febrero=febrero;
      this.marzo=marzo;
      this.ToTal=enero+febrero+marzo;
      this.Promedio=this.ToTal/3;
    
  }
  @Override
    public String toString(){
        return this.nombre()+ "|" + this.enero()+ "|" 
            + this.febrero()+ "|" + this.marzo()+ "|" 
              + this.ToTal()+ "|"+ this.promedio();
    }
  
  
  public String nombre(){
    
     return Nombre;
}
  public double enero(){
      return enero;
  }
  
  public double febrero(){
      return febrero;
  }
  
  public double marzo(){
      return marzo;
  }
  
  public double ToTal(){
      return ToTal;
  }
  public double promedio(){
      return Promedio;
  }
   
      
  }

