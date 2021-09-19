/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Usuario;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henryflores
 */
public class UsuarioJDBC {
    private static final String SQL_Select= "Select * from usuario";
    private static final String SQL_Update= "update usuario set username=?,password=? where id_usuario=?";
    private static final String SQL_Insert= "insert into usuario(username,password) values(?,?)";
    private static final String SQL_Delete= "delete from usuario where id_usuario=?";
  
    public List<Usuario>select(){

Connection conexion=null;
PreparedStatement stmt= null;
ResultSet rs =null;
Usuario usuario = null;
 List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            conexion=ClsConexion.getConnection();
            stmt= conexion.prepareStatement(SQL_Select);
            rs=stmt.executeQuery();
            
            while(rs.next()){
                
                int id_usuario=rs.getInt("id_usuario");
                String username=rs.getString("username");
                String password=rs.getString("password");
                
                
                usuario=new Usuario();
                usuario.setUsername(username);
                usuario.setPassword(password);
                usuario.setId_usuario(id_usuario);
                
                usuarios.add(usuario);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClsConexion.close(conexion);
            ClsConexion.close(stmt);
            ClsConexion.close(rs);
        }



return usuarios;


}
    
     public boolean select_validacion(Usuario datos){

Connection conexion=null;
PreparedStatement stmt= null;
ResultSet rs =null;
Usuario usuario = new Usuario();
boolean tiene_permiso= false;
 

        try {
            String Condicion= SQL_Select+" where username ='"+datos.getUsername()+""+"' and password='"+datos.getPassword()+"'";
            conexion=ClsConexion.getConnection();
            stmt=conexion.prepareStatement(Condicion);
            rs=stmt.executeQuery();
            System.out.println("Condicion="+Condicion);
            
            while(rs.next()){
                tiene_permiso= true;
                int id_usuario=rs.getInt("id_usuario");
                String username=rs.getString("username");
                String password=rs.getString("password");
                
              
                
               
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClsConexion.close(conexion);
            ClsConexion.close(stmt);
            ClsConexion.close(rs);
        }



return tiene_permiso;


}
    
    public int insert(Usuario usuario){
        Connection conexion= null;
        PreparedStatement stmt=null;
        int rows=0;
        try {
            conexion= ClsConexion.getConnection();
            stmt=conexion.prepareStatement(SQL_Insert);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            System.out.println("Ejecutando query="+SQL_Insert);
            
            rows=stmt.executeUpdate();
            System.out.println("Se procesaron "+rows);
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
       finally{
            ClsConexion.close(conexion);
            ClsConexion.close(stmt);
        }
        return rows;
    }
    
    
}
