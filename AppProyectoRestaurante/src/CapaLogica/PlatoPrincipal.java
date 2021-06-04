
package CapaLogica;

import CapaPersistencia.ProductoBD;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Gabriela
 */
public class PlatoPrincipal extends Producto implements Serializable{
    private ArrayList<String> arraysolicitudExtra;
    private final double EXTRA=0.10;

    public PlatoPrincipal(String codigo,String nombre, double precioBase) {
        super(codigo,nombre, precioBase);
       arraysolicitudExtra= new ArrayList();
    }
    
    public void solicitudExtra(String extra){
        arraysolicitudExtra.add(extra);
    }
    
    public double montoExtra(){
        //hacer uno mas eficiente
        if(getNombre().indexOf("doble")>11){
            return  getPrecioBase()*EXTRA;
        }else{
            return 0;
        }
        
    }
    
    public double montoTotal(){
        return montoExtra()+getPrecioBase();
    }

    @Override
    public String display() {
        return "\nPlatoPrincipal\n" + super.display();
    }
    
    
}
