/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

/**
 *
 * @author Gabriela
 */
public enum ExtraRefresco {
    Natural(200),//restarle 100 cuando sea combo
    Gaseosa(350);//restarle 150 cuando sea combo
    
    private double precioRefre;
    
    private ExtraRefresco(double precio){
        precioRefre=precio;
    }

    public double getPrecioRefre() {
        return precioRefre;
    }
    
    
}
