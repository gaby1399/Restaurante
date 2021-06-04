/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Gabriela
 */
public class Pago implements Serializable{
    private double montoPago;

   
    public Pago(double montoPago) {
        this.montoPago = montoPago;
    }
    
    public String letraMonto(){
         String unidad[]= {" "," uno "," dos "," tres "," cuatro "," cinco ","seis ","siete ","ocho ","nueve "};
          String decena[]= {" "," diez"," veite"," treinta "," cuarenta "," cincuenta "," sesenta "," setenta "," ochenta "," noventa "};
            //centenas: cientos 
            // mil,
           int monto = (int) montoPago;
          String pago = String.valueOf(monto);
          String palabra = " ";
          Stack pila= new Stack();
          int cont=1;
          int num;
        for (int i = pago.length()-1; i >=0; i--) {
            num=monto%10;
            if(cont==pago.length()&&cont>3){
                pila.push("mil");
           }
            if(cont==1||cont==4){
                if(num==0||pago.length()==4){
                 pila.push(unidad[num]);
                }else{
                    pila.push(" y "+unidad[num]);
                }
            }else{
               if(cont==2||cont==5){
                  pila.push(decena[num]);
               
               } else{
                    pila.push(unidad[num]+"cientos");
                 }
             }
           
            cont++;
            monto/=10;
          }
           while(!pila.isEmpty()){
               palabra+=pila.pop();
           }
           palabra=palabra.replaceAll("uno cientos", "cien");
           palabra=palabra.replaceAll("siete cientos", " setecientos ");
           palabra=palabra.replaceAll("nueve cientos", " novecientos ");
           palabra=palabra.replaceAll("cinco cientos", " quinientos ");
           palabra=palabra.replaceAll("diez uno", " once ");
           palabra=palabra.replaceAll("diez dos", " doce ");
           palabra=palabra.replaceAll("diez tres", " trece ");
           palabra=palabra.replaceAll("diez cuatro", " catorce ");
           palabra=palabra.replaceAll("diez cinco", " quince ");
            palabra=palabra.replaceAll("diez", " dieci");
           palabra=palabra.replaceAll("uno mil", " mil ");        
          return palabra + " colones ";          
          }
    
        
          
    

    @Override
    public String toString() {
        return "\nPago:\n" + "\nMonto Pago: " + montoPago;
    }

    public double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(double montoPago) {
        this.montoPago = montoPago;
    }
      
      
}
