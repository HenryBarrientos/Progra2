/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Clsempleado;
import java.sql.*;
import java.util.*;


/**
 *
 * @author henryflores
 */
public class ClsempleadoJDBC {
    private static final String SQL_SELECT="SELECT * FROM empleados";
    private static final String SQL_INSERT="insert into empleados(nombre,Enero,Febrero,Marzo) values(?,?,?,?);";
    private static final String SQL_UPDATE="UPDATE empleados set nombre=?,Enero=?,Febrero=?,Marzo=? where idEmpleados=?";
    private static final String SQL_DELETE="DELETE FROM empleados where idEmpleados=?";
    
    
    
    //Seleccionar info
    
    public List<Clsempleado> empleado(){
        
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Clsempleado empleado =null;
        List<Clsempleado> empleados=new ArrayList<Clsempleado>();
        
        
        
        try {
            con=ClsConexion.getConnection();
            stmt=con.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            while(rs.next()){
                int idempleado= rs.getInt("idempleados");
                String nombre=rs.getString("nombre");
                double Enero=rs.getDouble("Enero");
                double Febrero=rs.getDouble("Febrero");
                double Marzo = rs.getDouble("Marzo");
                
                
                empleado = new Clsempleado();
                empleado.setIdEmpleado(idempleado);
                empleado.setnombre(nombre);
                empleado.setEnero(Enero);
                empleado.setFebrero(Febrero);
                empleado.setMarzo(Marzo);
                empleados.add(empleado);
                
                
                
               
                
            }
            
            
            
            //muestra el MAYOR vendedor de enero
             double MES=0;
            String NomMesEnero=null;
            String NomMinEnero=null;
            double MinEnero=99999.99;
            //febrero
            double MinFebrero=99999.99;
            double MESFEBRERO=0;
            String NomMesFebrero=null;
            String NomMinFebrero=null;
            
            //marzo
            double MinMarzo=99999.99;
            double MESMARZO=0;
            String NomMesMarzo=null;
            String NomMinMarzo=null;
                       
            for(Clsempleado emp : empleados){
                
                if(emp.getEnero()>MES){
                    MES=emp.getEnero();
                    NomMesEnero=emp.getnombre();
                }
                if(emp.getEnero()<MinEnero){
                    MinEnero= emp.getEnero();
                    NomMinEnero=emp.getnombre();
                }
            }
                for(Clsempleado empf : empleados){
                
                if(empf.getFebrero()>MESFEBRERO){
                    MESFEBRERO=empf.getFebrero();
                    NomMesFebrero=empf.getnombre();
                }
                if(empf.getFebrero()<MinFebrero){
                    MinFebrero= empf.getFebrero();
                    NomMinFebrero=empf.getnombre();
                }
                }
                for(Clsempleado empm : empleados){
                
                if(empm.getMarzo()>MESMARZO){
                    MESMARZO=empm.getMarzo();
                    NomMesMarzo=empm.getnombre();
                }
                if(empm.getMarzo()<MinMarzo){
                    MinMarzo= empm.getMarzo();
                    NomMinMarzo=empm.getnombre();
                }
                }
                
            System.out.println("------Vendedor con Mayor cadidad de cada mes-----");       
           System.out.println(" Vendedor Enero: "+NomMesEnero+ " Cantidad Q"+MES); 
           System.out.println(" Vendedor Febrero: "+NomMesFebrero+ " Cantidad Q"+MESFEBRERO); 
           System.out.println(" Vendedor Marzo: "+NomMesMarzo+ " Cantidad Q"+MESMARZO); 
           System.out.println("------Vendedor con menor  cadidad de cada mes------");
           System.out.println(" Vendedor Enero: "+NomMinEnero+  " Cantidad Q"+MinEnero); 
           System.out.println(" Vendedor Febrero: "+NomMinFebrero+ " Cantidad Q"+MinFebrero); 
           System.out.println(" Vendedor Marzo: "+NomMinMarzo+ " Cantidad Q"+MinMarzo); 
           
           
           
           
           
           
           
           
           
            
        } catch (SQLException ex) {
        ex.printStackTrace(System.out);  
        } finally{
            
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(con);
        }
        
        return empleados;
        
    }
    
    public int insert(Clsempleado empleado){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empleado.getnombre());
            stmt.setDouble(2, empleado.getEnero());
            stmt.setDouble(3, empleado.getFebrero());
            stmt.setDouble(4, empleado.getMarzo());
            
         
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        
        return rows;
    }
    
   public int actualizar(Clsempleado empleado){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empleado.getnombre());
            stmt.setDouble(2, empleado.getEnero());
            stmt.setDouble(3, empleado.getFebrero());
            stmt.setDouble(4, empleado.getMarzo());
            stmt.setInt(5, empleado.getIdEmpleado());
            
            System.out.println("ejecutando query:" + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        
        return rows;
    }
   
      public int borrar(Clsempleado empleado){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getIdEmpleado());
            
            System.out.println("ejecutando query:" + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        
        return rows;
    }
   
   public List<Clsempleado> empleadot(){
        
        List<Clsempleado> empleados=new ArrayList<Clsempleado>();
            double MAYOR=0;
            String NOMBREMAYOR=null;
            String NOMBREMES=null;
            double MIN=99999.99;
            for(Clsempleado emp : empleados){
                
                if(emp.getEnero()>MAYOR){
                    MAYOR=emp.getEnero();
                    NOMBREMAYOR=emp.getnombre();
                }
                if(emp.getEnero()<MIN){
                    MIN= emp.getEnero();
                    NOMBREMES=emp.getnombre();
                }
                
                   }
            System.out.println("Mayor Vendedor Enero: "+NOMBREMAYOR+"Cantidad Q"+MAYOR);
            
            return null;
   }
   
}