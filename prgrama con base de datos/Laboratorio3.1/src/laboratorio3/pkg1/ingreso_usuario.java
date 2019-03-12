/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio3.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jose lopez
 */
public class ingreso_usuario extends javax.swing.JFrame {

    /**
     * Creates new form ingreso_usuario
     */
    public ingreso_usuario() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnaceptar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        txtcontraseña = new javax.swing.JTextField();
        txtestatus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("INGRESO DE USUARIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        jLabel2.setText("NOMBRE:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 83, -1, -1));

        jLabel3.setText("CONTRASEÑA:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel4.setText("ESTATUS:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        btnaceptar.setText("aceptar");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        btnsalir.setText("salir");
        getContentPane().add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 170, -1));
        getContentPane().add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 170, -1));
        getContentPane().add(txtestatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 170, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
                try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ins", "root", "");
            PreparedStatement pst = cn.prepareStatement("insert into usuarios values(?,?,?)");
            
            pst.setString(1, "0");
            pst.setString(2, txtnombre.getText().trim());
            pst.setString(3, txtcontraseña.getText().trim());
            
            pst.executeUpdate();
            
            txtnombre.setText("");
            txtcontraseña.setText("");
            jLabel4.setText("Registro exitoso.");
        }catch (Exception e){
             System.out.println("MENSAJE DE PRUEBA");
        }
          
    }//GEN-LAST:event_btnaceptarActionPerformed

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
            java.util.logging.Logger.getLogger(ingreso_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ingreso_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ingreso_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ingreso_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ingreso_usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtcontraseña;
    private javax.swing.JTextField txtestatus;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
