/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio3.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jose lopez
 */
public class ingreso_usuario extends javax.swing.JFrame {
    private int id,j;
    /**
     * Creates new form ingreso_usuario
     */
    public ingreso_usuario() {
        initComponents();
        this.setTitle("INGRESO DE USUARIOS");
        this.setLocationRelativeTo(ingreso_usuario.this);
        this.setResizable(false);
           try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from empleado");
            cmbcodigoempleado.removeAllItems();
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
            cmbcodigoempleado.addItem(rs.getString(2));
            }
            
        }catch (Exception e){
             JOptionPane.showMessageDialog(null,"NO SE PUDO REALIZAR LA ACCION"+e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnaceptar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        txtcontraseña = new javax.swing.JTextField();
        txtestatus = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnregresar = new javax.swing.JButton();
        cmbcodigoempleado = new javax.swing.JComboBox<>();
        lblcodigoempleado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(516, 469));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("NOMBRE USUARIO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel3.setText("CONTRASEÑA:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel4.setText("ESTATUS:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        btnaceptar.setText("ACEPTAR");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        btnsalir.setText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, -1, -1));
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 270, -1));
        getContentPane().add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 270, -1));
        getContentPane().add(txtestatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 270, -1));

        jLabel6.setText("EMPLEADO:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        btnregresar.setText("REGRESAR");
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, -1));

        cmbcodigoempleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbcodigoempleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbcodigoempleadoItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbcodigoempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 270, -1));

        lblcodigoempleado.setBackground(new java.awt.Color(255, 255, 255));
        lblcodigoempleado.setText("jLabel1");
        getContentPane().add(lblcodigoempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        codigo();  
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");
            PreparedStatement pst = cn.prepareStatement("insert into usuarios values(?,?,?,?,?)");
            String codigo = Integer.toString(id);
            pst.setString(1, codigo);
            pst.setString(2, txtnombre.getText().trim());
            pst.setString(3, txtcontraseña.getText().trim());
            pst.setString(4, txtestatus.getText().trim());
            pst.setString(5, lblcodigoempleado.getText().trim());
            pst.executeUpdate();
            txtnombre.setText("");
            txtcontraseña.setText("");
            txtestatus.setText("");
            
           JOptionPane.showMessageDialog(null,"INGRESO EXITOSO");
        }catch (Exception e){
             System.out.println("ERROR"+e);
        }
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
      MENUPRINCIPAL v = new MENUPRINCIPAL();
      v.show();
      dispose();
    }//GEN-LAST:event_btnregresarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
      dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void cmbcodigoempleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbcodigoempleadoItemStateChanged
         try{
	Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");
        PreparedStatement pst = cn.prepareStatement("select codigo_empleado from empleado where nombre_empleado = '"+(String)cmbcodigoempleado.getSelectedItem()+"'");
        ResultSet rs = pst.executeQuery();
	if(rs.next())
        {
        lblcodigoempleado.setText(rs.getString(1));
        }
		}
		catch (Exception  abc){
		JOptionPane.showMessageDialog(null,"error" + abc);
		}
    }//GEN-LAST:event_cmbcodigoempleadoItemStateChanged
    public void codigo()
{
  try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");
            PreparedStatement pst = cn.prepareStatement("select count(*) from usuarios");
            ResultSet rs = pst.executeQuery();
            
          String fila = "";
          if(rs.next())
          {
          fila = rs.getString(1);
          j = Integer.parseInt(fila);
          if(j == 0)
          {
          id = 1;
          }else
          {
          id= j+1;
          }
          }
            
        }catch (Exception e){
             JOptionPane.showMessageDialog(null,"ERROR"+e.getMessage());
        }
}
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
    private javax.swing.JButton btnregresar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cmbcodigoempleado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblcodigoempleado;
    private javax.swing.JTextField txtcontraseña;
    private javax.swing.JTextField txtestatus;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
