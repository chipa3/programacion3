/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBB;

/**
 *
 * @author
 */
public class Nodo {
  public int dato , fe;
  //SE CREAN DATOS DE TIPO NODO EL CUAL TENDRA LOS VALORES DEL LADO DERECHO O IZQUIERDO
  public Nodo izq,der;

    public Nodo(int dato, Nodo izq , Nodo der) {
        this.dato = dato;
        this.fe = 0;
        this.izq = izq;
        this.der = der;
    }

    

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
 
}
