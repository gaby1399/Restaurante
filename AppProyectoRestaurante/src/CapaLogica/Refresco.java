
package CapaLogica;

import java.io.Serializable;

/**
 *
 * @author Gabriela
 */
public class Refresco extends Producto implements Serializable{
    private Tamaño tamaño;
    private ExtraRefresco extraRefr;
    
    public Refresco(String codigo,Tamaño tamaño, String nombre, double precioBase) {
        super(codigo,nombre, precioBase);
        this.tamaño = tamaño;
    }
    
    public Refresco(String codigo,String nombre, double precioBase){
        super(codigo,nombre, precioBase);
        tamaño=Tamaño.Pequeño;
    }
    
    public double montoExtra(){
      if(getTamaño()==Tamaño.Grande){
          if(extraRefr.Gaseosa.equals(getNombre())){
              return extraRefr.Gaseosa.getPrecioRefre();
          }else
              return extraRefr.Natural.getPrecioRefre();
      }
         return 0;
    }
    
    public double montoTotal(){
        return montoExtra()+getPrecioBase();
    }


    public String display() {
        return "\nRefresco\n" + super.display() + "\ntamaño: " + tamaño ;
    }
   
    
    public Tamaño getTamaño() {
        return tamaño;
    }

    public void setTamaño(Tamaño tamaño) {
        this.tamaño = tamaño;
    }

    public ExtraRefresco getExtraRefr() {
        return extraRefr;
    }

    public void setExtraRefr(ExtraRefresco extraRefr) {
        this.extraRefr = extraRefr;
    }
    
    
}
