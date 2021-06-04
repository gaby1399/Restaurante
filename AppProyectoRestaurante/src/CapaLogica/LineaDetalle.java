
package CapaLogica;

import java.io.Serializable;

/**
 *
 * @author Gabriela
 */
public class LineaDetalle implements Serializable{
    private Producto producto;
    private double cantidad;
    private String indicaciones;

    public LineaDetalle(Producto producto, double cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
   public double precioLinea(){
    return producto.montoTotal()*cantidad;
    }

    @Override
    public String toString() {
        return "\nLineaDetalle\n" + "\nProducto:" + producto.display() + "\nCantidad=" + cantidad + "\nIndicaciones=" + indicaciones + "Precio:"+ precioLinea();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }
   
   
}
