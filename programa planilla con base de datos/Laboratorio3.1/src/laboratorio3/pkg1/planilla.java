/*
NOMBRE:JOSE ESTANISLAO LOPEZ TUBAC
0901-17-12
ESTE PROGRAMA ESTA BASADO EN LOS CALCULOS NECESARIOS PARA UNA PLANILLA DE EMPLEADOS DE VARIOS DEPARTAMENTOS
 */
package laboratorio3.pkg1;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class planilla extends javax.swing.JFrame {
    private int id,j;
    private float totalplanilla = (float) 0.0;
    private final String StrPlanilla[][] = new String[10][10];//matriz de la nomina
    private final String Strtotaldep[][]= new String[2][2];
    DecimalFormat deci= new DecimalFormat("#.00");//clase que controla la cantidad de decimales
    private int intfila = 0,intcolumna,intopcionigss,intsueldobase = 0,intcomisiones,intdescuentosjudiciales,intbonificaciones;
    private String opcion;
    private  float dep[] = new float[11];
    private float fltigss, fltisr,fltsueldoliquido,fltvalorigss = (float) 0.0483, fltisr1 = (float) 0.03 , fltisr2 = (float) 0.05, fltisr3 = (float) 0.1, fltdeducciones,fltpercepciones,fltsumatoria;
    public planilla() {
       
        initComponents();
        this.setTitle("PLANILLA GENERAL DE EMPLEADOS");
        this.setLocationRelativeTo(planilla.this);
        this.setResizable(false);
        getContentPane().setBackground(Color.GREEN);
        
    }
      public void tablamodelo(){
        tblresultados.setModel(new javax.swing.table.DefaultTableModel(
        StrPlanilla,new String [] {"No.Departamento", "Codigo empleado", "Nombre empleado", "Sueldo base", "Bonificacion", "Comision", "IGSS", "ISR", "Descuentos judiciales","Sueldo liquido"}
        ));}
      public void tablatotaldep(){
          tbltotaldepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {dep[0]},
                {dep[1]},
                {dep[2]},
                {dep[3]},
                {dep[4]},
                {dep[5]},
                {dep[6]},
                {dep[7]},
                {dep[8]},
                {dep[9]}
            },
            new String [] {
                "TOTAL POR DEPARTAMENTOS"
            }
        ));}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnaceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblresultados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbltotaldepartamentos = new javax.swing.JTable();
        btntotaldep = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        fecha_inicial = new com.toedter.calendar.JDateChooser();
        fecha_final = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnaceptar.setText("MOSTRAR DATOS");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        tblresultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.Departamento", "Codigo empleado", "Nombre empleado", "Sueldo base", "Bonificacion", "Comisiones", "IGSS", "ISR", "Descuentos", "Sueldo liquido"
            }
        ));
        jScrollPane1.setViewportView(tblresultados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 1190, 210));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("PLANILLA DE SUELDOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        tbltotaldepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TOTAL POR DEPARTAMENTO"
            }
        ));
        jScrollPane2.setViewportView(tbltotaldepartamentos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 280, 230));

        btntotaldep.setText("total departamento");
        btntotaldep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntotaldepActionPerformed(evt);
            }
        });
        getContentPane().add(btntotaldep, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 610, 280, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("DEPARTAMENTO 1");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("DEPARTAMENTO 2");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setText("DEPARTAMENTO 3");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, 10));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("DEPARTAMENTO 4");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, 10));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setText("DEPARTAMENTO 5");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, 10));

        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 610, 120, -1));

        jButton2.setText("LIMPIAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 610, -1, -1));

        jButton4.setText("GUARDAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 140, -1));

        jLabel7.setText("FECHA INICIAL DE LA PLANILLA");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));
        getContentPane().add(fecha_inicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 300, -1));
        getContentPane().add(fecha_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 310, -1));

        jLabel8.setText("FECHA FINAL DE LA PLANILLA");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setText("DEPARTAMENTO 6");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, 10));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel10.setText("DEPARTAMENTO 7");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, -1, 10));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setText("DEPARTAMENTO 8");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel12.setText("DEPARTAMENTO 9");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel13.setText("DEPARTAMENTO 10");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        try{//
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");
            PreparedStatement pst = cn.prepareStatement(" select * from empleado");
            ResultSet rs = pst.executeQuery();
            boolean verificador=rs.next();
            while(verificador){
                StrPlanilla[intfila][0]=rs.getString(5);
                StrPlanilla[intfila][1]=rs.getString(1);
                StrPlanilla[intfila][2]=rs.getString(2);
                StrPlanilla[intfila][3]=rs.getString(3);
                StrPlanilla[intfila][4] = Integer.toString((int)(200 + Math.random()*500));
                StrPlanilla[intfila][5] = Integer.toString((int)(200 + Math.random()*500));
                fltigss=  (Float.parseFloat(StrPlanilla[intfila][3])*fltvalorigss);
                StrPlanilla[intfila][6]=String.valueOf(fltigss);
                intsueldobase= Integer.parseInt(StrPlanilla[intfila][3]);
               if(intsueldobase >= 2500  && intsueldobase <= 5000 )
                 {
                  fltisr = ( float ) ((intsueldobase) * fltisr1);
                  StrPlanilla [intfila] [7] =  String.valueOf(deci.format(fltisr));
                  } else  if (intsueldobase >= 5001  && intsueldobase <= 10000 )
                  {
                   fltisr = ( float ) ((intsueldobase) * fltisr2);
                   StrPlanilla [intfila] [7] =  String . valueOf (deci . format (fltisr));
                   } else  if (intsueldobase >= 10001 )
                   {
                   fltisr = ( float ) ((intsueldobase) * fltisr3);
                   StrPlanilla [intfila] [7] =  String . valueOf (deci . format (fltisr));
                   }
                StrPlanilla[intfila][8] = Integer.toString((int)(200 + Math.random()*500));
              fltsueldoliquido=(Float.parseFloat(StrPlanilla[intfila][3]))+(Float.parseFloat(StrPlanilla[intfila][4]))+(Float.parseFloat(StrPlanilla[intfila][5]))-(Float.parseFloat(StrPlanilla[intfila][6]))-(Float.parseFloat(StrPlanilla[intfila][7]))-(Float.parseFloat(StrPlanilla[intfila][8]));
              StrPlanilla[intfila][9]=String.valueOf(fltsueldoliquido);
               verificador=rs.next();
                intfila++;
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"ERROR AL MOSTRAR DATOS"+e);
        }
        tablamodelo();
   
    }//GEN-LAST:event_btnaceptarActionPerformed
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       MENUPRINCIPAL v = new MENUPRINCIPAL();
       v.show();
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void limpiartabla(){
        tbltotaldepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TOTAL POR DEPARTAMENTO"
            }
        ));
    tblresultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.Departamento", "Codigo empleado", "Nombre empleado", "Sueldo base", "Bonificacion", "Comisiones", "IGSS", "ISR", "Descuentos", "Sueldo liquido"
            }
        ));
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        limpiartabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     codigo();
     //fechas_nomina_encabezado();
     ingreso_nomina_detalle();
      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btntotaldepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntotaldepActionPerformed
        totaldep();
    }//GEN-LAST:event_btntotaldepActionPerformed
  public void ingreso_nomina_detalle()
  {
      if(((JTextField)fecha_inicial.getDateEditor().getUiComponent()).getText().equals("") && ((JTextField)fecha_final.getDateEditor().getUiComponent()).getText().equals(""))
      {
      JOptionPane.showMessageDialog(null,"PRIMERO DEBE GUARDAR LAS FECHAS DE LA PLANILLA");
      }else{
          fechas_nomina_encabezado();
      for(int i = 0; i<=9;i++){
      try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");            
            PreparedStatement pst = cn.prepareStatement("insert into detalle_nomina (codigo_nomina,codigo_empleado,codigo_concepto,valor_nomina_detalle) VALUES ('"+(j)+"', '"+(String.valueOf(StrPlanilla[i][1]))+"', '5', '"+(String.valueOf(StrPlanilla[i][4]))+"');");
            pst.executeUpdate();           
        }catch (Exception e){
            //JOptionPane.showMessageDialog(null,"ERROR AL INGRESAR DATOS DE BONIFICACION"+e);
        }
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");            
            PreparedStatement pst = cn.prepareStatement("insert into detalle_nomina (codigo_nomina,codigo_empleado,codigo_concepto,valor_nomina_detalle) VALUES ('"+(j)+"', '"+(String.valueOf(StrPlanilla[i][1]))+"', '4', '"+(String.valueOf(StrPlanilla[i][5]))+"');");
            pst.executeUpdate();           
        }catch (Exception e){
            //JOptionPane.showMessageDialog(null,"ERROR AL INGRESAR DATOS DE COMISION"+e);
        }
          try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");            
            PreparedStatement pst = cn.prepareStatement("insert into detalle_nomina (codigo_nomina,codigo_empleado,codigo_concepto,valor_nomina_detalle) VALUES ('"+(j)+"', '"+(String.valueOf(StrPlanilla[i][1]))+"', '1', '"+(String.valueOf(StrPlanilla[i][6]))+"');");
            pst.executeUpdate();           
        }catch (Exception e){
           // JOptionPane.showMessageDialog(null,"ERROR AL INGRESAR DATOS DE IGSS"+e);
        }
            try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");            
            PreparedStatement pst = cn.prepareStatement("insert into detalle_nomina (codigo_nomina,codigo_empleado,codigo_concepto,valor_nomina_detalle) VALUES ('"+(j)+"', '"+(String.valueOf(StrPlanilla[i][1]))+"', '2', '"+(String.valueOf(StrPlanilla[i][7]))+"');");
            pst.executeUpdate();           
        }catch (Exception e){
            //JOptionPane.showMessageDialog(null,"ERROR AL INGRESAR DATOS DE ISR"+e);
        }
              try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");            
            PreparedStatement pst = cn.prepareStatement("insert into detalle_nomina (codigo_nomina,codigo_empleado,codigo_concepto,valor_nomina_detalle) VALUES ('"+(j)+"', '"+(String.valueOf(StrPlanilla[i][1]))+"', '3', '"+(String.valueOf(StrPlanilla[i][8]))+"');");
            pst.executeUpdate();           
        }catch (Exception e){
           // JOptionPane.showMessageDialog(null,"ERROR AL INGRESAR DATOS DE DESCUENTOS JUDIACIALES"+e);
        }
                  try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");            
            PreparedStatement pst = cn.prepareStatement("insert into detalle_nomina (codigo_nomina,codigo_empleado,codigo_concepto,valor_nomina_detalle) VALUES ('"+(j)+"', '"+(String.valueOf(StrPlanilla[i][1]))+"', '6', '"+(String.valueOf(StrPlanilla[i][9]))+"');");
            pst.executeUpdate();           
        }catch (Exception e){
            //JOptionPane.showMessageDialog(null,"ERROR AL INGRESAR DATOS DE SUELDO LIQUIDO"+e);
        }
      }
      }
  }
    public void fechas_nomina_encabezado()
  {
      for(int i = 0; i <=10;i++)
      {
         totalplanilla = totalplanilla + dep[i];
      }
     try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/planilla", "root", "");
            PreparedStatement pst = cn.prepareStatement("insert into encabezado_nomina(codigo_nomina,fecha_inicial_nomina,fecha_final_nomina,valor_nomina) values('"+id+"','"+((JTextField)fecha_inicial.getDateEditor().getUiComponent()).getText()+"','"+((JTextField)fecha_final.getDateEditor().getUiComponent()).getText()+"','"+totalplanilla+"')");
            pst.executeUpdate();
           
           JOptionPane.showMessageDialog(null,"INGRESO EXITOSO");
        }catch (Exception e){
             System.out.println("ERROR AL REGISTRAR\n"+e);
        }  
  }
    public void totaldep()
  {
   for(int columna = 0; columna<=5;columna++)
      {
        fltsumatoria = Float.parseFloat(StrPlanilla[columna][9]);
          if(StrPlanilla[columna][0].equals("1"))
      {
        dep[0] = (dep[0] + fltsumatoria);
      }
      if(StrPlanilla[columna][0].equals("2"))
      {
          dep[1] = dep[1] + fltsumatoria;
      }
       if(StrPlanilla[columna][0].equals("3"))
      {
         dep[2] = dep[2] + fltsumatoria;
      }
      if(StrPlanilla[columna][0].equals("4"))
      {
        dep[3] = dep[3] + fltsumatoria;
      }
      if(StrPlanilla[columna][0].equals("5"))
      {
          dep[4] = dep[4] + fltsumatoria;
      }
      if(StrPlanilla[columna][0].equals("6"))
      {
          dep[5] = dep[5] + fltsumatoria;
      }
      if(StrPlanilla[columna][0].equals("7"))
      {
          dep[6] = dep[6] + fltsumatoria;
      }
      if(StrPlanilla[columna][0].equals("8"))
      {
          dep[7] = dep[7] + fltsumatoria;
      }
      if(StrPlanilla[columna][0].equals("9"))
      {
          dep[8] = dep[8] + fltsumatoria;
      }
      if(StrPlanilla[columna][0].equals("10"))
      {
          dep[9] = dep[9] + fltsumatoria;
      }
  }
   tablatotaldep();
  }       
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
            java.util.logging.Logger.getLogger(planilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(planilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(planilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(planilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new planilla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btntotaldep;
    private com.toedter.calendar.JDateChooser fecha_final;
    private com.toedter.calendar.JDateChooser fecha_inicial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblresultados;
    private javax.swing.JTable tbltotaldepartamentos;
    // End of variables declaration//GEN-END:variables
}
