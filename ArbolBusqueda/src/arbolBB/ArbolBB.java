
package arbolBB;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

 
public class ArbolBB {

    private Nodo raiz;
    int num_nodos;
    int alt;

    public ArbolBB() {
        raiz = null;
    }

      //buscar
      public Nodo buscar (int d, Nodo r)
      {
        if(raiz == null)
        {
            return null;
        }else if(r.dato==d){
            return r;
      }else if(r.dato < d)
      {
        return buscar(d,r.der); 
      }else
      {
          return buscar(d,r.izq);
      }
      }
      
      //obtener el factor de equilibrio
      public int obtenerFE(Nodo x)
      {
          //si el nodo x esta vacio retornara el valor de -1
          if(x== null)
          {
             return -1; 
          }else {
              //de lo contrario si tiene un elemento retornara el factor de equilibrio
              return x.fe;
          }
          
      }
      //rotacion simpre izquierda
      public Nodo rotacionizquierda(Nodo c)
      {
          Nodo auxiliar = c.izq;
          c.izq = auxiliar.der;
          auxiliar.der = c;
          c.fe =Math.max(obtenerFE(c.izq),obtenerFE(c.der))+1;
          auxiliar.fe = Math.max(obtenerFE(auxiliar.izq),obtenerFE(auxiliar.der))+1;
          return auxiliar;
      
      }
      //rotacion simpre derecha
        public Nodo rotacionderecha(Nodo c)
      {
          Nodo auxiliar = c.der;
          c.der = auxiliar.izq;
          auxiliar.izq = c;
          c.fe =Math.max(obtenerFE(c.izq),obtenerFE(c.der))+1;
          auxiliar.fe = Math.max(obtenerFE(auxiliar.izq),obtenerFE(auxiliar.der))+1;
          return auxiliar;
      
      }
      //rotacion doble izquierda
        public Nodo rotacionDobleIzquierda(Nodo c)
        {
           Nodo temporal;
           c.izq = rotacionderecha(c.izq);
           temporal  = rotacionizquierda(c);
           return temporal;
        }
        //rotacion doble derecha
        public Nodo rotacionDobleDerecha(Nodo c)
        {
           Nodo temporal;
           c.der = rotacionizquierda(c.der);
           temporal  = rotacionderecha(c);
           return temporal;
        }
        //metodo para insertar AVL
        public Nodo insertarAVL(Nodo nuevo, Nodo subAr)
        {
            Nodo nuevoPadre = subAr ;
            if(nuevo.dato<subAr.dato)
            {
                if(subAr.izq == null)
                {
                    subAr.izq = nuevo;
                }else
                {
                    subAr.izq = insertarAVL(nuevo,subAr.izq); 
                    if((obtenerFE(subAr.izq)-obtenerFE(subAr.der)==2))
                    {
                        if(nuevo.dato<subAr.izq.dato)
                        {
                            nuevoPadre = rotacionizquierda(subAr);
                        }else 
                        {
                            nuevoPadre = rotacionDobleIzquierda(subAr);
                        }
                    }
                }
            }else if(nuevo.dato >subAr.dato)
             {
                 if(subAr.der == null)
                 {
                     subAr.der = nuevo;
                 }else
                 {
                     subAr.der = insertarAVL(nuevo,subAr.der);
                       if((obtenerFE(subAr.der)-obtenerFE(subAr.izq)==2))
                       {
                           if(nuevo.dato>subAr.der.dato)
                        {
                            nuevoPadre = rotacionderecha(subAr);
                        }else 
                        {
                            nuevoPadre = rotacionDobleDerecha(subAr);
                        }
                       }
                 }
             }else
            {
                JOptionPane.showMessageDialog(null,"EL NODO ES DUPLICADO");
            }
            //ACTUALIZAR EL FACTOR DE EQUILIBRIO
            if((subAr.izq ==  null)&&(subAr.der != null))
            {
               subAr.fe = subAr.der.fe+1; 
            }else if((subAr.der==  null) &&(subAr.izq != null))
            {
               subAr.fe = subAr.izq.fe+1; 
            }else
            {
              subAr.fe = Math.max(obtenerFE(subAr.izq),obtenerFE(subAr.der))+1; 
            }
            return nuevoPadre;
        }
        
        
        //Insertar 
        public boolean insertar(int d)
        {
            Nodo nuevo = new Nodo(d, null, null);
            if (raiz == null)
            {
                raiz = nuevo;
            }else
            {
                raiz = insertarAVL(nuevo,raiz);
            }
            return true;
        }
        
    public boolean agregar(int dato) {
        //le elimine el null,null despues del dato
        Nodo nuevo = new Nodo(dato, null, null);
        insertar(nuevo, raiz);
        return true;
    }
    
    //Metodo para insertar un dato en el arbol...no acepta repetidos :)
    public void insertar(Nodo nuevo, Nodo pivote) {
        if (this.raiz == null) {
            raiz = nuevo;
        } else {
            if (nuevo.getDato() <= pivote.getDato()) {
                if (pivote.getIzq() == null) {
                    pivote.setIzq(nuevo);
                } else {
                    insertar(nuevo, pivote.getIzq());
                }
            } else {
                if (pivote.getDer() == null) {
                    pivote.setDer(nuevo);
                } else {
                    insertar(nuevo, pivote.getDer());
                }
            }
        }

    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    //Recorrido preorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList preOrden() {
        LinkedList rec = new LinkedList();
        preorden(raiz, rec);
        return rec;
    }
    
    public void preorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            recorrido.add(aux.getDato());
            preorden(aux.getIzq(), recorrido);
            preorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido inorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList inOrden() {
        LinkedList rec = new LinkedList();
        inorden(raiz, rec);
        return rec;
    }
    
    public void inorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            inorden(aux.getIzq(), recorrido);
            recorrido.add(aux.getDato());
            inorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido postorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList postOrden() {
        LinkedList rec = new LinkedList();
        postorden(raiz, rec);
        return rec;
    }
    public void postorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            postorden(aux.getIzq(), recorrido);
            postorden(aux.getDer(), recorrido);
            recorrido.add(aux.getDato());
        }
    }

    //Metodo para verificar si hay un nodo en el arbol
    public boolean existe(int dato) {
        Nodo aux = raiz;
        while (aux != null) {
            if (dato == aux.getDato()) {
                return true;
            } else if (dato > aux.getDato()) {
                aux = aux.getDer();
            } else {
                aux = aux.getIzq();
            }
        }
        return false;
    }

    private void altura(Nodo aux, int nivel) {
        if (aux != null) {
            altura(aux.getIzq(), nivel + 1);
            alt = nivel;
            altura(aux.getDer(), nivel + 1);
        }
    }

    //Devuleve la altura del arbol
    public int getAltura() {
        altura(raiz, 1);
        return alt;
    }
    
     public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
}
