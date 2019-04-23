/*
NOMBRE: JOSE ESTANISLAO LOPEZ TUBAC
CARNET: 0901-17-12
*/

package pilas;

import javax.swing.JOptionPane;

public class Pilas {
    public static String titulo, autor,isbn,opcion,posicion,menuregresar;
    public static int op,posicionnodo,opcionwhile;
    public static  datos libro;
    public static  procesos milista = new procesos();
    //funcion que permite ingresar los datos a variables
    public static void ingreso()
    {
    titulo = JOptionPane.showInputDialog(null,"INGRESE EL TITULO DEL LIBRO");
    autor = JOptionPane.showInputDialog(null,"NGRESE EL AUTOR DEL LIBRO");
    isbn = JOptionPane.showInputDialog(null,"INGRESE EL CODIGO");
    libro = new datos(titulo,autor,isbn);
    }
  public static void menup()
  {
    opcion = JOptionPane.showInputDialog(null,",MENU DE OPCIONES:\n1.INGRESAR DATOS\n2.ELIMINAR DATOS\n3.MOSTRAR DATOS\n4.ULTIMO DATO");
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
        case 1:
            //ingreso de datos a la clase libro
           ingreso();
           //envio de datos a la funcion de insertar al incio de la lista
           milista.push(libro);
           JOptionPane.showMessageDialog(null,"LOS DATOS SE GUARDARON EXITOSAMENTE");
            break;
        case 2: 

           milista.pop();
           JOptionPane.showMessageDialog(null,"EL DATO SE ELIMINO CORRECTAMENTE");
            break;
         case 3: 
           JOptionPane.showMessageDialog(null,milista.Mostrar());
            break;
              case 4: 
           JOptionPane.showMessageDialog(null,milista.top());
            break;
    }
    //menu sobre si desea salir o no del programa
    menuregresar();
    }while(opcionwhile != 1);
   }
    
}
