
package colas;

public class Colas {
  
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
         public String top() {
             String datos = " ";
            if (cabeza!= null) {
                //SI CABEZA.SIGUENTE ES DISTINTO A NULO
                if (cabeza.siguiente==null) {
                   datos +="TITULO : " + cabeza.libro.getTitulo()+ "\n AUTOR : "+cabeza.libro.getAutor()+"\n ISBN : "+cabeza.libro.getIsbn()+"\n";
			
                } else {
                    //DE LO CONTRARIO EL PUNTERO SERA IGUAL A CABEZA
                    Nodo puntero=cabeza;
                    //MIENTRTAS EL PUNTERO SEA DISITINTO A NULO 
                    while (puntero.siguiente!=null) {   
                       
                        puntero=puntero.siguiente;
                    }
                   datos +="TITULO : " + puntero.libro.getTitulo()+ "\n AUTOR : "+ puntero.libro.getAutor()+"\n ISBN : "+ puntero.libro.getIsbn()+"\n";
		
                }
            }
            return(datos);
        }
        public String Listar()
	{
		String Dato=" ";
		Nodo aux= cabeza;//CREA UN NODO QUE TIENE LA POSICION DE CABEZA
		while (aux!=null)
		{
                    //LA VARIABLE DATO SE IRA SUMANDO CON LOS DATOS QUE TIENE LA VARIABLE LIBRO
			Dato +="" + aux.libro.getTitulo()+ "                          "+aux.libro.getAutor()+"                      "+aux.libro.getIsbn()+"\n";
			aux=aux.siguiente;
		}
		return(Dato);
	}
	public void push(Libro libro) {
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
	
        public boolean estaVacia() {
            //VERIFICA SI LA LISTA ESTA VACIA, SI ES ASI RETORNA NULO
            return cabeza==null;
        }
         public String vacia () {
            if (cabeza == null ) {
                return ("La cola esta vacia ");
            } else {
                return " La cola no esta vacia " ;
            }
           
        }
          public void Vaciar() {
          
            if (cabeza != null) {
              
                Nodo primer = cabeza;
              
                cabeza = cabeza . siguiente = null ;
              
                cabeza = null ;
               
                longitud = 0 ;
            }
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
        
        
}
