/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;

import Materiales.Clsmateriales;
import Resultados.Clsresultados;

/**
 *
 * @author henryflores
 */
public class ClsPrincipio {
     public static void main(String[] args) {
        Clsmateriales P = new Clsmateriales();
        Clsresultados ma = new Clsresultados(4);
        
        P.setMaterial("Cemento");
        P.setunidades(50);
        P.setvalor(60);
        P.setpeso(50);
        ma.AddMaterial(P);
        
        P.setMaterial("Bolsa");
        P.setunidades(150);
        P.setvalor(40);
        P.setpeso(20);
        ma.AddMaterial(P);
        
        P.setMaterial("Tubos");
        P.setunidades(200);
        P.setvalor(55);
        P.setpeso(10);
        ma.AddMaterial(P);
        
        P.setMaterial("Hierro");
        P.setunidades(50);
        P.setvalor(350);
        P.setpeso(50);
        ma.AddMaterial(P);
        System.out.println("=========== Imprime matrix ===========");
        
        ma.imprimirDecorado();
        ma.Valor();
        ma.Peso();
        ma.GastoValor();
        ma.GastoPeso();
        ma.Suma();
        ma.Costo();
        System.out.println("=========== Imprime matrix ===========");
        ma.imprimirDecorado();
    }
    
}