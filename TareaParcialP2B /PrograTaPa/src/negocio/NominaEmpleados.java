/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Ruldin
 */
public interface NominaEmpleados {
    public void AgregarEmpleado(String nombreArchivo,String nombreEmpleado, double enero, double febrero, double marzo);
    public void TotalesPorMes(String nombreArchivo);
    
    public void listarempleados(String nombreArchivo);
    public void buscarempleados(String nombreArchivo, double can);
    public void InicioArchivo(String nombreArchivo);
    public void mayormenorvendedor(String nombreArchivo);
    public void editardato(String nombreArchivo, String Dato, int registro, int columna );
  
}
