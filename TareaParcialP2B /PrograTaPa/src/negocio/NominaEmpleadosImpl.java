/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.*;
import dominio.MDEmpleado;
import excepciones.*;
import java.util.*;




/**
 *
 * @author henry flores
 */
public class NominaEmpleadosImpl implements NominaEmpleados{
    
    private final AccesoDatos datos;
    
    public NominaEmpleadosImpl(){
        this.datos = new AccesoDatosImpl(); //poner * en el import datos.*
    }
 
    @Override
    public void listarempleados(String nombreArchivo) {
        try {
            List<MDEmpleado> empleados = datos.listar(nombreArchivo);
                 for(MDEmpleado empleado : empleados){
                System.out.println("empleado: "+empleado);
            }
            
            
            
            
            
        } catch (LecturaDatosEx ex) {
         System.out.println("No hay registros por mostrar");
            ex.printStackTrace();
        }
    }

    @Override
    public void buscarempleados(String nombreArchivo, double can) {
        String resultado=null;
        try {
            resultado = datos.buscar(nombreArchivo, can);
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
            System.out.println("No hay registros disponibles");
        }
        System.out.println(" "+resultado);
    }

    @Override
    public void mayormenorvendedor(String nombreArchivo) {
        String Max=null, Min=null;
        double Maxi=0, Mini=99999.99;
        
        try {
            List<MDEmpleado> empleados = datos.listar(nombreArchivo);
            for(MDEmpleado empleado : empleados){
                
                if(empleado.ToTal()>Maxi){
                    Max=empleado.nombre();
                    Maxi=empleado.ToTal();     
                    
                }
                if(empleado.ToTal()<Mini){
                    Min=empleado.nombre();
                    Mini=empleado.ToTal();
                }
                
                
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("No hay registros");
            ex.printStackTrace(System.out);
        }
        System.out.println("El vendedor que mas vendio en los 3 meses fue "+Max+" Con un total de Q"+Maxi);
        System.out.println("El vendedor que menos vendio en los 3 meses fue "+Min+" Con un total de Q"+Mini);  

}

    @Override
    public void editardato(String nombreArchivo, String Dato, int registro, int columna) {
try {
            List<MDEmpleado> empleados = datos.listar(nombreArchivo);
            String nombre = empleados.get(registro).nombre();
            Double enero = empleados.get(registro).enero();
            Double febrero = empleados.get(registro).febrero();
            Double marzo = empleados.get(registro).marzo();
            switch (columna) {
                case 1:
                    nombre = Dato;
                    break;
                case 2:
                    enero = Double.parseDouble(Dato);
                    break;
                case 3:
                    febrero = Double.parseDouble(Dato);
                    break;
                case 4:
                    marzo = Double.parseDouble(Dato);
                    break;
                default:
                    System.out.println("Columna no valida");
                    break;
            }
            MDEmpleado empleado = new MDEmpleado(nombre, enero, febrero, marzo);
            empleados.set(registro, empleado);
            boolean anexar = false;
            for (MDEmpleado linea : empleados) {
                datos.escribir(linea, nombreArchivo, anexar);
                anexar = datos.existe(nombreArchivo);
            }  
        } catch (LecturaDatosEx ex) {
            System.out.println("errorLectura");
            ex.printStackTrace(System.out);
        } catch (EscrituraDatosEx ex) {
            System.out.println("errorEscritura");
            ex.printStackTrace(System.out);
        } catch (AccesoDatosEx ex) {
            System.out.println("errorAcceso");
            ex.printStackTrace(System.out);
        } catch (NumberFormatException ex) {
            System.out.println("Error de formato");
            ex.printStackTrace(System.out);
        }
    }

   
    @Override
    public void AgregarEmpleado(String nombreArchivo, String nombreEmpleado, double enero, double febrero, double marzo) {
    MDEmpleado empleados = new MDEmpleado(nombreEmpleado, enero, febrero, marzo);
        boolean anexar = false;
        try{
            anexar = datos.existe(nombreArchivo);
            datos.escribir(empleados, nombreArchivo, anexar);
            System.out.println("Se ha registrado");
        }
        catch(AccesoDatosEx ex){
            System.out.println("Error");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void TotalesPorMes(String nombreArchivo) {
         try {
             //Enero
            double mayor=0;
            String NomMayor=null;
            double menor=99999.99;
            String NomMenor=null;
            List<MDEmpleado> empleados = datos.listar(nombreArchivo);
            
            for(MDEmpleado empleado : empleados){
                
                if(empleado.enero()>mayor){
                    mayor=empleado.enero();
                    NomMayor=empleado.nombre();
                }
                if(empleado.enero()<menor){
                    menor= empleado.enero();
                    NomMenor=empleado.nombre();
                }
                
                   }
            //Febrero
            double mayorf=0;
            String NomMayorf=null;
            double menorf=99999.99;
            String NomMenorf=null;
            List<MDEmpleado> empleadosF = datos.listar(nombreArchivo);
            for(MDEmpleado empleado : empleados){
                
                if(empleado.febrero()>mayorf){
                    mayorf=empleado.febrero();
                    NomMayorf=empleado.nombre();
                }
                if(empleado.febrero()<menorf){
                    menorf= empleado.febrero();
                    NomMenorf=empleado.nombre();
                }
                
                   }
            
            //Marzo 
             double mayorm=0;
            String NomMayorm=null;
            double menorm=99999.99;
            String NomMenorm=null;
            List<MDEmpleado> empleadosM = datos.listar(nombreArchivo);
            for(MDEmpleado empleado : empleados){
                
                if(empleado.marzo()>mayorm){
                    mayorm=empleado.marzo();
                    NomMayorm=empleado.nombre();
                }
                if(empleado.marzo()<menorm){
                    menorm= empleado.marzo();
                    NomMenorm=empleado.nombre();
                }
                
                   }
            
            
         System.out.println("la pesona que mas vendio en enero fue "+NomMayor+" con un total de "+mayor);
         System.out.println("la pesona que menos vendio en enero fue "+NomMenor+" con un total de "+menor);   
         System.out.println("la pesona que mas vendio en febrero fue "+NomMayorf+" con un total de "+mayorf);
         System.out.println("la pesona que menos vendio en febrero fue "+NomMenorf+" con un total de "+menorf);
         System.out.println("la pesona que mas vendio en marzo fue "+NomMayorm+" con un total de "+mayorm);
         System.out.println("la pesona que menos vendio en marzo fue "+NomMenorm+" con un total de "+menorm);
         
         
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void InicioArchivo(String nombreArchivo) {
        try {
            if(datos.existe(nombreArchivo)){
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            } else {
                //crearmos archivo
                datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    
}