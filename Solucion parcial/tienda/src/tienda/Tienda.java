/*
NOMBRE: JOSE ESTANISLAO LOPEZ TUBAC
0901-17-12
VARIANTE A
 */
package tienda;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Tienda {

    public static Scanner lector = new Scanner(System.in);
    public static int intotal[] = new int[10];
    public static String strproductos[] = {"chetos","gaseosas","dulces","chicles","aceites","jabon","desinfectante","arroz","huevos","leche","agua","azucar"};
    public static String stock[][] = new String[10][4];
    public static int intprecio,intcantidad,inttotalasociado,inttotalgeneral;
    
    
    public static void main(String[] args) {
        //llenado de la matriz
     llenadodematriz();
     //muestra los resultados en ´pantalla
     resultados();
     //muestra un vector con los nombres y total
     totalgeneral();
    }
    public static void llenadodematriz(){

    for (int  i = 0 ; i<=9; i++)
    {
    //llenado con un vector anteriormente declrado
    stock[i][0] = strproductos[(int)((Math.random()*12))];
    //declaracion del precio con metodo random
    intprecio =  ((int)(1 + Math.random ()*100));
    stock[i][1] = Integer.toString(intprecio);
    //declaracion de la cantidad con metodo random
    intcantidad = ((int)(1 + Math.random ()*10));
    stock[i][2] = Integer.toString(intcantidad);
    //operacion de precio por cantidad para ver el total asociado
    inttotalasociado = (intprecio * intcantidad);
    stock[i][3] = Integer.toString(inttotalasociado);
    }
    }
   public static void totalgeneral()
    {
   
           //en la variable intconversueldo se va a guardar lo que tiene la matriz en la posicion 3,convertido a un dato con entero
      
        for(int i = 0;i<=9;i++)
        { 
            //se convirte la operacion de la matriz a una variable para utilizarla en un proximo vector
          inttotalgeneral = Integer.parseInt(stock[i][3]);
          intotal[i] = inttotalgeneral;  
        }
       System.out.println("TOTAL GENERAL\n");
       for(int i = 0;i<10;i++)
       {
       System.out.println("NOMBRE DEL PRODUCTO: "+stock[i][0]+"\t\t\t    TOTAL GENERAL:"+intotal[i]);
       }
    
  
    }
     public static void resultados()
    {
       //IMPRESION DE LA MATRIZ
      System.out.println("_______________________________________________________________________________________");
      System.out.println("PRODUCTO\t\t\tPRECIO\t\t\tCANTIDAD\t\t\tTOTAL");
      for(int i = 0; i <=9;i++)
      {     
       System.out.println(""+stock[i][0]+"\t\t                   "+ stock[i][1]+"\t\t                "+stock[i][2]+"               \t\tQ."+stock[i][3]);
      System.out.println("_______________________________________________________________________________________");      
    }
    }
}
