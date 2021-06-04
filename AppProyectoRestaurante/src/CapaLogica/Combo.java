
package CapaLogica;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Gabriela
 */
public class Combo extends Producto implements Serializable{
    private PlatoPrincipal plato;
    private Refresco refresco;
    private ArrayList<Adicional> arrayAdicional ;
    private boolean refil;
    private boolean agrandar;
   

    public Combo(String codigo,PlatoPrincipal plato, Refresco refresco, boolean refil, boolean agrandar) {
        super(codigo,"Combo", 0);
        this.plato = plato;
        this.refresco = refresco;
        this.arrayAdicional= new ArrayList<>();
        this.refil = refil;
        this.agrandar = agrandar;
    }
    
    public void agregarAdicional(Adicional adic){
         
         arrayAdicional.add(adic);
    }
    
    public double cobroSubTotal(){
        double precio = 0;
        for (Adicional arrayAdicional1 : arrayAdicional) {
            precio+= arrayAdicional1.getPrecioBase();
        }
         return plato.getPrecioBase()+refresco.getPrecioBase()+precio;
     }
    
    public double cobroAgrandado(){
         return (agrandar)?300:0;
     }
    
    public double cobroRefil(){
         if(refil){
             if(ExtraRefresco.Gaseosa==refresco.getExtraRefr()){
                 return 200;
             }else{
                 return 100;
             }
         }
         return 0;
     }
    
    public double descuento(){
         return cobroSubTotal()*0.20;
     }
    
     @Override
    public double montoExtra() {
        return cobroAgrandado()+cobroRefil();
    }

    @Override
    public double montoTotal() {
       return cobroSubTotal()+cobroAgrandado()+cobroRefil()-descuento();
    }
   

    @Override
    public String display() {
        String hilera= null;
        hilera+= "\nCombo\n" + super.display()+ "\nPlato: " + plato + "\nRefresco: " + refresco;
             for (Adicional arrayAdicional1 : arrayAdicional) {
              hilera+="\n"+ arrayAdicional1.toString();
         } 
        hilera+="\nRefil: " + refil + "\nAgrandar:" + agrandar + "\nSubtotal: " + cobroSubTotal()+
                "\nCobro de Agrandado: " + cobroAgrandado()+ "\nCobro de refil: "+ cobroRefil()+
                "\nDescuento: "+ descuento() +"\nPrecio total: "+ montoTotal();
        return hilera;
    }

    public PlatoPrincipal getPlato() {
        return plato;
    }

    public void setPlato(PlatoPrincipal plato) {
        this.plato = plato;
    }

    public Refresco getRefresco() {
        return refresco;
    }

    public void setRefresco(Refresco refresco) {
        this.refresco = refresco;
    }

    public ArrayList<Adicional> getArrayAdicional() {
        return arrayAdicional;
    }

    public void setArrayAdicional(ArrayList<Adicional> arrayAdicional) {
        this.arrayAdicional = arrayAdicional;
    }

    public boolean isRefil() {
        return refil;
    }

    public void setRefil(boolean refil) {
        this.refil = refil;
    }

    public boolean isAgrandar() {
        return agrandar;
    }

    public void setAgrandar(boolean agrandar) {
        this.agrandar = agrandar;
    }

  
    
    
}
