
package CapaLogica;

import java.io.Serializable;

/**
 *
 * @author Gabriela
 */
public class Contado extends Pago implements Serializable{
    private final double PRECIO_DOLAR=615;
    private double pagoCliente;
    
    
    public Contado(double montoPago) {
        super(montoPago);
    }
    
    public double calculaVueltoColones(){
        return super.getMontoPago()-getPagoCliente();
    }
     public double calculaVueltoDolares(){
        return convertirDolares()-getPagoCliente();
    }
    public double convertirDolares(){
        return getMontoPago()/PRECIO_DOLAR;
          
    }

    public double getPagoCliente() {
        return pagoCliente;
    }

    public void setPagoCliente(double pagoCliente) {
        this.pagoCliente = pagoCliente;
    }

    @Override
    public String toString() {
        return "\nContado:\n"+super.toString()+"\nVuelto: " + calculaVueltoColones();
    }
    
    public String display() {
        return "\nContado:\n"+ "\nMonto en dolares: "+convertirDolares()+"\nVuelto: " + calculaVueltoDolares();
    }
    
}
