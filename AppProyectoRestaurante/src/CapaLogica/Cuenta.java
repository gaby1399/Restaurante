
package CapaLogica;


import CapaPersistencia.CuentaBD;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Gabriela
 */
public class Cuenta implements Serializable{
    private int numMesa;
    private static int cont=1;
    private int numCuenta;
    private Date fecha;
    private Date hora;
    private Usuario usuario;
    private Pago pago;
    private final double IV=0.13;
    private final double SERVICIO=0.10;
    private ArrayList<LineaDetalle> arrayDetalle;
    
    public Cuenta(Usuario usuario) {
        this.usuario = usuario;
        this.numCuenta=cont++;
        this.hora= new Date();
        this.fecha=new Date();
        arrayDetalle= new ArrayList();
    }
    
    public void agregarProducto(LineaDetalle detalle){
       arrayDetalle.add(detalle);
    }
   
    public double subTotal(){
        double sub = 0;
        for (LineaDetalle lineaDetalle : arrayDetalle) {
           sub+= lineaDetalle.precioLinea();
        }
        return sub;
    }
    
    public double impuestos(){
         return subTotal()*IV;
    }
    
    public double impServicio(){
        return subTotal()*SERVICIO;
    }
    
    public double Total(){
        return subTotal()+impServicio()+impuestos();
    }
    
  

    @Override
    public String toString() {
         SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yy");
         SimpleDateFormat formatoHoras=new SimpleDateFormat("hh:mm:ss");
        String hilera="";
        hilera+= "\nCuenta" + "\nNumero de mesa: " + numMesa + "\nNumero de la Cuenta: " + numCuenta + 
                "\nFecha: " + formatoFecha.format(fecha) + "\nHora: " + formatoHoras.format(hora) + "\nUsuario: " + usuario + "\n" ;
        for (LineaDetalle lineaDetalle : arrayDetalle) {
            hilera+=lineaDetalle.toString();
        }
        return hilera;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

   

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public ArrayList<LineaDetalle> getArrayDetalle() {
        return arrayDetalle;
    }

    public void setArrayDetalle(ArrayList<LineaDetalle> arrayDetalle) {
        this.arrayDetalle = arrayDetalle;
    }
      public static void eliminarCuenta(int codigo) throws Exception{
        CuentaBD.getInstance().eliminarDepartamento(codigo);
    }
     public static Cuenta consultarCuenta(int codigo) throws Exception {
        return CuentaBD.getInstance().consultarDepartamento(codigo);
    }
    public static ArrayList<Cuenta> listadoCuenta() throws Exception {
       return CuentaBD.getInstance().listaCuenta();
    }
      public static void agregarCuenta(Cuenta cuenta) throws Exception {
        CuentaBD.getInstance().agregarCuenta(cuenta);
    }
}
