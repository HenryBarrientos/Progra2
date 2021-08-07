/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materiales;

import java.util.Scanner;

/**
 *
 * @author henryflores
 */
public class Clsmateriales {
     private String A;
    private double B;
    private int C;
    private double D;
    
    
     public static void llenaInformacion(){
        Scanner t = new Scanner(System.in);
        
        
    }

    /**
     * @param Material the Material to set
     */
    public void setMaterial(String Material) {
        this.A = Material;
    }

    /**
     * @param Val_factura the Val_factura to set
     */
    public void setvalor(double Val_factura) {
        this.B = Val_factura;
    }

    /**
     * @param No_unidades the No_unidades to set
     */
    public void setunidades(int No_unidades) {
        this.C = No_unidades;
    }

    /**
     * @return the Material
     */
    public String getMaterial() {
        return A;
    }

    /**
     * @return the Val_factura
     */
    public double getVal_factura() {
        return B;
    }

    /**
     * @return the No_unidades
     */
    public int getNo_unidades() {
        return C;
    }

    /**
     * @return the Peso
     */
    public double getPeso() {
        return D;
    }

    /**
     * @param Peso the Peso to set
     */
    public void setpeso(double Peso) {
        this.D = Peso;
    }
}
