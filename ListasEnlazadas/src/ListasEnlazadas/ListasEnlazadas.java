/*
NOMBRE: JOSE ESTANISLAO LOPEZ TUBAC
0901-17-12
*/
package ListasEnlazadas;

import javax.swing.JOptionPane;

/**
 *
 * @author EDUARDO
 */
public class ListasEnlazadas
{
    	Nodo Primero;
	public ListasEnlazadas()
	{
		Primero=null;
	}
	public boolean vacia()
	{
		if (Primero==null)
		{
			return(true);
		} else
		{
			return(false);
		}
	}
	public void InsertarEnPrimero(int Dato)
	{
		Nodo Temporal=new Nodo(Dato); //Crea el nodo temporal
		Temporal.Siguiente=Primero; //corre al primero
		Primero=Temporal;   //lo coloca de primero
	}
	public void borrarPrimero()
	{
		Primero=Primero.Siguiente;
	}
	public String Listar()
	{
		String Dato=" ";
		Nodo aux=Primero;
		while (aux!=null)
		{
			Dato+="{" + aux.info + "}";
			aux=aux.Siguiente;
		}
		return(Dato);
	}
	public void borrarUltimo()
	{
		Nodo anterior=Primero;
		Nodo actual=Primero;
		while (actual.Siguiente!=null)
		{
			anterior=actual;
			actual=actual.Siguiente;
		}
		anterior.Siguiente=null;
	}
	public void borrarPosicion(int pos)
	{
		Nodo anterior=Primero;
		Nodo actual=Primero;
		int k=0;
		if (pos>0)
		{
			while (k!=pos && actual.Siguiente != null)
			{
				anterior=actual;
				actual=actual.Siguiente;
				k++;
				System.out.println("K       "+k);
			}
			anterior.Siguiente=actual.Siguiente;
		}
	}
        public String buscar(String posicion)
	{
	int dato = 0;
        String posicion1 = null ;
        Nodo aux  = Primero;
        Nodo sig ;
        do{
            if(Integer.toString(aux.info).equals(posicion))
            {
             aux = null;
             sig = null;
             posicion1 = Integer.toString(dato);
            }else
            {
            dato ++;
            aux = aux.Siguiente;
            sig = aux.Siguiente;
            if(sig  == null)
                posicion1 = "el dato no esta en la lista";
            }
        }while(sig!=null);
        return(posicion1);
        }
        public void borrar()
        {}

}