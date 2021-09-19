
import Datos.ClsempleadoJDBC;
import Datos.UsuarioJDBC;
import Dominio.Clsempleado;
import Dominio.Usuario;
import java.sql.*;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author henryflores
 */
public class Principal {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static int op = -1;
 
    
    public static void main(String[] args){
       Usuario usu= new Usuario();
        
        UsuarioJDBC udb= new UsuarioJDBC();
        System.out.println("ingresa tu usuario\n");
        String usr=scanner.nextLine();
        System.out.println("Ingresa tu clave");
        String pwd=scanner.nextLine();
                
        
        usu.setUsername(usr);
        usu.setPassword(pwd);
        
             
         if(udb.select_validacion(usu)){
        try{
            ClsempleadoJDBC em= new ClsempleadoJDBC();
             System.out.println("Ingrese la opcion que desea hacer \n");
        System.out.println("1-- Agregar Empleados\n");
        System.out.println("2-- Mostrar Empleados\n");
        System.out.println("3-- Editar Empleados\n");
        System.out.println("4-- Eliminar Empleados\n");
        System.out.println("0-- Salir");
        op = Integer.parseInt(scanner.nextLine());
        
            
            
switch(op){
    case 1:
        Clsempleado emp= new Clsempleado();
       
        System.out.println("Ingrese El Nombre");
        String nombre= scanner.nextLine();
        emp.setnombre(" "+nombre);
        System.out.println("Ingrese Cantidad de Enero");
        double Enero = scanner.nextDouble();
        emp.setEnero(Enero);
        System.out.println("Ingrese Cantidad de  Febrero");
        double Febrero = scanner.nextDouble();
        emp.setFebrero(Febrero);
        System.out.println("Ingrese Cantidad de Marzo");
        double Marzo = scanner.nextDouble();
        scanner.nextLine();
        emp.setMarzo(Marzo);
        em.insert(emp);
   
        
    break;
    
    case 2:
        //P1();
       ClsempleadoJDBC e = new ClsempleadoJDBC();
        List<Clsempleado> todos = em.empleado();
        
        for(Clsempleado empleado: todos){
            System.out.println("------Empleados------");
            System.out.println(" "+empleado);
        }
    
            
        break;
        
        case 3:
            
            Clsempleado empleados= new Clsempleado();
            System.out.println("Ingrese el codigo del empleado a actualizar");
            int cod=scanner.nextInt();
            scanner.nextLine();
            empleados.setIdEmpleado(cod);
        System.out.println("Ingrese nombre");
        String nombre2= scanner.nextLine();
        empleados.setnombre(" "+nombre2);
        System.out.println("Ingrese Cantidad de Enero");
        double Enero2 = scanner.nextDouble();
        empleados.setEnero(Enero2);
        System.out.println("Ingrese Cantidad de Febrero");
        double Febrero2 = scanner.nextDouble();
        empleados.setFebrero(Febrero2);
        System.out.println("Ingrese  Cantidad de Marzo");
        double Marzo2 = scanner.nextDouble();
        empleados.setMarzo(Marzo2);
        em.actualizar(empleados);
        scanner.nextLine();
        break;
        
        case 4:
            Clsempleado empleb= new Clsempleado();
            System.out.println("Ingrese el codigo del empleado a borrar");
            int codb=scanner.nextInt();
            scanner.nextLine();
            empleb.setIdEmpleado(codb);
            em.borrar(empleb);
        scanner.nextLine();
        break;
        
    }
           System.out.println("\n");
        }catch (Exception e) {
                System.out.println("Error!");
            }
     
    }
    

    

    }

}