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
   
 }
    private void limpiartabla(){
        tbltotaldepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TOTAL POR DEPARTAMENTO"
            }
        ));
   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        limpiartabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     codigo();
     //fechas_nomina_encabezado();
     ingreso_nomina_detalle();
      

    private void btntotaldepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntotaldepActionPerformed
        totaldep();
    
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
       
  }