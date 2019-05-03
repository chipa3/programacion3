/*
NOMBRE: JOSE ESTANISLAO LOPEZ TUBAC
0901-17-12
*/
package torres_de_hanoi;


import java.util.Set;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer ;
import javax.swing.table.DefaultTableModel;

public class juego extends javax.swing.JFrame {
    int contador  =  0;
    pila Torre1;
    pila Torre2;
    pila Torre3;
    DefaultTableModel modelotabla1,modelotabla2,modelotabla3;
    int objetivo  = 0;
    double minimo = 0;
    boolean alto = false;
    public juego() {
        initComponents();
        modelotabla1 = (DefaultTableModel) torre1.getModel();
        modelotabla1.setRowCount(10);
        
        modelotabla2 = (DefaultTableModel) torre2.getModel();
        modelotabla2.setRowCount(10);
        
        modelotabla3 = (DefaultTableModel) torre3.getModel();
        modelotabla3.setRowCount(10);
        
        DefaultTableCellRenderer render1 = new  DefaultTableCellRenderer();
        render1.setHorizontalAlignment(SwingConstants.CENTER);
        torre1.getColumnModel().getColumn(0).setCellRenderer(render1);
        
        DefaultTableCellRenderer render2 = new  DefaultTableCellRenderer();
        render1.setHorizontalAlignment(SwingConstants.CENTER);
        torre2.getColumnModel().getColumn(0).setCellRenderer(render1);
        
        DefaultTableCellRenderer render3 = new  DefaultTableCellRenderer();
        render1.setHorizontalAlignment(SwingConstants.CENTER);
        torre3.getColumnModel().getColumn(0).setCellRenderer(render1);
        this.setTitle("TORRES DE HANOI");
        this.setLocationRelativeTo(juego.this);
        this.setResizable(false);
        
    }
        private void limpiar()
        {
            contador  = 0;
            minimo = 0;
            cmbdiscos.setSelectedItem(String.valueOf(objetivo));
        }      
          private void cantidad_de_movimientos()
        {
           contador++;
           txtmovimientos.setText(String.valueOf(contador));
        }       
          
