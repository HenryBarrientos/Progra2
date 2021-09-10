/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.MDEmpleado;
import excepciones.*;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.io.*;

import java.util.*;

/**
 *
 * @author henry flores
 */
public class AccesoDatosImpl implements AccesoDatos{
    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }
    
    @Override
    public List<MDEmpleado> listar(String nombreArchivo) throws LecturaDatosEx {
          List<MDEmpleado> empleados = new ArrayList();
        try {
           BufferedReader entrada = null; 
            File archivo = new File(nombreArchivo);
           
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null){
                String[] empDatos = linea.split("\\|");
                MDEmpleado empleado = new MDEmpleado(empDatos[0], Double.valueOf(empDatos[1]), 
                                    Double.valueOf(empDatos[2]), Double.valueOf(empDatos[3]));
                empleados.add(empleado);
                linea = entrada.readLine();
            }   
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) { 
            ex.printStackTrace(System.out);
        }
        return empleados;
    }
    
    
    @Override
    public void escribir(MDEmpleado pelicula, String nombreArchivo,boolean anexar) throws EscrituraDatosEx{
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito el registro en el archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }
    
    
   
   

public void crear(String nombreArchivo){
    PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
          } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
}
   
@Override
public void borrar(String nombreArchivo) throws AccesoDatosEx{
    File archivo = new File(nombreArchivo);
    archivo.delete();
    System.out.println("Se ha borrado el archivo");
}
 
    @Override
    public String buscar(String nombreArchivo, double can) throws LecturaDatosEx {
   BufferedReader entrada = null;
        String resultado = null;
        try {
            File archivo = new File(nombreArchivo);
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i=1;
            linea = entrada.readLine();
            while (linea != null){
                String empDatos[] = linea.split("\\|");
                for(String dato : empDatos){
                    if(can != 0 && String.valueOf(can).equals(dato)){
                        resultado = linea + " encontrada en el indice " + i;
                        break;
                    }
                }
                linea = entrada.readLine();
                i++;
            } 
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return resultado;
    
    }
}
    

