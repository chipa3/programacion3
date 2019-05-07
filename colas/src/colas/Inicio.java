/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

import static java.lang.System.exit;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */

import javax.swing.JOptionPane;

public class Inicio {
    public static String titulo, autor,isbn,opcion,posicion,menuregresar;
    public static int op,posicionnodo,opcionwhile;
    public static  Libro libro;
    public static  Colas milista = new Colas();
    //funcion que permite ingresar los datos a variables
    public static void ingreso()
    {
    titulo = JOptionPane.showInputDialog(null,"INGRESE EL TITULO DEL LIBRO");
    autor = JOptionPane.showInputDialog(null,"NGRESE EL AUTOR DEL LIBRO");
    isbn = JOptionPane.showInputDialog(null,"INGRESE EL CODIGO");
    libro = new Libro(titulo,autor,isbn);
    }
  public static void menup()
  {
    opcion = JOptionPane.showInputDialog(null,"MENU DE OPCIONES:\n0.SALIR\n1.INGRESAR DATOS\n2.ELIMINAR DATO\n3.MOSTRAR DATOS\n4.PRIMER DATO\n5.VER SI ESTA VACIA LA COLA\n6.VACIAR COLA");
    op = Integer.parseInt(opcion);  
  }
  public static void menuregresar()
  {
     menuregresar = JOptionPane.showInputDialog(null,"¿DESEA SALIR DEL PROGRAMA?\n1.SI\n2.NO");
    opcionwhile = Integer.parseInt(menuregresar); 
  }
   public static void main(String[] args)
   {
    do{
        //menu principal de opciones
    menup();
    switch(op)
    {
        case 0: 
            exit(0);
            break;
        case 1:
            ingreso();
           milista.insertarPrincipio(libro);
           JOptionPane.showMessageDialog(null,"LOS DATOS SE GUARDARON EXITOSAMENTE");
            break;
        case 2:
           milista.eliminarUltimo();
           JOptionPane.showMessageDialog(null,"EL DATO SE ELMINO CORRECTAMENTE");
            break;
             case 3:
              JOptionPane.showMessageDialog(null,"TITULO             AUTOR                ISB\n"+milista.Listar());
            break;
                
             case 4:
                  JOptionPane.showMessageDialog(null,"TITULO             AUTOR                ISB\n"+milista.top());
            break;
             case 5:
                  JOptionPane.showMessageDialog(null,milista.vacia());
            break;
             case 6:
                 milista.Vaciar();
           JOptionPane.showMessageDialog(null,"SE HA VACIADO LA PILA CORRECTAMENTE");
            break;
    }
    //menu sobre si desea salir o no del programa
    menuregresar();
    }while(opcionwhile != 1);
   }
    
}
