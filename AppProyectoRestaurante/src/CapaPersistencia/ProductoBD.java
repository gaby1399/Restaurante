
package CapaPersistencia;

import CapaLogica.Adicional;
import CapaLogica.PlatoPrincipal;
import CapaLogica.Producto;
import CapaLogica.Refresco;
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
public class ProductoBD {
     private final String RUTA_ARCHIVO = System.getProperty("user.dir").replace("\\dist","")+ "\\src\\Archivo\\Producto.txt";
    private ObjectOutputStream oEscritor;
    private ObjectInputStream oLector;
    private FileInputStream archivoEntrada;
    private FileOutputStream archivoSalida;
    private ArrayList<Producto> arrayProductoTemp;
    
    //Instancia privada de la misma clase
    //implementa el patrón Singleton
    private static  ProductoBD instance= null;
   
    //Constructor privado, se implementa el patrón Singleton
    private  ProductoBD() {
                
    }
    
    //Método público que retorna una única instancia de la 
    //clase, únicamnete se construye la primera vez.
    public static  ProductoBD getInstance(){
        if(instance == null){
            instance = new   ProductoBD();
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
     
      
         public ArrayList< Producto> listaProducto() throws Exception{
        ArrayList listaProd= new ArrayList();
        //Ya que habrá bloque finally se debe encerrar el bloque try
        //el throws del encabezado lanza la excepción del finally      
      try {         
            abrirArchivoInput();
             //Si no hay más datos que leer el método available retorna cero
            while(true){
                Producto prod1 = 
                           (Producto)oLector.readObject();                  
                listaProd.add(prod1);
            }
         } //No se indica el catch ya que no se hará nada, solamente se lanzará por medio del throws  
        catch(Exception ex ){
            
       }
        finally{
           //Ocurra o no ocurra la excepción se cierra el archivo
           cerrarArchivoInput();   
           return listaProd;
        } 
       
        
    }
     

   //Busca y retorna el objeto Departamento de acuerdo al código que recibe como 
   //parámetro, en caso de que no lo encuentre retorna null
     //puede funcionar para validar si el objeto se repetir
    public  Producto consultarProducto(String codProd)throws Exception {
         Producto prod,prodBuscado= null ;
        try {
            abrirArchivoInput();
            //Si no hay más datos que leer el método available retorna cero
             while(true){
                prod = (Producto)oLector.readObject();               
                if(prod.getCodigo().equalsIgnoreCase(codProd)) {
                    prodBuscado = prod;
                }
             }            
        }catch(Exception e){
            
        }
        finally{ //Suceda o no suceda la excepción se deben cerrar los archivos
             cerrarArchivoInput();    
             return prodBuscado;
        }       
    }


    /**
     * Agregar un nuevo producto al final del archivo
     * @param producto Objeto Departamento a agregar
     * @return void
     */
    public  void agregarProducto(Producto producto)throws Exception {        
        try {
            this.abrirArchivoOutput();
            if (oEscritor != null) {
              //Ejecutar la escritura del objeto pDepartamento en el archivo
               oEscritor.writeObject(producto);
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
     * @param producto Objeto Departamento a agregar
     * @return void
     */
      public void modificarProducto(Producto produc) throws Exception{
        arrayProductoTemp = new ArrayList<Producto>();
        try {            
            abrirArchivoInput();            
             //Pasar todos los objetos del archivo al ArrayList temporal modificando el 
            //objeto que se recibe como parámetro de acuerdo al código
             Producto prod=null;
            //Si no hay más datos que leer el método available retorna cero
             while(true){//Si va a leer y no hay objeto Departamento se va por el catch
              
                 prod =  (Producto)oLector.readObject(); 
                 if(prod.getCodigo().equalsIgnoreCase(produc.getCodigo())) {
                   prod=produc;
                 }
                 arrayProductoTemp.add(prod);
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
    public void eliminarProducto(String codProducto) throws Exception {
        arrayProductoTemp = new ArrayList<Producto>();
        try {            
            abrirArchivoInput();
            Producto prod = null;
            //Pasa al ArrayList temporal todos los departamentos cuyo código es 
            //diferente al del departamento que se recibe como parámetro
            while(true){
                 prod = (Producto)oLector.readObject();               
                 if(!prod.getCodigo().equalsIgnoreCase(codProducto)) {
                     arrayProductoTemp.add(prod);
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
          if(!arrayProductoTemp.isEmpty()){
             abrirArchivoOutput();
          //Pasa todos los departamentos del ArrayList al archivo
            for (Producto producto : arrayProductoTemp) {
             oEscritor.writeObject(producto);       
            }     
          }
          cerrarArchivoOutput();
    }  

  
  

}
