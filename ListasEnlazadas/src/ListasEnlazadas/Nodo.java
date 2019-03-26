/*
NOMBRE: JOSE ESTANISLAO LOPEZ TUBAC
0901-17-12
*/
package ListasEnlazadas;

/**
 *
 * @author EDUARDO
 */
public class Nodo 
{
    	int info;
	public Nodo Siguiente;
	public Nodo (int dato)
	{
		info=dato;
	}
	public void verNodo()
	{
		System.out.print("(  "+info+" )");
	}

}
