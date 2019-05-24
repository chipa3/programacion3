/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excel;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.SqlUsuarios;
import modelo.hash;
import modelo.usuarios;

/**
 *
 * @author Paula V
 */
public class registro extends javax.swing.JFrame {

    /**
     * Creates new form registro
     */
    public registro() {
        initComponents();
        this.setLocationRelativeTo(null);//centrar la forma en la pantalla
        jLabel9.setIcon(new ImageIcon("images/fondo.JPG"));
        btn_regresar.setIcon(new ImageIcon("iconos/REGRESAR.PNG"));
        btnGuardar.setIcon(new ImageIcon("iconos/GUARDAR.PNG"));
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
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmaPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JComboBox<>();
        Eti_titulo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_regresar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Usuario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 104, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("<html>Confirmar Contraseña:</html>");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 193, 94, -1));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 101, 197, -1));

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 147, 197, -1));

        txtConfirmaPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtConfirmaPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 209, 197, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Nombre:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 266, -1, -1));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 263, 197, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Correo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 312, -1, -1));

        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 309, 197, -1));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 90, 70));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Tipo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 358, -1, -1));

        txtTipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTipo.setMaximumRowCount(2);
        txtTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Administrador", "Usuario" }));
        txtTipo.setToolTipText("");
        getContentPane().add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 355, -1, -1));

        Eti_titulo.setFont(new java.awt.Font("Fredericka the Great", 1, 36)); // NOI18N
        Eti_titulo.setForeground(new java.awt.Color(0, 153, 153));
        Eti_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Eti_titulo.setText("NUEVO USUARIO");
        getContentPane().add(Eti_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 22, 350, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Regresar");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Guardar");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, -1, -1));

        btn_regresar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 90, 70));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        SqlUsuarios modSql = new SqlUsuarios();
        usuarios mod = new usuarios();

        String pass = new String(txtPassword.getPassword());
        String passCon = new String(txtConfirmaPassword.getPassword());

        if (txtUsuario.getText().equals("") || pass.equals("") || passCon.equals("") || txtNombre.getText().equals("") || txtCorreo.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Existen Campos Vacíos debe llenar todos los Campos");

        } else {

            if (pass.equals(passCon)) {

                if (modSql.existeUsuario(txtUsuario.getText()) == 0) {

                    if (modSql.esEmail(txtCorreo.getText())) {

                        String nuevoPass = hash.sha1(pass);

                        mod.setUsuario(txtUsuario.getText());
                        mod.setPassword(nuevoPass);
                        mod.setNombre(txtNombre.getText());
                        mod.setCorreo(txtCorreo.getText());
                        mod.setId_tipo(txtTipo.getSelectedIndex());
                        

                        if (modSql.registrar(mod)) {
                            JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
                            limpiar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al intentar Guardar un Registro");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El Correo Electornico no es Valido");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las Contraseñas no Coinciden");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
    }//GEN-LAST:event_formWindowClosing

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        
        Menu_Usuarios regres = new Menu_Usuarios();
        regres.show();
        dispose();
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void limpiar() {
        txtUsuario.setText("");
        txtPassword.setText("");
        txtConfirmaPassword.setText("");
        txtNombre.setText("");
        txtCorreo.setText("");
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
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Eti_titulo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField txtConfirmaPassword;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JComboBox<String> txtTipo;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
