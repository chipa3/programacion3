package laboratorio3.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jose lopez
 */
public class nomina_detalle extends javax.swing.JFrame {

    /**
     * Creates new form nomina_detalle
     */
    public nomina_detalle() {
        initComponents();
        this.setTitle("INGRESO A NOMINA DETALLE");
        this.setLocationRelativeTo(nomina_detalle.this);
        this.setResizable(false);
        fechas();
        empleados();
        concepto();
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
        cmbnomina = new javax.swing.JComboBox<>();
        cmbempleado = new javax.swing.JComboBox<>();
        cmbconcepto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtmonto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lblcodigonomina = new javax.swing.JLabel();
        lblcodigoempleado = new javax.swing.JLabel();
        lblcodigoconcepto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("NOMINA:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 59, -1, -1));

        jLabel2.setText("EMPLEADO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 99, -1, -1));

        jLabel3.setText("CONCEPTO:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 143, -1, -1));

        cmbnomina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbnomina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbnominaItemStateChanged(evt);
            }
        });
        cmbnomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbnominaActionPerformed(evt);
            }
        });
        getContentPane().add(cmbnomina, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 56, 340, -1));

        cmbempleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbempleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbempleadoItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 96, 340, -1));

        cmbconcepto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbconcepto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbconceptoItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbconcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 140, 340, -1));

        jLabel4.setText("MONTO:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 183, -1, -1));
        getContentPane().add(txtmonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 180, 340, -1));

        jButton1.setText("ACEPTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, -1, -1));

        jButton3.setText("REGRESAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, -1, -1));

        lblcodigonomina.setText("jLabel5");
        getContentPane().add(lblcodigonomina, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, -1));

        lblcodigoempleado.setText("jLabel6");
        getContentPane().add(lblcodigoempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        lblcodigoconcepto.setText("jLabel7");
        getContentPane().add(lblcodigoconcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, -1, -1));

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

    private void cmbnominaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbnominaItemStateChanged
       String fecha;
   
        try{
	Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");
        PreparedStatement pst = cn.prepareStatement("SELECT * FROM `encabezado_nomina`");
        ResultSet rs = pst.executeQuery();
        while(rs.next())
        {
         fecha =("DEL "+rs.getString(2)+" AL "+rs.getString(3));
        if(cmbnomina.getSelectedItem().equals(fecha)){
        lblcodigonomina.setText(rs.getString(1));}
        }
        }
		catch (Exception  abc){
		}
       
    }//GEN-LAST:event_cmbnominaItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");
            PreparedStatement pst = cn.prepareStatement("insert into detalle_nomina values(?,?,?,?)");
           
             pst.setString(1, lblcodigonomina.getText());
            pst.setString(2, lblcodigoempleado.getText().trim());
            pst.setString(3, lblcodigoconcepto.getText().trim());
            pst.setString(4, txtmonto.getText().trim());
           
            pst.executeUpdate();
            txtmonto.setText("");
            
           JOptionPane.showMessageDialog(null,"INGRESO EXITOSO");
            }catch (Exception e){
             System.out.println("MENSAJE DE PRUEBA"+e);
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbnominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbnominaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbnominaActionPerformed

    private void cmbempleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbempleadoItemStateChanged
         try{
	Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");
        PreparedStatement pst = cn.prepareStatement("select codigo_empleado from empleado where nombre_empleado = '"+(String)cmbempleado.getSelectedItem()+"'");
        ResultSet rs = pst.executeQuery();
	if(rs.next())
        {
        lblcodigoempleado.setText(rs.getString(1));
        }
		}
		catch (Exception  abc){
		JOptionPane.showMessageDialog(null,"error" + abc);
		}
    }//GEN-LAST:event_cmbempleadoItemStateChanged

    private void cmbconceptoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbconceptoItemStateChanged
       try{
	Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");
        PreparedStatement pst = cn.prepareStatement("select codigo_concepto from concepto where nombre_concepto = '"+(String)cmbconcepto.getSelectedItem()+"'");
        ResultSet rs = pst.executeQuery();
	if(rs.next())
        {
        lblcodigoconcepto.setText(rs.getString(1));
        }
		}
		catch (Exception  abc){
		JOptionPane.showMessageDialog(null,"error" + abc);
		}
    }//GEN-LAST:event_cmbconceptoItemStateChanged
    public void fechas()
    {
    try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from encabezado_nomina");
            cmbnomina.removeAllItems();
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
            cmbnomina.addItem("DEL "+rs.getString(2)+" AL "+rs.getString(3));
            }
            
        }catch (Exception e){
             JOptionPane.showMessageDialog(null,"NO SE PUDO REALIZAR LA ACCION"+e);
        }
    }
    public void empleados()
    {
    try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from empleado");
            cmbempleado.removeAllItems();
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
            cmbempleado.addItem(rs.getString(2));
            }
            
        }catch (Exception e){
             JOptionPane.showMessageDialog(null,"NO SE PUDO REALIZAR LA ACCION"+e);
        }
    }
    public void concepto()
    {
    try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from concepto");
            cmbconcepto.removeAllItems();
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
            cmbconcepto.addItem(rs.getString(2));
            }
            
        }catch (Exception e){
             JOptionPane.showMessageDialog(null,"NO SE PUDO REALIZAR LA ACCION"+e);
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
            java.util.logging.Logger.getLogger(nomina_detalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nomina_detalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nomina_detalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nomina_detalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nomina_detalle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbconcepto;
    private javax.swing.JComboBox<String> cmbempleado;
    private javax.swing.JComboBox<String> cmbnomina;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblcodigoconcepto;
    private javax.swing.JLabel lblcodigoempleado;
    private javax.swing.JLabel lblcodigonomina;
    private javax.swing.JTextField txtmonto;
    // End of variables declaration//GEN-END:variables
}