package torres;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Torres {
    public static void main(String[] args) {
       Scanner leer = new Scanner (System.in);
       String discos;
       int cantidad;
       discos = JOptionPane.showInputDialog(null, "INGRESE LA CANTIDAD DE DISCOS QUE DESEA");
       cantidad = Integer.parseInt(discos);
        int movimientos = (int)(Math.pow(2, cantidad) -1);
        System.out.println("EL NUMERO MINIMO DE MOVIMIENTOS ES "+movimientos);
        for(int i = 1; i <= cantidad; i++)
        {
           System.out.print("["+i+"]\n"); 
        }
        System.out.print("TORRE 1 \tTORRE 2 \tTORRE 3\n");
       jannoi(cantidad,1,2,3);
    }
 
    public static void jannoi(int cantidad, int inicio,int auxiliar, int destino) {
       
       if(cantidad == 1){
           System.out.println("["+cantidad+"] DE LA TORRE"+inicio+" A LA TORRE "+destino);
       }else{
           jannoi(cantidad - 1,inicio, destino, auxiliar);
             System.out.println("["+cantidad+"] DE LA TORRE "+inicio+" A LA TORRE "+destino);
             jannoi(cantidad - 1,auxiliar, inicio, destino);
       }
        }
    }

