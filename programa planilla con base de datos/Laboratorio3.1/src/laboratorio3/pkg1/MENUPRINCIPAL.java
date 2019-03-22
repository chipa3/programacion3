package laboratorio3.pkg1;


import laboratorio3.pkg1.ingreso_usuario;


/**
 *
 * @author jose lopez
 */
public class MENUPRINCIPAL extends javax.swing.JFrame {

    /**
     * Creates new form MENUPRINCIPAL
     */
    public MENUPRINCIPAL() {
        initComponents();
        this.setTitle("MENU PRINCIPAL");
        this.setLocationRelativeTo(MENUPRINCIPAL.this);
        this.setResizable(false);
        //this.setExtendesdState(MENUPRINCILAP.MINIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnplanilla = new javax.swing.JButton();
        btnpuestos = new javax.swing.JButton();
        btndepartamentos = new javax.swing.JButton();
        btnempleados = new javax.swing.JButton();
        btnusuarios = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnplanilla.setText("PLANILLA");
        btnplanilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnplanillaActionPerformed(evt);
            }
        });
        getContentPane().add(btnplanilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 220, 90));

        btnpuestos.setText("INGRESO DE PUESTOS");
        btnpuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpuestosActionPerformed(evt);
            }
        });
        getContentPane().add(btnpuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 200, 90));

        btndepartamentos.setText("INGRESO DE DEPARTAMENTO");
        btndepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndepartamentosActionPerformed(evt);
            }
        });
        getContentPane().add(btndepartamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 220, 90));

        btnempleados.setText("INGRESO DE EMPLEADOS");
        btnempleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnempleadosActionPerformed(evt);
            }
        });
        getContentPane().add(btnempleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 220, 90));

        btnusuarios.setText("INGRESO DE USUARIOS");
        btnusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btnusuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 200, 90));

        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 450, -1));

        jButton2.setText("ELIMINACION DE DATOS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 200, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusuariosActionPerformed
            ingreso_usuario ventana = new ingreso_usuario();
            ventana.show();
            dispose();         
    }//GEN-LAST:event_btnusuariosActionPerformed

    private void btnempleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnempleadosActionPerformed
        ingreso_empleado v = new ingreso_empleado();
            v.show();
            dispose();   
    }//GEN-LAST:event_btnempleadosActionPerformed

    private void btnpuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpuestosActionPerformed
          ingreso_puesto v = new ingreso_puesto();
            v.show();
            dispose(); 
    }//GEN-LAST:event_btnpuestosActionPerformed

    private void btndepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndepartamentosActionPerformed
         ingreso_departamento v = new ingreso_departamento();
            v.show();
            dispose(); 
    }//GEN-LAST:event_btndepartamentosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnplanillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnplanillaActionPerformed
       planilla v = new planilla();
       v.show();
       dispose();
       
    }//GEN-LAST:event_btnplanillaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       eliminacion_de_datos v = new eliminacion_de_datos();
       v.show();
       dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MENUPRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MENUPRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MENUPRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MENUPRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MENUPRINCIPAL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndepartamentos;
    private javax.swing.JButton btnempleados;
    private javax.swing.JButton btnplanilla;
    private javax.swing.JButton btnpuestos;
    private javax.swing.JButton btnusuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
