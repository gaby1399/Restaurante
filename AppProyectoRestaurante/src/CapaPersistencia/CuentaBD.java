/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPersistencia;

import CapaLogica.Cuenta;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class CuentaBD {
   private final String RUTA_ARCHIVO = System.getProperty("user.dir").replace("\\dist","")+ "\\src\\Archivo\\Cuenta.txt"; //la ruta lo lleva a la capaArchivo
    private ObjectOutputStream oEscritor;
    private ObjectInputStream oLector;
    private FileInputStream archivoEntrada;
    private FileOutputStream archivoSalida;
    private ArrayList<Cuenta> arrayCuentaTemp;
    
    //Instancia privada de la misma clase
    //implementa el patrón Singleton
    private static  CuentaBD instance= null;
   
    //Constructor privado, se implementa el patrón Singleton
    private CuentaBD() {
                
    }
    
    //Método público que retorna una única instancia de la 
    //clase, únicamnete se construye la primera vez.
    public static CuentaBD getInstance(){
        if(instance == null){
            instance = new  CuentaBD();
        }
        return instance;
    }
    
    
    /**
     * Abre y retorna el archivo de datos, para escritura (de tipo output) al final del archivo
     * Tipo de Archivo: Secuencial.
     * Lanza la Exception al nivel donde fue llamado
     * @return void
     */
    public void abrirArchivoOutput() throws Exception {
        //Abrir el archivo
        try{
        File oArchivo = new File(RUTA_ARCHIVO);
           if(!oArchivo.exists()){
             //Abrir el archivo de Acceso Secuencial para  escritura
             //La primera vez incluye la cabecera del archivo
             //true indica que se agregarán registros al final            
             archivoSalida = new FileOutputStream(RUTA_ARCHIVO,true);
             oEscritor = new ObjectOutputStream(archivoSalida);            
           }
           else{
             //Abrir el archivo de Acceso Secuencial para  escritura
             //La primera vez incluye la cabecera del archivo
              archivoSalida = new FileOutputStream(RUTA_ARCHIVO,true);
              oEscritor = new MiObjectOutputStream(archivoSalida);
           }  
        }catch(Exception e){
            throw e;
        }        
    }

    
    public  void abrirArchivoInput() throws Exception {    
      //Abrir el archivo
      try{    
        archivoEntrada = new FileInputStream(RUTA_ARCHIVO);
        oLector = new ObjectInputStream(archivoEntrada);
      }
      catch(Exception e){
         throw e;
      }      
    }

   
    /**
     * Permite cerrar el archivo de datos que se abrió de salida
    */
    public  void cerrarArchivoOutput() throws Exception { 
        try{
          if (oEscritor != null) {
            oEscritor.close();
            oEscritor = null;
          }  
        }
        catch(Exception e){
           throw e;
        }
    }

    private void cerrarArchivoInput() throws Exception {
        try{     
             if (oLector != null) {
                oLector.close();
                oLector = null;
             }
        }
        catch(Exception e){
           throw e;
           //muestra al usuario el error
        }
    }


    /**
     * Lista de todos los Departamentos que se encuentran en el archivo
     * @return ArrayList
     */
     public ArrayList<Cuenta> listaCuenta() throws Exception{
        ArrayList listaCuenta= new ArrayList();
        //Ya que habrá bloque finally se debe encerrar el bloque try
        //el throws del encabezado lanza la excepción del finally      
      try {         
            abrirArchivoInput();
             //Si no hay más datos que leer el método available retorna cero
            while(true){
                Cuenta cuenta = 
                           (Cuenta)oLector.readObject();                  
                listaCuenta.add(cuenta);
            }
         } //No se indica el catch ya que no se hará nada, solamente se lanzará por medio del throws  
        catch(Exception ex ){
            
       }
        finally{
           //Ocurra o no ocurra la excepción se cierra el archivo
           cerrarArchivoInput();   
           return listaCuenta;
        } 
       
        
    }

   //Busca y retorna el objeto Departamento de acuerdo al código que recibe como 
   //parámetro, en caso de que no lo encuentre retorna null
     //puede funcionar para validar si el objeto se repetir
    public Cuenta consultarDepartamento(int codigo)throws Exception {
        Cuenta cuenta,cuentaBuscado= null ;
        try {
            abrirArchivoInput();
            //Si no hay más datos que leer el método available retorna cero
             while(true){
                cuenta = (Cuenta)oLector.readObject(); 
                
                if(cuenta.getNumCuenta()==codigo) { //modifique
                    cuentaBuscado = cuenta;
                }
             }            
        }catch(Exception e){
            
        }
        finally{ //Suceda o no suceda la excepción se deben cerrar los archivos
             cerrarArchivoInput();    
             return cuentaBuscado;
        }       
    }


    /**
     * Agregar un nuevo Departamento al final del archivo
     * @param cuenta Objeto Departamento a agregar
     * @return void
     */
    public  void agregarCuenta(Cuenta cuenta)throws Exception {        
        try {
            this.abrirArchivoOutput();
            if (oEscritor != null) {
              //Ejecutar la escritura del objeto pDepartamento en el archivo
               oEscritor.writeObject(cuenta);
               oEscritor.flush();  //Envía el contenido del buffer al archivo
               oEscritor.reset();//Se requiere para cuando se reciben subclases de Departamento
            }
        
        } catch (Exception e) {
            throw e;
        }
        finally{
            //Ocurra o no la excepción se debe cerrar el archivo
            this.cerrarArchivoOutput(); //Cierra el archivo
        }
        
    }

    /**
     * Agregar un nuevo Departamento al archivo
     * @param cuenta Objeto Departamento a agregar
     * @return void
     */
      public void modificarDepartamento(Cuenta cuenta) throws Exception{
        arrayCuentaTemp = new ArrayList<Cuenta>();
        try {            
            abrirArchivoInput();            
             //Pasar todos los objetos del archivo al ArrayList temporal modificando el 
            //objeto que se recibe como parámetro de acuerdo al código
             Cuenta cuenta1=null;
            //Si no hay más datos que leer el método available retorna cero
             while(true){//Si va a leer y no hay objeto Departamento se va por el catch
                 cuenta1 = (Cuenta)oLector.readObject(); 
                 if(cuenta1.getNumCuenta()==cuenta.getNumCuenta()) {
                   cuenta1=cuenta;
                 }
                 arrayCuentaTemp.add(cuenta1);
             }  
        }
        catch(Exception ex){
            
        }
        finally{
            cerrarArchivoInput();
            pasarArrayTemporal_Archivo();        
        }
        
    }
    
    
    //validar si el objeto existe 
    public void eliminarDepartamento(int codigo) throws Exception {
        arrayCuentaTemp = new ArrayList<Cuenta>();
        try {            
            abrirArchivoInput();
            Cuenta cuenta1 = null;
            //Pasa al ArrayList temporal todos los departamentos cuyo código es 
            //diferente al del departamento que se recibe como parámetro
            while(true){
                 cuenta1 = (Cuenta)oLector.readObject();               
                 if(cuenta1.getNumCuenta()!=codigo) {
                     arrayCuentaTemp.add(cuenta1);
                 }
             }                       
        }catch(Exception e){      
           
        }
        finally{
            cerrarArchivoInput();
            pasarArrayTemporal_Archivo(); 
        }               
    }
    

    private void pasarArrayTemporal_Archivo() throws Exception {       
       File archivoOriginal = new File(RUTA_ARCHIVO);
       //Si hay departamentos en el ArrayList y el archivo existe
       //borra el archivo original para volverlo a llenar           
       
          if(archivoOriginal.exists()){
            archivoOriginal.delete();
          }  
          if(!arrayCuentaTemp.isEmpty()){
             abrirArchivoOutput();
          //Pasa todos los departamentos del ArrayList al archivo
            for (Cuenta departamento : arrayCuentaTemp) {
             oEscritor.writeObject(departamento);       
            }     
          }
          cerrarArchivoOutput();
    }  
}
