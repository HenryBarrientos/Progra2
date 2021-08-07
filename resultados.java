/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resultados;

import Materiales.Clsmateriales;

/**
 *
 * @author henryflores
 */
public class Clsresultados {
    
private static String[][] producto = new String [4][8];
    
    private static final int MATERIAL = 0;
    private static final int UNIDADES = 1;
    private static final int VALOR = 3;
    private static final int GASTO = 4;
    private static final int PESO = 2;
    private static final int GASTOP = 5;
    private static final int COSTO = 6;
    private static final int COSTOT = 7;
    
    private static final int SEGURO = 3500;
    private static final int FLETES = 2500;
    private static final int IMPUESTOS = 5000;
    
    private static final int ACARREO = 5000;
    private static final int COMISIONES = 200;
    
    private static final int TOTALVALOR = SEGURO+ IMPUESTOS + COMISIONES;
    private static final int TOTALPESO = FLETES + ACARREO;
    
    private int fila = 0;
   
    
    private final int FILAS = 4;
    private final int COLUMNAS = 8;
    private double Co = 0;
    private double CA= 0;
    
    private int totalF = 0;
    
    public Clsresultados(int filas){
        if (filas > FILAS){
            throw(new IllegalArgumentException());
        }else{
            totalF = filas;
            producto= new String[totalF][COLUMNAS];
        }
    }
    public static void imprimirDecorado(){
        for (int x=0; x<producto.length; x++){
            System.out.print("|");
            for(int y=0; y<producto[x].length; y++){
                System.out.print(producto[x][y]);
                if(y!=producto[x].length-1){
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    }
    public String AddMaterial(Clsmateriales mat){
        if (fila >= FILAS){
            return "LLEGO AL TOPE";
        }else{
            producto[fila][MATERIAL] = mat.getMaterial();
            producto[fila][UNIDADES] = mat.getNo_unidades()+"";
            producto[fila][VALOR] = mat.getVal_factura()+"";
            producto[fila][PESO] = mat.getPeso()+"";
            fila ++;
        }
        return "OK!";
    }
    
    public double Peso(){
        double total = 1;
        double TotalP = 0;
         
        for (int x = 0; x < FILAS; x++){
             for (int y = 2; y < 3; y++){
             String fil = producto[x][y];
             total = Double.parseDouble(producto[x][1]);
             total = total*Double.parseDouble(fil);
             TotalP = TotalP + total;
         }
        }
        CA = TOTALPESO/TotalP;
        return TotalP;
    }
    public double Valor(){
         double total = 1;
         double TotalM = 0;
         
        for (int x = 0; x < FILAS; x++){
             for (int y = 3; y < 4; y++){
             String fil = producto[x][y];
             total = Double.parseDouble(producto[x][1]);
             total = total*Double.parseDouble(fil);
             TotalM = TotalM + total;
         }
        }
        CA = TOTALVALOR/TotalM;
        return TotalM;
     }
    public double GastoValor(){
        double total = 0;
        for (int y = 0; y < FILAS; y++){
            total = Double.parseDouble(producto[y][VALOR])*Co;
            producto[y][GASTO] = total+"";
        }
        return total;
    }
    public double GastoPeso(){
       double total = 0;
        for (int y = 0; y < FILAS; y++){
            total = Double.parseDouble(producto[y][PESO])*CA;
            producto[y][GASTOP] = total+"";
        }
        return total;
    }
    
    public double Suma(){
        double total = 0;
        for (int y = 0; y < FILAS; y++){
            for (int x = 3; x < COSTO; x++){
                total = total + Double.parseDouble(producto[y][x]);
            }
            producto[y][COSTO] = total+"";
            total = 0;
        }
        return total;
    }
    public double Costo(){
        double total = 0;
        double RESULTADO = 0;
        for (int y = 0; y < FILAS; y++){
            total = Double.parseDouble(producto[y][COSTO])*Double.parseDouble(producto[y][UNIDADES]);
            producto[y][COSTOT] = total+"";
            RESULTADO = total + RESULTADO;
        }
        System.out.println("EL TOTAL ES "+RESULTADO);
        return total;
    }
    
}
