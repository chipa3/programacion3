/*
NOMBRE:JOSE ESTANISLAO LOPEZ TUBAC
0901-17-12
 */
package laboratorio3;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Laboratorio3 {
    public static void main(String[] args) {
      int dep[] = new int[5];
      Scanner lector = new Scanner(System.in);
      String plani[][] = new String[10][6];
      String sueldoBase,descuentos,percepciones,sueldo,departamento;
      int intsueldobase,intdescuentos,intpercepciones,opcion,intsueldo = 0,intdep = 0;
       do{  

             for(int j = 0;j <10;j++)
                    {
                    intdep = (int) (1 + (Math.random()*5));
                    departamento = Integer.toString(intdep);  
                    plani[j][0] = departamento;                    
                    plani[j][1] = JOptionPane.showInputDialog(null,"PLANILLA DE SALARIOS\nINGRESE EL NOMBRE No."+(j+1));
                    //INGRESO DE CANTIDADES ALEATOREAS A UNA VARIABLE DE TIPO INT
                    intsueldobase = (int)(2500 + Math.random()*5000);
                    //CONVERSION DE UNA VARIABLE INT A UNA STRING
                    sueldoBase = Integer.toString(intsueldobase);
                    //ASIGNACION DE LA VARIABLE STRING A UNA COLUMNA EN LA MATRIZ
                    plani[j][2] = sueldoBase;
                     //INGRESO DE CANTIDADES ALEATOREAS A UNA VARIABLE DE TIPO INT
                    intdescuentos = (int)(1 + Math.random()*2500);
                    //CONVERSION DE UNA VARIABLE INT A UNA STRING
                    descuentos = Integer.toString(intdescuentos);
                    //ASIGNACION DE LA VARIABLE STRING A UNA COLUMNA EN LA MATRIZ
                    plani[j][3] = descuentos;
                     //INGRESO DE CANTIDADES ALEATOREAS A UNA VARIABLE DE TIPO INT
                    intpercepciones = (int)(1+ Math.random()*2500);
                     //CONVERSION DE UNA VARIABLE INT A UNA STRING
                    percepciones = Integer.toString(intpercepciones);
                    //ASIGNACION DE LA VARIABLE STRING A UNA COLUMNA EN LA MATRIZ
                    plani[j][4] = percepciones;
                    //OPERACION DE SUMA Y RESTA Y LA ASIGANACION A UNA VARIABLE DE TIPO INT
                    intsueldo = intsueldobase + intpercepciones - intdescuentos;
                     //CONVERSION DE UNA VARIABLE INT A UNA STRING
                    sueldo = Integer.toString(intsueldo);
                     //ASIGNACION DE LA VARIABLE STRING A UNA COLUMNA EN LA MATRIZ
                  plani[j][5] =sueldo ;                
                    }
      //impresion de los vectores y arreglos
      System.out.println("_________________________________________________________________________________________________________");
      System.out.println("No.DEPARTAMENTO-------NOMBRES-------SUELDO BASE-------DESCUENTOS-------PERCEPCIONES-------SUELDO LIQUIDO");
      for(int i = 0; i <10;i++)
      {
      //IMPRESION EN PANTALLA DE COLUMNAS Y FILAS DE UNA MATRIZ Y UN VECTOR     
      System.out.println("\t"+plani[i][0]+"\t\t"+ plani[i][1]+"\t\tQ."+plani[i][2]+"\t\tQ."+plani[i][3]+"\t\tQ."+plani[i][4]+"\t\t\tQ."+plani[i][5]);
      System.out.println("_________________________________________________________________________________________________________");   
      } 
      int dep1 = 0,dep2 = 0,dep3=0,dep4=0,dep5=0,sumatoria;
      for(int i = 0; i<10;i++)
      {
          //sumatoria va a guardar el valor que esta en la matriz pero convertida a entero
        sumatoria   = Integer.parseInt(plani[i][5]);
      if(plani[i][0].equals("1"))
      {
          //en la posicion 0 se guardara lo que tiene el vector mas lo que tiene la matriz, asi repetidamente mediante se cumpla el if
        dep[0]= dep[0] + sumatoria;
      }
       if(plani[i][0].equals("2"))
      {
      dep[1]= dep[1] + sumatoria;
      }
        if(plani[i][0].equals("3"))
      {
       dep[2]= dep[2] + sumatoria;
      }
         if(plani[i][0].equals("4"))
      {
       dep[3]= dep[3] + sumatoria;
      }
          if(plani[i][0].equals("5"))
      {
       dep[4]= dep[4] + sumatoria;
      }
      }
      for(int i = 0; i <=4;i++)
      {
       System.out.println("DEPARTAMENTO "+(i+1)+" = "+dep[i]);
      }
       //MENU PARA EL CICLO WHILE
       System.out.println("¿DESEA VOLVER A INGRESAR LOS NOMBRES?\n1.si\n2.no");
       opcion = lector.nextInt();       
       }while(opcion!=2);
    }
}

