/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleados;

import java.util.*;
import negocio.NominaEmpleadosImpl;
import negocio.NominaEmpleados;

/**
 *
 * @author henry flores
 */
public class ClsPrincipal {

    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo = "Users\\henryflores\\Documentos\\Progra2bb\\lll.txt";
    private static final NominaEmpleados empleados = new NominaEmpleadosImpl();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Mientras la opcion elegida sea 0, preguntamos al usuario
        while (opcion != 0) {
            try {
                System.out.println("Elige opcion:\n1.- Iniciar Listado de empleados"
                        + "\n2.- Agregar Empleado\n"
                        + "3.- Listar Empleados\n"
                        + "4.- Buscar Cantidad \n"
                        + "5.- Totales Del Mes\n"
                        + "6.- Mayor y menor vendedor\n"
                        + "7.- Editar datos\n"
                        + "8.- Salir");

                opcion = Integer.parseInt(scanner.nextLine());

                //Ejemplo de switch case en Java
                switch (opcion) {
                    case 1:
                        //1. Creamos el objeto que administra el catalogo de personas
                        //La creacion del archivo es opcional, de todas maneras se creara 
                        //al escribir por primera vez en el archivo
                        empleados.InicioArchivo(nombreArchivo);
                        break;
                    case 2:
                        //2. agregar informacion archivo
                        System.out.println("Introduce el nombre de un empleado a agregar:");
                        String nombre = scanner.nextLine();
                        System.out.println("Introduce el Total de enero");
                        double enero = scanner.nextDouble();
                        System.out.println("Introduce el Total de febrero");
                        double febrero = scanner.nextDouble();
                        System.out.println("Introduce el Total de Marzo");
                        double marzo = scanner.nextDouble();
                        empleados.AgregarEmpleado(nombreArchivo, nombre, enero, febrero, marzo);
                        scanner.nextLine();
                        break;
                    case 3:
                        //3. listar catalogo completo
                        empleados.listarempleados(nombreArchivo);
                        break;
                    case 4:
                        //4. Buscar pelicula
                        System.out.println("Introduce la cantidad a buscar:");
                        double cant = scanner.nextDouble();
                        scanner.nextLine();
                        empleados.buscarempleados(nombreArchivo, cant);
                        break;
                    case 5:
                        empleados.TotalesPorMes(nombreArchivo);
                        break;
                    case 6:
                        empleados.mayormenorvendedor(nombreArchivo);
                        break;
                    case 7:
                       System.out.println("Ingrese el numero de registro: ");
                        int registro = Integer.parseInt(scanner.nextLine());
                        System.out.println("Elija el dato que desea editar: "
                                + "\n1.Nombre\n 2.Enero \n3.Febrero \n4.Marzo");
                        int columna = Integer.parseInt(scanner.nextLine());
                        System.out.println("Ingrese el nuevo dato: ");
                        String nuevoDato = scanner.nextLine();
                        empleados.editardato(nombreArchivo, nuevoDato, registro, columna);
                        break;
                        
                    case 8:
                        System.out.println("!Hasta pronto!");
                        break;
                   
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }

    }
}
