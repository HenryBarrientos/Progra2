/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.MDEmpleado;
import excepciones.*;
import java.util.*;

/**
 *
 * @author henry flores
 */
public interface AccesoDatos {
    
    boolean existe(String nombreArchivo) throws AccesoDatosEx;
    public List<MDEmpleado> listar(String nombreArchivo) throws LecturaDatosEx;
    void escribir(MDEmpleado pelicula, String nombreArchivo,boolean anexar) throws EscrituraDatosEx;
    public String buscar(String nombreArchivo, double can) throws LecturaDatosEx;
    public void crear(String nombreArcivo) throws AccesoDatosEx;
    public void borrar(String nombreArchivo) throws AccesoDatosEx;
    
    
}
