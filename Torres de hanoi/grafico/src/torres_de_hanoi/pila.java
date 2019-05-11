
package torres_de_hanoi;

public class pila {
    private int contador = 0;
    private Nodo cabeza;

    public int getContador() {
        return contador;
    }

    public Nodo getCabeza() {
        return cabeza;
    }
    public void push(Nodo  N)
    {
        contador++;
        if(cabeza ==  null)
        {
        cabeza = N;
        }else
        {
        N.setAbajo(cabeza);
        cabeza.setArriba(N);
        cabeza = N;
        }
    }
    public void pop()
    {
    if(contador > 0)
    {
        contador--;
        cabeza = cabeza.getAbajo();
    }
    }
    public String peek()
    {
        return cabeza.getDato();
    }
    
}
