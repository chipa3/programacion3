/*
NOMBRE: JOSE ESTANISLAO LOPEZ TUBAC
CARNET: 0901-17-12
*/

package pilas;

public class procesos {
  
	private Nodo cabeza=null;//CREACION DE UN NODO CABEZA NULO
	private int longitud=0;
	private class Nodo {
		public datos libro;//CREA UNA VARIABLE DE TIPO LIBRO
		public Nodo siguiente=null;//CREA UN NODO SIGUIENTE NULO
        public Nodo(datos libro)
        {
            this.libro=libro;//LA VARIABLE LIBRO TENDRA LOS DATOS DE LA CLASE LIBRO
        }
        }
        public String Mostrar()
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
        
	public void push(datos libro) {
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

        public void pop() {
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
       public String vacia () {
            if (cabeza == null ) {
                return ("La pila esta vacia ");
            } else {
                return " La pila no esta vacia " ;
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
}
