
package estructuralibros;

public class Lista {
  
	private Nodo cabeza=null;//CREACION DE UN NODO CABEZA NULO
	private int longitud=0;
	private class Nodo {
		public Libro libro;//CREA UNA VARIABLE DE TIPO LIBRO
		public Nodo siguiente=null;//CREA UN NODO SIGUIENTE NULO
        public Nodo(Libro libro)
        {
            this.libro=libro;//LA VARIABLE LIBRO TENDRA LOS DATOS DE LA CLASE LIBRO
        }
        }
        public String Listar()
	{
		String Dato=" ";
		Nodo aux= cabeza;//CREA UN NODO QUE TIENE LA POSICION DE CABEZA
		while (aux!=null)
		{
                    //LA VARIABLE DATO SE IRA SUMANDO CON LOS DATOS QUE TIENE LA VARIABLE LIBRO
			Dato +="TITULO : " + aux.libro.getTitulo()+ "\n AUTOR : "+aux.libro.getAutor()+"\n ISBN : "+aux.libro.getIsbn()+"\n";
			aux=aux.siguiente;
		}
		return(Dato);
	}
	public void insertarPrincipio(Libro libro) {
            //CREA UN NODO QUE TENDRA LO QUE SE INGRESE
		Nodo nodo=new Nodo(libro);
                //NODO.SIGUENTES VA A TENER LA DIRECCION DEL PRIMER NODO
		nodo.siguiente=cabeza;
                //CABEZA VA A PUNTAR AL NODO
		cabeza=nodo;
                //SE IRAN SUMANDO CONFORME SE INGRESEN LOS DATOS
		longitud++;	
	}
	public void insertarFinal(Libro libro) {
            //CREA UN NODO QUE TENDRA LO QUE SE LE INGRESE
		Nodo nodo=new Nodo(libro);
                //SI CABEZA ES IGUAL A NULO
		if (cabeza==null) {
                    //LO INGRESARA EN CABEZA
			cabeza=nodo;
                        //DE LO CONTRARIO LE ASIGNARA UN PUNTERO A CUAL INGRESAR LOS DATOS
		} else {
			Nodo puntero=cabeza;
			while (puntero.siguiente!=null) {
				puntero=puntero.siguiente;
			}
			puntero.siguiente=nodo;
		}
		longitud++;
	}
	public void insertarDespues(int n, Libro libro) {
            //CREA UN NODO QUE TENDRA LO QUE SE LE INGRESE
		Nodo nodo=new Nodo(libro);
                 //SI CABEZA ES IGUAL A NULO
		if (cabeza==null) {
                    //LO INGRESARA EN EL PRIMER NODO
			cabeza=nodo;
		} else {
                    //DE LO CONTRARIO BUSCARA LA ULTIMA POSICION Y LO INGRESARA
			Nodo puntero=cabeza;
			int contador=0;
			while (contador<n && puntero.siguiente!=null) {
				puntero=puntero.siguiente;
				contador++;
			}
			nodo.siguiente=puntero.siguiente;
			puntero.siguiente=nodo;
		}
		longitud++;
	}
	public String obtener(int n) {
            
            String datos = "";
            //SI LA LISTA ESTA VACIA RETORNARA NULO
		if (cabeza==null) {
			return null;
		} else {
                    //DE LO CONTRARIO BUSCARA EL PUNTERO O LA DIRECCION QUE TIENE LA POSICION DESEADA 
			Nodo puntero=cabeza;
			int contador=0;
                        //MIENTRAS CONTADOR SEA MENOR A LA POSICION BUSCADA Y EL PUNTERO SEA DISTINTO A NULO 
			while (contador<n && puntero.siguiente!=null) {
                            //PUNTERO TENDRA LA POSICION DEL QUE SE BUSCA
				puntero=puntero.siguiente;
				contador++;
			}
                        //SI NO SE ENCUENTRA LA POSICION DESEADA RETORNARA NILO
			if (contador!=n) {
				return null;
			} else {
                            //SI SE ENCUENTRA LA POSICION DESEADA MANDARA LA VARIABLE DATOS
				datos +="TITULO : " + puntero.libro.getTitulo()+ "\n AUTOR : "+puntero.libro.getAutor()+"\n ISBN : "+puntero.libro.getIsbn()+"\n";
                                return datos;
			}
		}
	}
	public int contar() {
            //CUENTA LA CANTIDAD DE NODOS QUE TIENE LA LISTA
		return longitud;
	}
        public boolean estaVacia() {
            //VERIFICA SI LA LISTA ESTA VACIA, SI ES ASI RETORNA NULO
            return cabeza==null;
        }
        public void eliminaPrincipio() {
            //VERIFICA SI LA DIRECCION ESTA VACIA, SI NO ESTA VACIA
            if (cabeza!=null){
                //NODO PRIMER TENDRA LA DIRECCION DE MEMORIA DEL PRIMER NODO
                Nodo primer = cabeza;
                //CEL SIGUIENTE NODO TENDRA LA DIRECCION DE NULO
                cabeza=cabeza.siguiente=null;
                longitud--;
                //SE IRAN RESTANDO LOS NODOS
            }
        }
        public void eliminarUltimo() {
            //VERIFICA SI LA DIRECCION ESTA VACIA, SI NO ESTA VACIA
            if (cabeza!= null) {
                //SI CABEZA.SIGUENTE ES DISTINTO A NULO
                if (cabeza.siguiente==null) {
                    //CABEZA SERA NULO
                    cabeza=null;  
                    //SE IRAN RESTANDO LOS NODOS
                    longitud--;
                } else {
                    //DE LO CONTRARIO EL PUNTERO SERA IGUAL A CABEZA
                    Nodo puntero=cabeza;
                    //MIENTRTAS EL PUNTERO SEA DISITINTO A NULO 
                    while (puntero.siguiente.siguiente!=null) {   
                        //PUNTYERO SERA IGUAL A LA DIRECCION DEL SIGUIENTE NODO
                        puntero=puntero.siguiente;
                    }
                    puntero.siguiente=null;
                    longitud--;
                }
            }
        }
        public void eliminarLibro(int n) {
            if (cabeza!=null){
                //SI EL NUMERO INGRESADO POR EL USUARIO ES LA POSICION 0
                if (n==0){
                    //EL NODO PRIMERO TENDRA LA DIRECCION DE CABEZA
                    Nodo primer=cabeza;
                    //CABEZA SERA IGUAL AL LA DIRECCION DEL SIGUIENTE NODO
                    cabeza=cabeza.siguiente;
                    //EL NODO PRIMER. SIGUIENTE SERA IGUAL A NULO
                    primer.siguiente=null;
                    //SE IRAN RESTANDO LOS DATOS DE LA LISTA
                    longitud--;
                    //DE LO CONTRARIO SI EL DATO INGRESADO POR EL USUARIO ES MENOR A LOS DATOS QUE TIENE LA LISTA
                } else if (n<longitud) {
                    Nodo puntero=cabeza;
                    int contador=0;
                    while (contador<(n-1)){
                        puntero=puntero.siguiente;
                        contador++;
                    }
                    Nodo temp=puntero.siguiente;
                    puntero.siguiente=temp.siguiente;
                    temp.siguiente=null;
                    longitud--;
                }
            }
        }
}
