/*
NOMBRE:JOSE ESTANISLAO LOPEZ TUBAC
0901-17-12
 */
package laboratorio3;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Laboratorio3 {
    
    public static String plani[][] = new String[10][10];
    public static Scanner lector = new Scanner(System.in);
    public static float dep[] = new float[5];
    public static  String ISR[][] = new String[10][3];
    public static  int intcodemp = 0,intsueldobase = 0,intdescuento,intconversueldo,intbonificacion,intpercepciones,opcionisr,intcomision,opcion,intsueldoliquido,intdep = 0;
    public static float fltigss,fltsueldoliquido,fltsumatoria,fltisr = 0,fltdeducciones;
    public static  DecimalFormat df = new DecimalFormat("#.00");
    public static String op;
    
    public static int codigodep(int j)
    {
    //CODIGO RANDOM DE LOS DEPARTAMENTOS    
    intdep = (int) (1 + (Math.random()*5));                
    return intdep;
    }
    public static int codigoemp(int j)
    {
     //CODIGO RANDOM DE LOS EMPLEADOS   
    intcodemp = (int) (1 + (Math.random()*200));                
    return intcodemp;
    }
    public static void main(String[] args) {
        
       do{
        //LLENADO DE LA MATRIZ CON RANDOM Y OPERACIONES
            llenadomatriz();
        //SE MUESTRA LA MATRIZ
            resultados();
        //SE OPERAN Y MUESTRAN RESULTADOS POR DEPARTAMENTOS
            totaldep();
        //SE OPERAN Y MUESTRAN RESULTADOS DE IGSS POR 
            isremp();
        //MENU PARA EL CICLO DO-WHILE
            menuregresar();    
       }while(opcion!=2);
    }
   
    public static void llenadomatriz()
    {
         for(int j = 0;j <10;j++)
                    {
                    plani[j][0]= Integer.toString(codigodep(intdep));
                    plani[j][1] = Integer.toString(codigoemp(intcodemp));
                    plani[j][2] = JOptionPane.showInputDialog(null,"PLANILLA DE SALARIOS\nINGRESE EL NOMBRE DEL EMPLEADO No."+(j+1));
                    //op = JOptionPane.showInputDialog(null,"PLANILLA DE SALARIOS\nEL EMPLEADO No."+(j+1))+" PAGA ISR?\n1.SI\n2.NO";
                    intsueldobase = (int) (2500 + (Math.random()*10000)); 
                    plani[j][3] = Integer.toString(intsueldobase);
                    intbonificacion = (int)((Math.random()*500)+1);
                    plani[j][4] = Integer.toString(intbonificacion);
                    intcomision = (int)((Math.random()*500)+ 1);
                    plani[j][5] = Integer.toString(intcomision);
                    fltigss = (float) ((intsueldobase + intcomision )*0.0483);                
                    plani[j][6] = String.valueOf(df.format(fltigss));
                    intdescuento = (int)((Math.random()*500)+1);                   
                    plani[j][7] = Integer.toString(intdescuento);
                    
                    if(intsueldobase >=2500 && intsueldobase <= 5000)
                    {
                    fltisr = (float) ((intsueldobase)*0.03);
                    plani[j][8] = String.valueOf(df.format(fltisr));
                    }else if(intsueldobase >5001 && intsueldobase <10000)
                    {
                     fltisr = (float) ((intsueldobase)*0.05); 
                     plani[j][8] = String.valueOf(df.format(fltisr));
                    }else if(intsueldobase >10001 && intsueldobase <100001)
                    {
                     fltisr = (float) ((intsueldobase)*0.10); 
                     plani[j][8] = String.valueOf(df.format(fltisr));
                    }                                     
                    percepciones();
                    deducciones();
                    sueldoliquido();
                    plani[j][9] = String.valueOf(df.format(fltsueldoliquido));
                     }
    }
    
    public static void percepciones()
    {
     intpercepciones = intsueldobase + intbonificacion +intcomision;   
    }
     public static void deducciones()
    {
        fltdeducciones = fltigss +intdescuento + fltisr;
    }
     public static void sueldoliquido()
    {
      fltsueldoliquido = (intpercepciones-fltdeducciones);
    }
    public static void resultados()
    {
       //IMPRESION DE LA MATRIZ
      System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________");
      System.out.println("No.DEPARTAMENTO\t\tCODIGO\t\tNOMBRE\t\tSUELDO BASE\t\tBONIFICACION\t\tCOMISIONES\t\tIGSS\t\t\tDESCUENTOS J.\t\tISR\t\tSUELDO LIQUIDO");
      for(int i = 0; i <10;i++)
      {    
       System.out.println("\t"+plani[i][0]+"\t\t"+ plani[i][1]+"\t\t"+plani[i][2]+"\t\tQ."+plani[i][3]+"\t\t\tQ."
               + ""+plani[i][4]+"\t\t\tQ."+plani[i][5]+"\t\t\tQ."+plani[i][6]+"\t\tQ."+plani[i][7]+"\t\t\tQ."+plani[i][8]+"\t\tQ."+plani[i][9]);
       System.out.println("_________________________________________________________________________________________________________________________________________________________________________________________________________________");
      }     
    }
    public static void totaldep()
    {
    for(int i = 0; i<10;i++)
      { 
      fltsumatoria = Float.parseFloat(plani[i][9]);
      if(plani[i][0].equals("1"))
      {
         dep[0] = dep[0] + fltsumatoria;
      }
      if(plani[i][0].equals("2"))
      {
          dep[1] = dep[1] + fltsumatoria;
      }
       if(plani[i][0].equals("3"))
      {
         dep[2] = dep[2] + fltsumatoria;
      }
      if(plani[i][0].equals("4"))
      {
        dep[3] = dep[3] + fltsumatoria;
      }
      if(plani[i][0].equals("5"))
      {
          dep[4] = dep[4] + fltsumatoria;
      }
      }
     System.out.println("TOTAL DE GASTO POR DEPARTAMENTO: \n");
       for(int i = 0;i<=4;i++)
       {
           System.out.println("DEPATAMENTO "+(i+1)+":    "+dep[i]+"\n");
       }
    }
    public static void isremp()
    {
    for(int i = 0; i <10; i++)
       {
       intconversueldo = Integer.parseInt(plani[i][3]);
        if(intconversueldo >= 2500 && intconversueldo<=5000)
        {
          ISR[i][0] = plani[i][2];
          ISR[i][1] = "3%";
          ISR[i][2] = plani[i][8];
        }
        else if(intconversueldo >5000 && intconversueldo <=10000)
        {
          ISR[i][0] = plani[i][2];
          ISR[i][1] = "5%";
          ISR[i][2] = plani[i][8];
        }
        else if(intconversueldo >=  10000 && intconversueldo <= 100000)
        {
            ISR[i][0] = plani[i][2];
            ISR[i][1] = "10%";
            ISR[i][2] = plani[i][8];
        } 
       }
    System.out.println("PORCENTAJE DE ISR POR EMPLEADO: \n");
       for(int i = 0;i<10;i++)
       {
           System.out.println("EMPLEADO "+(i+1)+":"+ISR[i][0]+"\t\t\tPAGA:"+ISR[i][1]+"\t\t\tEL ISR ES:"+ISR[i][2]);
       }
    }
    public static void menuregresar()
    {
       System.out.println("\n¿DESEA VOLVER A INGRESAR LOS NOMBRES?\n1.si\n2.no");
       opcion = lector.nextInt();
    }
    
}
