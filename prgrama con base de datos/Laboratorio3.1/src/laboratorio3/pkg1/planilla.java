/*
NOMBRE:JOSE ESTANISLAO LOPEZ TUBAC
0901-17-12
ESTE PROGRAMA ESTA BASADO EN LOS CALCULOS NECESARIOS PARA UNA PLANILLA DE EMPLEADOS DE VARIOS DEPARTAMENTOS
 */
package laboratorio3.pkg1;

import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class planilla extends javax.swing.JFrame {
    private final String StrPlanilla[][] = new String[10][11];//matriz de la nomina
    DecimalFormat deci= new DecimalFormat("#.00");//clase que controla la cantidad de decimales
    private int intfila,intcolumna,intopcionigss,intsueldobase = 0,intcomisiones,intdescuentosjudiciales,intbonificaciones;
    private String opcion;
    private   double dep[] = new double[10];
    private float fltigss, fltisr,fltsueldoliquido,fltvalorigss = (float) 0.0483, fltisr1 = (float) 0.03 , fltisr2 = (float) 0.05, fltisr3 = (float) 0.1, fltdeducciones,fltpercepciones,fltsumatoria;
    
    public planilla() {
       
        initComponents();
    
        getContentPane().setBackground(Color.GREEN);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        btnlimpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnaceptar.setText("INICIAR");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        tblresultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.Departamento", "Codigo empleado", "Nombre empleado", "Sueldo base", "Bonificacion", "Comisiones", "IGSS", "ISR", "Descuentos", "Sueldo liquido", "Paga IGSS"
            }
        ));
        jScrollPane1.setViewportView(tblresultados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1060, 260));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("PLANILLA DE SUELDOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        tbltotaldepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TOTAL DEPARTAMENTO"
            }
        ));
        jScrollPane2.setViewportView(tbltotaldepartamentos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 180, 120));

        btntotaldep.setText("total departamento");
        btntotaldep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntotaldepActionPerformed(evt);
            }
        });
        getContentPane().add(btntotaldep, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        btnlimpiar.setText("limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("DEPARTAMENTO 1");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("DEPARTAMENTO 2");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("DEPARTAMENTO 3");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("DEPARTAMENTO 4");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("DEPARTAMENTO 5");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tblresultados.getModel();
        Object[] Filas = new  Object[11];
        for(intfila=0;intfila<=9;intfila++)
        {
            for(intcolumna=0;intcolumna<=10;intcolumna++)
            {
                switch(intcolumna)
               {
                    case 0:
                        //llenado aleatoreo del departamento
                  StrPlanilla[intfila][intcolumna] = Integer.toString((int) (1 + Math.random()*5));
                  break;
                    case 1:
                        //llenado aleatoreo del codigo del empleado
                  StrPlanilla[intfila][intcolumna] = Integer.toString((int) (1 + Math.random()*200));
                        break;
                         case 2:
                        //llenado aleatoreo del codigo del empleado
                     StrPlanilla[intfila][intcolumna] = JOptionPane.showInputDialog(null,"INGRESE EL NOMBRE DEL EMPLEADO");
                        break;
                          case 3:
                        //llenado aleatoreo del sueldo base del empleado
                          intsueldobase = (int) (Math.random()*10000 + 2500) ;
                     StrPlanilla[intfila][intcolumna] =  Integer.toString(intsueldobase);
                        break;
                     case 4:
                        //llenado aleatoreo de  la bonificacion
                         intbonificaciones = (int) (250 + Math.random()*500);
                        StrPlanilla[intfila][intcolumna] =  Integer.toString(intbonificaciones);
                        break;
                        case 5:
                        //llenado aleatoreo de  las comisiones
                          intcomisiones = (int) (250 + Math.random()*500);   
                    StrPlanilla[intfila][intcolumna] =  Integer.toString(intcomisiones);
                        break;
                        case 6:
                        //calculo del igss
                        opcion = JOptionPane.showInputDialog(null,"¿EL EMPLEADO PAGA IGSS?\n1.SI\n2.NO");
                        intopcionigss = Integer.parseInt(opcion);
                        switch(intopcionigss)
                        {
                         case 1:
                            fltigss = (float) (((intsueldobase + intcomisiones)*fltvalorigss));        
                            StrPlanilla[intfila][intcolumna] = String.valueOf(deci.format(fltigss));
                            StrPlanilla[intfila][10] = "SI";
                            break;
                        case 2:
                            fltigss = 0;                
                            StrPlanilla[intfila][intcolumna] = String.valueOf(deci.format(fltigss));
                            StrPlanilla[intfila][10] = "NO";
                            break;
                        }
                        break;
                        case 7:
                     if(intsueldobase >=2500 && intsueldobase <= 5000)
                    {
                    fltisr = (float) ((intsueldobase)*fltisr1);
                    StrPlanilla[intfila][intcolumna] = String.valueOf(deci.format(fltisr));
                    }else if(intsueldobase >5001 && intsueldobase <10000)
                    {
                    fltisr = (float) ((intsueldobase)*fltisr2); 
                    StrPlanilla[intfila][intcolumna] = String.valueOf(deci.format(fltisr));
                    }else if(intsueldobase >=10001 )
                    {
                    fltisr = (float) ((intsueldobase)*fltisr3); 
                    StrPlanilla[intfila][intcolumna] = String.valueOf(deci.format(fltisr));
                    }  
                      break;
                        case 8:
                            intdescuentosjudiciales = (int) (250 + Math.random()*500);
                             StrPlanilla[intfila][intcolumna] =  Integer.toString(intdescuentosjudiciales);
                            break;
                        case 9:
                            fltdeducciones = (fltigss + fltisr + intdescuentosjudiciales);
                            fltpercepciones = (intsueldobase + intcomisiones + intbonificaciones);
                            fltsueldoliquido = (fltpercepciones - fltdeducciones);
                            StrPlanilla[intfila][intcolumna] =  String.valueOf(fltsueldoliquido);
                            break;
                       
               }
                //Guardado en la variable objeto Fila de cada dato de cada columna
                Filas[intcolumna]=StrPlanilla[intfila][intcolumna];
            }
            //agregamos el arreglo de cada fila a la tabla
            modelo.addRow(Filas);
            //Asignamos y/o aplicamos el modelo a nuestra tabla
            tblresultados.setModel(modelo);
    }//GEN-LAST:event_btnaceptarActionPerformed
    }
    
    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
       
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btntotaldepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntotaldepActionPerformed
        totaldep();
      DefaultTableModel tabladep = (DefaultTableModel) tbltotaldepartamentos.getModel();
      for(int i = 0;i<5;i++)
      {
      Object[] modelo = {deci.format(dep[i])};
      tabladep.addRow(modelo);
      }
      tbltotaldepartamentos.setModel(tabladep);
    }//GEN-LAST:event_btntotaldepActionPerformed
  public void totaldep()
  {
   for(int columna = 0; columna<=9;columna++)
      {
        fltsumatoria = Float.parseFloat(StrPlanilla[columna][9]);
          if(StrPlanilla[columna][0].equals("1"))
      {
         dep[0] = dep[0] + fltsumatoria;
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
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btntotaldep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblresultados;
    private javax.swing.JTable tbltotaldepartamentos;
    // End of variables declaration//GEN-END:variables
}