/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaVista;

/**
 *
 * @author Gabriela
 */
public class FrmMenu extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenu
     */
    public FrmMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMnusalir = new javax.swing.JMenuItem();
        jMnMante = new javax.swing.JMenu();
        jMnuProductos = new javax.swing.JMenuItem();
        jMnuManteCuenta = new javax.swing.JMenuItem();
        jMnCuenta = new javax.swing.JMenu();
        jMnuCuenta = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMnusalir.setText("Salir");
        jMnusalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnusalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMnusalir);

        jMenuBar1.add(jMenu1);

        jMnMante.setText("Mantenimiento");

        jMnuProductos.setText("Productos");
        jMnuProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuProductosActionPerformed(evt);
            }
        });
        jMnMante.add(jMnuProductos);

        jMnuManteCuenta.setText("Cuenta");
        jMnuManteCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuManteCuentaActionPerformed(evt);
            }
        });
        jMnMante.add(jMnuManteCuenta);

        jMenuBar1.add(jMnMante);

        jMnCuenta.setText("Cuenta");

        jMnuCuenta.setText("Cuenta");
        jMnuCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuCuentaActionPerformed(evt);
            }
        });
        jMnCuenta.add(jMnuCuenta);

        jMenuBar1.add(jMnCuenta);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMnusalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnusalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMnusalirActionPerformed

    private void jMnuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuProductosActionPerformed
         FrmProducto frmProducto=new FrmProducto();
         frmProducto.setVisible(true);
         frmProducto.setLocationRelativeTo(this);
    }//GEN-LAST:event_jMnuProductosActionPerformed

    private void jMnuCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuCuentaActionPerformed
         FrmCuenta frmCuenta=new FrmCuenta();
         frmCuenta.setVisible(true);
         frmCuenta.setLocationRelativeTo(this);
    }//GEN-LAST:event_jMnuCuentaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(!JDlgUsuarios.permiso){
            jMnMante.setEnabled(false);
            jMnuProductos.setEnabled(false);
        } 
    }//GEN-LAST:event_formWindowOpened

    private void jMnuManteCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuManteCuentaActionPerformed
        FrmManteCuentas frmManteCuenta =new FrmManteCuentas();
        frmManteCuenta.setVisible(true);
        frmManteCuenta.setLocationRelativeTo(this);
    }//GEN-LAST:event_jMnuManteCuentaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jMnCuenta;
    private javax.swing.JMenu jMnMante;
    private javax.swing.JMenuItem jMnuCuenta;
    private javax.swing.JMenuItem jMnuManteCuenta;
    private javax.swing.JMenuItem jMnuProductos;
    private javax.swing.JMenuItem jMnusalir;
    // End of variables declaration//GEN-END:variables
}
