/*
NOMBRE:JOSE ESTANISLAO LOPEZ TUBAC
0901-17-12
Este programa realiza los calculos para una planilla con distintos empleados, de diferentes departamentos
 */
package laboratorio3;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static laboratorio3.Laboratorio3.nomb;
public class Laboratorio3 {
    //declaracion de variables globales
    public static String plani[][] = new String[10][11];
    public static String nomb[] = {"jose" ,"laib  "," carlos","daniel","javier","brian","bryan","kike","ricardo","richi"};

    public static Scanner lector = new Scanner(System.in);
    public static float dep[] = new float[5]; 
    public static  String ISR[][] = new String[10][3];
    public static  int intcodemp = 0,intsueldobase = 0,intdescuento,intconversueldo,intbonificacion,intpercepciones,intopcion,intcomision,opcion,intsueldoliquido,intdep = 0;
    public static float fltigss,fltsueldoliquido,fltsumatoria,fltisr = 0,fltdeducciones;
    public static double fltvalorigss = 0.0483;
    public static float fltisr1 = (float) 0.03 , fltisr2 = (float) 0.05, fltisr3 = (float) 0.1;
    public static  DecimalFormat df = new DecimalFormat("#.00");
    public static String op;
        
    //comentarios de prueba 1
    //comentarios de prueba 2
    //comentarios de prueba 3
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
                     //lenado de codigos automaticos por medio de procesos
                    plani[j][0]= Integer.toString(codigodep(intdep));//Llenado de numeros random para el codigo de departamento por medio de un proceso
                    plani[j][1] = Integer.toString(codigoemp(intcodemp));//Llenado de numeros random para el codigo de empleado
                    plani[j][2] = nomb[(int)((Math.random()*9))];//Llenado de nombres random 
                    intsueldobase = (int) (2500 + (Math.random()*10000)); //Llenados de numero
                    plani[j][3] = Integer.toString(intsueldobase);
                    intbonificacion = (int)((Math.random()*500)+1);
                    plani[j][4] = Integer.toString(intbonificacion);
                    intcomision = (int)((Math.random()*500)+ 1);
                    plani[j][5] = Integer.toString(intcomision);
                    //introduccion de la respúesta en la variable para ver si calcular el igss
                    op = JOptionPane.showInputDialog(null,"PLANILLA DE SALARIOS\nEL EMPLEADO No."+(j+1)+" PAGA IGSS?\n1.SI\n2.NO");
                    intopcion = Integer.parseInt(op);
                    switch(intopcion)
                    {
                        case 1:
                            fltigss = (float) (((intsueldobase + intcomision )*fltvalorigss));        
                            plani[j][6] = String.valueOf(df.format(fltigss));
                            plani[j][10] = "SI";
                            break;
                        case 2:
                            fltigss = 0;                
                            plani[j][6] = String.valueOf(df.format(fltigss));
                            plani[j][10] = "NO";
                            break;
                 
                    }
                    intdescuento = (int)((Math.random()*500)+1);                   
                    plani[j][7] = Integer.toString(intdescuento);
                    
                    if(intsueldobase >=2500 && intsueldobase <= 5000)
                    {
                    fltisr = (float) ((intsueldobase)*fltisr1);
                    plani[j][8] = String.valueOf(df.format(fltisr));
                    }else if(intsueldobase >5001 && intsueldobase <10000)
                    {
                     fltisr = (float) ((intsueldobase)*fltisr2); 
                     plani[j][8] = String.valueOf(df.format(fltisr));
                    }else if(intsueldobase >=10001 )
                    {
                     fltisr = (float) ((intsueldobase)*fltisr3); 
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
        //asignacion de las percepciones a una variable
     intpercepciones = intsueldobase + intbonificacion +intcomision;   
    }
     public static void deducciones()
    {
        //asignacion de las deducciones a una variable
        fltdeducciones = fltigss +intdescuento + fltisr;
    }
     public static void sueldoliquido()
    {
      fltsueldoliquido = (intpercepciones-fltdeducciones);
    }
    public static void resultados()
    {
       //IMPRESION DE LA MATRIZ
      System.out.println("______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
      System.out.println("No.DEPARTAMENTO\t\tCODIGO\t\tNOMBRE     \t\tSUELDO BASE\t\tBONIFICACION\t\tCOMISIONES\t\tIGSS     \t\t\tDESCUENTOS J.\t\tISR\t\tSUELDO LIQUIDO\t\tPAGA IGSS");
      for(int i = 0; i <10;i++)
      {    
       System.out.println("\t"+plani[i][0]+"\t\t"+ plani[i][1]+"\t\t"+plani[i][2]+"       \t\tQ."+plani[i][3]+"\t\t\tQ."
               + ""+plani[i][4]+"\t\t\tQ."+plani[i][5]+"\t\t\tQ."+plani[i][6]+"     \t\t\tQ."+plani[i][7]+"\t\t\tQ."+plani[i][8]+"  \t\tQ."+plani[i][9]+"\t\t"+plani[i][10]);
       System.out.println("______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
      }     
    }
    public static void totaldep()
    {
    for(int i = 0; i<10;i++)
      {
          //en la variabel fltsumatoria se va a guardar lo que tiene la matriz en la posicion 9,convertido a un dato con decimal
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
           //en la variable intconversueldo se va a guardar lo que tiene la matriz en la posicion 3,convertido a un dato con entero
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
        else if(intconversueldo >=  10001 && intconversueldo <= 100000)
        {
            ISR[i][0] = plani[i][2];
            ISR[i][1] = "10%";
            ISR[i][2] = plani[i][8];
        } 
       }
    System.out.println("PORCENTAJE DE ISR POR EMPLEADO: \n");
       for(int i = 0;i<10;i++)
       {
           System.out.println("EMPLEADO "+(i+1)+":"+ISR[i][0]+"           \t\t\tPAGA:"+ISR[i][1]+"     \t\t\t\tEL ISR ES:"+ISR[i][2]);
       }
    }
    public static void menuregresar()
    {
        //menu para ciclo do-while
       System.out.println("\n¿DESEA VOLVER A INGRESAR LOS NOMBRES?\n1.si\n2.no");
       opcion = lector.nextInt();
    }
    
}
