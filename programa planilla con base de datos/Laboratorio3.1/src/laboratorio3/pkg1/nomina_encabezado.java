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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author jose lopez
 */
public class nomina_encabezado extends javax.swing.JFrame {
    private int id,j;
    /**
     * Creates new form nomina_encabezado
     */
    public nomina_encabezado() {
        initComponents();
        this.setTitle("INGRESO DE NUEVA NOMINA");
        this.setLocationRelativeTo(nomina_encabezado.this);
        this.setResizable(false);
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        fecha_inicial = new com.toedter.calendar.JDateChooser();
        fecha_final = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("FECHA INICIAL:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 62, -1, -1));

        jLabel2.setText("FECHA FINAL:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 96, -1, -1));

        jButton1.setText("ACEPTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        jButton3.setText("REGRESAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, -1, -1));

        fecha_inicial.setDateFormatString("yyyy/MM/dd");
        getContentPane().add(fecha_inicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 380, -1));

        fecha_final.setDateFormatString("yyyy/MM/dd");
        getContentPane().add(fecha_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 380, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       MENUPRINCIPAL v = new MENUPRINCIPAL();
       v.show();
       dispose();
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       codigo();
           try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");
            PreparedStatement pst = cn.prepareStatement("insert into encabezado_nomina(codigo_nomina,fecha_inicial_nomina,fecha_final_nomina,valor_nomina) values('"+id+"','"+((JTextField)fecha_inicial.getDateEditor().getUiComponent()).getText()+"','"+((JTextField)fecha_final.getDateEditor().getUiComponent()).getText()+"','"+0.0+"')");
            pst.executeUpdate();

           
           JOptionPane.showMessageDialog(null,"INGRESO EXITOSO");
        }catch (Exception e){
             System.out.println("ERROR AL REGISTRAR\n"+e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
public void codigo()
{
  try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");
            PreparedStatement pst = cn.prepareStatement("select count(*) from encabezado_nomina");
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
            java.util.logging.Logger.getLogger(nomina_encabezado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nomina_encabezado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nomina_encabezado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nomina_encabezado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nomina_encabezado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser fecha_final;
    private com.toedter.calendar.JDateChooser fecha_inicial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
