
package CapaLogica;

import CapaPersistencia.ProductoBD;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Gabriela
 */
public abstract class Producto implements Serializable{

    private String codigo;
    private String nombre;
    private double precioBase;

    public Producto(String codigo,String nombre, double precioBase) {
        this.codigo= codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }
    
    public abstract double montoExtra();
  
    
    public abstract double montoTotal();
    

    @Override
    public String toString() {
        return  "\nNombre: " + nombre + "\nPrecio:" + precioBase;
    }
    public String display(){
        return "Codigo:"+codigo+"\nNombre: " + nombre + "\nPrecio:" + precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public static Producto consultarProducto (String nom) throws Exception {
        return ProductoBD.getInstance().consultarProducto(nom);
    }
    public static void agregarProducto(Producto prod) throws Exception {
        ProductoBD.getInstance().agregarProducto(prod);
    }
    public static void eliminarProducto(String nom) throws Exception{
        ProductoBD.getInstance().eliminarProducto(nom);
    }
    public static void modificarProducto (Producto prod) throws Exception{
        ProductoBD.getInstance().modificarProducto(prod);
    }
      
    public static ArrayList<Producto> listadoProducto() throws Exception {
       return ProductoBD.getInstance().listaProducto();
    }
}