          private void reiniciar()
          {
              try{
                    if(!txtminimo.getText().equals(""))
                    {
                        //cmbdiscos.setSelectedItem(String.valueOf(objetivo));
                        limpiar();
                        iniciar();
                        
                    }
               }catch(Exception E)
               {
                   JOptionPane.showMessageDialog(null,""+E);
               }
 
          }
           private void iniciar()
           {
               try{
        Torre1 = new pila();
        Torre2 = new pila();
        Torre3 = new pila();
        
        objetivo = Integer.parseInt(cmbdiscos.getSelectedItem().toString());
        minimo = Math.pow(2, objetivo )- 1;
        txtminimo.setText(String.valueOf(contador));
        txtminimo.setText(String.valueOf(String.format("%.0f",minimo)));
        for(int x = objetivo; x >= 1; x--)
        {
        Nodo plataforma = new Nodo();
        String disco = "";
        for(int y  = x; y > 0;y--)
        {
            disco+= "[0]";
        }
        plataforma.setDato(disco);
        Torre1.push(plataforma);
        }
        presentartorre1();
         presentartorre2();
          presentartorre3();
        
               }catch(Exception E)
               {
                   JOptionPane.showMessageDialog(null,""+E);
               }
 
           }
  private void presentartorre1()
  {
      ((DefaultTableModel)torre1.getModel()).setRowCount(0);
      modelotabla1.setRowCount(10);
      Nodo k;
      int RowDisco = (10 - Torre1.getContador());
      if(Torre1.getContador() > 0)
      {
          for(k = Torre1.getCabeza();k.getAbajo() != null ; k= k.getAbajo())
          {
            String[] vectornormal = {k.getDato()};
            modelotabla1.insertRow(RowDisco, vectornormal);
            RowDisco++;
          }
          if(k.getAbajo() ==  null)
          {
              String[] vectornormal = {k.getDato()};
            modelotabla1.insertRow(RowDisco, vectornormal);
          }
      }
      torre1.setModel(modelotabla1);
      modelotabla1.setRowCount(10);
      
  }
  private void presentartorre2()
  {
      ((DefaultTableModel)torre2.getModel()).setRowCount(0);
      modelotabla2.setRowCount(10);
      Nodo k;
      int RowDisco = (10 - Torre2.getContador());
      if(Torre2.getContador() > 0)
      {
          for(k = Torre2.getCabeza();k.getAbajo() != null ; k= k.getAbajo())
          {
            String[] vectornormal = {k.getDato()};
            modelotabla2.insertRow(RowDisco, vectornormal);
            RowDisco++;
          }
          if(k.getAbajo() ==  null)
          {
              String[] vectornormal = {k.getDato()};
            modelotabla2.insertRow(RowDisco, vectornormal);
          }
      }
      torre2.setModel(modelotabla2);
      modelotabla2.setRowCount(10);
  }
  private void presentartorre3()
  {
      ((DefaultTableModel)torre3.getModel()).setRowCount(0);
      modelotabla3.setRowCount(10);
      Nodo k;
      int RowDisco = (10 - Torre3.getContador());
      if(Torre3.getContador() > 0)
      {
          for(k = Torre3.getCabeza();k.getAbajo() != null ; k= k.getAbajo())
          {
            String[] vectornormal = {k.getDato()};
            modelotabla3.insertRow(RowDisco, vectornormal);
            RowDisco++;
          }
          if(k.getAbajo() ==  null)
          {
              String[] vectornormal = {k.getDato()};
            modelotabla3.insertRow(RowDisco, vectornormal);
          }
      }
      torre3.setModel(modelotabla3);
      modelotabla3.setRowCount(10);
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        torre2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        torre3 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        torre1 = new javax.swing.JTable();
        btn3_2 = new javax.swing.JButton();
        btn1_2 = new javax.swing.JButton();
        btn1_3 = new javax.swing.JButton();
        btn2_1 = new javax.swing.JButton();
        btn2_3 = new javax.swing.JButton();
        btn3_1 = new javax.swing.JButton();
        cmbdiscos = new javax.swing.JComboBox<>();
        txtminimo = new javax.swing.JTextField();
        txtmovimientos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btninicio = new javax.swing.JButton();
        btnreiniciar = new javax.swing.JButton();
        btnresolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        torre2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TORRE 2"
            }
        ));
        torre2.setEnabled(false);
        torre2.setFocusable(false);
        jScrollPane1.setViewportView(torre2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 140, 200));

        torre3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TORRE 3"
            }
        ));
        torre3.setEnabled(false);
        torre3.setFocusable(false);
        jScrollPane2.setViewportView(torre3);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 140, 200));

        torre1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TORRE 1"
            }
        ));
        torre1.setEnabled(false);
        torre1.setFocusable(false);
        jScrollPane3.setViewportView(torre1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 26, 150, 200));

        btn3_2.setText("2");
        btn3_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3_2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 50, 40));

        btn1_2.setText("2");
        btn1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1_2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 50, 40));

        btn1_3.setText("3");
        btn1_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1_3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 50, 40));

        btn2_1.setText("1");
        btn2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2_1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 50, 40));

        btn2_3.setText("3");
        btn2_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2_3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 50, 40));

        btn3_1.setText("1");
        btn3_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3_1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 50, 40));

        cmbdiscos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        getContentPane().add(cmbdiscos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 150, -1));

        txtminimo.setEditable(false);
        txtminimo.setEnabled(false);
        getContentPane().add(txtminimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 150, -1));

        txtmovimientos.setEnabled(false);
        getContentPane().add(txtmovimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 150, -1));

        jLabel1.setText("NUMERO DE DISCOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, -1));

        jLabel2.setText("MINIMO DE MOVIMIENTOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, -1, -1));

        jLabel3.setText("MOVIEMIENTOS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, -1, -1));

        btninicio.setText("INICIO");
        btninicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninicioActionPerformed(evt);
            }
        });
        getContentPane().add(btninicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        btnreiniciar.setText("REINICIAR");
        btnreiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreiniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnreiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, -1, -1));

        btnresolver.setText("RESOLVER");
        btnresolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnresolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void moverde1_2()
    {
        try{
            if(Torre1.getContador() > 0)
            {
                Nodo plataforma = new Nodo();
                plataforma.setDato(Torre1.peek());
                if(Torre2.getContador() > 0)
                {
                    if(plataforma.getDato().compareTo(Torre2.peek()) > 0)
                    {
                        return;
                    }
                }
                Torre1.pop();
                Torre2.push(plataforma);
                presentartorre1();
                presentartorre2();
                cantidad_de_movimientos();
            }
        }catch(Exception E)
        {
            JOptionPane.showMessageDialog(null,""+E);
        }
    }
    private void moverde1_3()
    {
         try{
            if(Torre1.getContador() > 0)
            {
                Nodo plataforma = new Nodo();
                plataforma.setDato(Torre1.peek());
                if(Torre3.getContador() > 0)
                {
                    if(plataforma.getDato().compareTo(Torre3.peek()) > 0)
                    {
                        return;
                    }
                }
                Torre1.pop();
                Torre3.push(plataforma);
                presentartorre1();
                presentartorre3();
                cantidad_de_movimientos();
                
                if(Torre3.getContador() == objetivo && contador == minimo)
                {
                    JOptionPane.showMessageDialog(null,"FELICIDADES HAS ALCANZADO EL NUMERO MINIMO DE MOVIMIENTOS\n\nINTENTA CON MAS DISCOS","FELICIDADES",JOptionPane.WARNING_MESSAGE);
                }else if(Torre3.getContador() == objetivo && contador != minimo)
                {
                    JOptionPane.showMessageDialog(null,"FELICIDADES HAS RESUELTO EL PROBLEMA\n\nINTENTA CON MENOS MOVIMIENTOS","FELICIDADES",JOptionPane.INFORMATION_MESSAGE);
                }
                  
                
                
            }
        }catch(Exception E)
        {
            JOptionPane.showMessageDialog(null,""+E);
        }
    }
    private void moverde2_1()
    {
             try{
            if(Torre2.getContador() > 0)
            {
                Nodo plataforma = new Nodo();
                plataforma.setDato(Torre2.peek());
                if(Torre1.getContador() > 0)
                {
                    if(plataforma.getDato().compareTo(Torre1.peek()) > 0)
                    {
                        return;
                    }
                }
                Torre2.pop();
                Torre1.push(plataforma);
                presentartorre1();
                presentartorre2();
                cantidad_de_movimientos();
            }
        }catch(Exception E)
        {
            JOptionPane.showMessageDialog(null,""+E);
        }
    }
    private void moverde2_3()
    {
                try{
            if(Torre2.getContador() > 0)
            {
                Nodo plataforma = new Nodo();
                plataforma.setDato(Torre2.peek());
                if(Torre3.getContador() > 0)
                {
                    if(plataforma.getDato().compareTo(Torre3.peek()) > 0)
                    {
                        return;
                    }
                }
                Torre2 .pop();
                Torre3.push(plataforma);
                presentartorre2();
                presentartorre3();
                cantidad_de_movimientos();
                
                if(Torre3.getContador() == objetivo && contador == minimo)
                {
                    JOptionPane.showMessageDialog(null,"FELICIDADES HAS ALCANZADO EL NUMERO MINIMO DE MOVIMIENTOS\n\nINTENTA CON MAS DISCOS","FELICIDADES",JOptionPane.WARNING_MESSAGE);
                }else if(Torre3.getContador() == objetivo && contador != minimo)
                {
                    JOptionPane.showMessageDialog(null,"FELICIDADES HAS RESUELTO EL PROBLEMA\n\nINTENTA CON MENOS MOVIMIENTOS","FELICIDADES",JOptionPane.INFORMATION_MESSAGE);
                }
                  
                
                
            }
        }catch(Exception E)
        {
            JOptionPane.showMessageDialog(null,""+E);
        }
    }
    private void moverde3_1()
    {
             try{
            if(Torre3.getContador() > 0)
            {
                Nodo plataforma = new Nodo();
                plataforma.setDato(Torre3.peek());
                if(Torre1.getContador() > 0)
                {
                    if(plataforma.getDato().compareTo(Torre1.peek()) > 0)
                    {
                        return;
                    }
                }
                Torre3.pop();
                Torre1.push(plataforma);
                presentartorre1();
                presentartorre3();
                cantidad_de_movimientos();
            }
        }catch(Exception E)
        {
            JOptionPane.showMessageDialog(null,""+E);
        }
    }
    private void moverde3_2()
    {
               try{
            if(Torre3.getContador() > 0)
            {
                Nodo plataforma = new Nodo();
                plataforma.setDato(Torre3.peek());
                if(Torre2.getContador() > 0)
                {
                    if(plataforma.getDato().compareTo(Torre2.peek()) > 0)
                    {
                        return;
                    }
                }
                Torre3.pop();
                Torre2.push(plataforma);
                presentartorre2();
                presentartorre3();
                cantidad_de_movimientos();
            }
        }catch(Exception E)
        {
            JOptionPane.showMessageDialog(null,""+E);
        }
    }
    private void btninicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninicioActionPerformed
        contador = 0;
        iniciar();
        txtmovimientos.setText("");
    }//GEN-LAST:event_btninicioActionPerformed

    private void btnreiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreiniciarActionPerformed
       reiniciar();
    }//GEN-LAST:event_btnreiniciarActionPerformed

    private void btn1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1_2ActionPerformed
       moverde1_2();
    }//GEN-LAST:event_btn1_2ActionPerformed

    private void btn1_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1_3ActionPerformed
      moverde1_3();
    }//GEN-LAST:event_btn1_3ActionPerformed

    private void btn2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2_1ActionPerformed
       moverde2_1();
    }//GEN-LAST:event_btn2_1ActionPerformed

    private void btn2_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2_3ActionPerformed
     moverde2_3();
    }//GEN-LAST:event_btn2_3ActionPerformed

    private void btn3_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3_1ActionPerformed
     moverde3_1();
    }//GEN-LAST:event_btn3_1ActionPerformed

    private void btn3_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3_2ActionPerformed
      moverde3_2();
    }//GEN-LAST:event_btn3_2ActionPerformed

    private void btnresolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnresolverActionPerformed

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
            java.util.logging.Logger.getLogger(juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1_2;
    private javax.swing.JButton btn1_3;
    private javax.swing.JButton btn2_1;
    private javax.swing.JButton btn2_3;
    private javax.swing.JButton btn3_1;
    private javax.swing.JButton btn3_2;
    private javax.swing.JButton btninicio;
    private javax.swing.JButton btnreiniciar;
    private javax.swing.JButton btnresolver;
    private javax.swing.JComboBox<String> cmbdiscos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable torre1;
    private javax.swing.JTable torre2;
    private javax.swing.JTable torre3;
    private javax.swing.JTextField txtminimo;
    private javax.swing.JTextField txtmovimientos;
    // End of variables declaration//GEN-END:variables
}
