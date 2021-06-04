/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import java.io.Serializable;
import java.util.Stack;

/**
 *
 * @author Gabriela
 */
public class Credito extends Pago implements Serializable{
    private String tipoTarjeta;
    private String numTarjeta;
    private final double DESCUENTO=0.25;
    public Credito(String tipoTarjeta, String numTarjeta, double montoPago) {
        super(montoPago);
        this.tipoTarjeta = tipoTarjeta;
        this.numTarjeta = numTarjeta;
    }

    public double descuento(){
        return (tipoTarjeta=="Visa")?getMontoPago()*DESCUENTO:0;
    }
    
    public double montoFinal(){
        return getMontoPago()-descuento();
    }
    
    public boolean validarTarjeta(){
        int resultado=Character.getNumericValue(numTarjeta.charAt(numTarjeta.length()-1));
       Stack pila= new Stack();
        int suma=0;
       
        for (int i = numTarjeta.length()-2; i >=0  ;i--) {
            if(i%2==0){
                int dig=Character.getNumericValue(numTarjeta.charAt(i));
                int mult=dig*2;
              String valor=String.valueOf(mult);
               if(valor.length()==2){
                  int sumaV=0;
                  sumaV+=Character.getNumericValue(valor.charAt(0))+Character.getNumericValue(valor.charAt(1));
                  pila.push(sumaV);
                }else{
                    int dato=Integer.parseInt(valor);
                    pila.push(dato);
               }
             }else{
                 pila.push(Character.getNumericValue(numTarjeta.charAt(i)));
            }
          } 
   
        while(!pila.empty()){  
             int num=(int) pila.pop();  
             suma+=num;
        }
        
        String total=String.valueOf(suma*9);
        int unidad=Character.getNumericValue(total.charAt(total.length()-1));
        
        if(unidad==resultado){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "\nCredito\n" +super.toString()+ "\nTipo Tarjeta: " + tipoTarjeta +"\nNumTarjeta: " + numTarjeta + "\nDescuento: "+
                descuento() +"Monto Final: " + montoFinal();
    }
    
    
}
