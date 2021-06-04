
package CapaLogica;

import CapaPersistencia.ProductoBD;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Gabriela
 */
public class Adicional extends Producto implements Serializable{
    private Tamaño tamaño;
    private ExtraAdicional extra;
    
    public Adicional(String codigo,Tamaño tamaño, String nombre, double precioBase) {
        super(codigo,nombre, precioBase);
        this.tamaño = tamaño;
    }
    
    public Adicional(String codigo,String nombre, double precioBase){
        super(codigo,nombre, precioBase);
        tamaño=Tamaño.Pequeño;
    }
    
    public double montoExtra(){
        if(getTamaño()==Tamaño.Grande){
            if(extra.Yuquitas.equals(getNombre())){
                return extra.Yuquitas.getPrecioAdic();
            }else{
                return 200;
                 }  
        }
            return 0;
    }
    
    public double montoTotal(){
        return getPrecioBase()+montoExtra();
    }

    public Tamaño getTamaño() {
        return tamaño;
    }

    public void setTamaño(Tamaño tamaño) {
        this.tamaño = tamaño;
    }

    public ExtraAdicional getExtra() {
        return extra;
    }

    public void setExtra(ExtraAdicional extra) {
        this.extra = extra;
    }

   
    public String display() {
        return "\nAdicional\n" +super.display() + "\nTamaño: " + tamaño + "\nExtra: " + extra;
    }
    
    
}
