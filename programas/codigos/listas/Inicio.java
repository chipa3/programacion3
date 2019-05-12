
package estructuralibros;

import javax.swing.JOptionPane;

public class Inicio {
    public static String titulo, autor,isbn,opcion,posicion,menuregresar;
    public static int op,posicionnodo,opcionwhile;
    public static  Libro libro;
    public static  Lista milista = new Lista();
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
    opcion = JOptionPane.showInputDialog(null,"INGRESE LA OPCION QUE DESEA:\n1.INGRESAR AL PRINCIPIO\n2.INSERTAR EN POSICION\n3.INSERTAR AL FINAL\n4.ELIMINAR EL PRIMERO\n5.ELIMINAR EL FINAL\n6.ELIMINAR POSICION"
            + "\n7.BUSCAR LIBRO \n8.VER SI LA LISTA ESTA VACIA\n9.VER LA CANTIDAD DE NODOS\n10.MOSTRAR");
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
           milista.insertarPrincipio(libro);
           JOptionPane.showMessageDialog(null,"LOS DATOS SE GUARDARON EXITOSAMENTE");
            break;
        case 2: 
            posicion = JOptionPane.showInputDialog(null,"INGRESE LA POSICION EN LA QUE DESEA INGRESAR LOS DATOS");
           posicionnodo = Integer.parseInt(posicion);
             //ingreso de datos a la clase libro
           ingreso();
           milista.insertarDespues(posicionnodo,libro);
           JOptionPane.showMessageDialog(null,"LOS DATOS SE GUARDARON EXITOSAMENTE");
            break;
        case 3:
              //ingreso de datos a la clase libro
           ingreso();
           milista.insertarFinal(libro);
           JOptionPane.showMessageDialog(null,"LOS DATOS SE GUARDARON EXITOSAMENTE");
            break;
        case 4:
            //elimina el primer dato de la lista
           milista.eliminaPrincipio();
           JOptionPane.showMessageDialog(null,"LOS DATOS SE ELIMINARON EXITOSAMENTE");
           break;
        case 5:
            //elimina el ultimo dato de la lista
           milista.eliminarUltimo();
           JOptionPane.showMessageDialog(null,"LOS DATOS SE ELIMINARON EXITOSAMENTE");
            break;
        case 6:
            //elimina una posicion que el usuario desee
           posicion = JOptionPane.showInputDialog(null,"INGRESE LA POSICION EN LA QUE DESEA ELIMINAR LOS DATOS");
           posicionnodo = Integer.parseInt(posicion);
           milista.eliminarLibro(posicionnodo);
           JOptionPane.showMessageDialog(null,"LOS DATOS SE ELIMINARON EXITOSAMENTE");
            break;
        case 7:
            //muestra el dato buscado por el usuario
           posicion = JOptionPane.showInputDialog(null,"INGRESE LA POSICION EN LA QUE DESEA BUSCAR LOS DATOS");
           posicionnodo = Integer.parseInt(posicion);
           JOptionPane.showMessageDialog(null,milista.obtener(posicionnodo) );
            break;
        case 8:
            //MUESTRA SI LA LISTA ESTA VACIA
            JOptionPane.showMessageDialog(null,"LA LISTA ESTA VACIA: "+milista.estaVacia());
            break;
        case 9:
            //MUESTRA LA CANTIDAD DE DATOS DE LA LISTA
            JOptionPane.showMessageDialog(null,"LA LISTA TIENE : "+milista.contar()+" NODOS");
           
            break;
        case 10:
            //MUESTRA LOS DATOS DE LA LISTA
           JOptionPane.showMessageDialog(null,milista.Listar());
            break;
    }
    //menu sobre si desea salir o no del programa
    menuregresar();
    }while(opcionwhile != 1);
   }
    
}
