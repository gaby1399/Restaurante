/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPersistencia;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author pc
 */
public class MiObjectOutputStream extends ObjectOutputStream{

    public MiObjectOutputStream(OutputStream out)
            throws IOException {
            super(out);
    }
    
    //redefinir el metodo que escribe los encabezados
    @Override
    protected void writeStreamHeader() throws IOException{
        
    }
}
