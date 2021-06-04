
package CapaLogica;

import java.io.Serializable;


/**
 *n
 * @author Gabriela
 */
public class Usuario implements Serializable{
    private String nombre;
    private String  clave;
    private TipoUsuario tipoUsuario;
   
      public Usuario(String nombre,String clave,TipoUsuario tipoU) { 
        this.nombre = nombre;
        this.clave = clave;
        this.tipoUsuario=tipoU;
    }
    public Usuario(String nombre,String clave) { 
        this.nombre = nombre;
        this.clave = clave;
   }
    public Usuario(TipoUsuario tUsuario){
        tipoUsuario=tUsuario;
    }
    
    @Override
    public String toString() {
        return "\nUsuario\n"  + tipoUsuario  + "\nNombre: " + nombre ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
 
    
}
