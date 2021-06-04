/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaVista;

import CapaLogica.TipoUsuario;
import CapaLogica.Usuario;

/**
 *
 * @author Gabriela
 */
public class FrmPrincipal {

    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args){
        
        
      Usuario salonero= new Usuario(TipoUsuario.Salonero);
         Usuario adm= new Usuario(TipoUsuario.Administrador);
        JDlgUsuarios dlgUsuarios = new JDlgUsuarios(null, true);
        dlgUsuarios.setVisible(true);
        dlgUsuarios.setLocationRelativeTo(null); 
    }
    
}
