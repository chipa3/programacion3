/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author jose lopez
 */
public class codigo_listas extends javax.swing.JFrame {

    /**
     * Creates new form codigo_listas
     */
    public codigo_listas() {
        initComponents();
           this.setTitle("CODIGO LISTAS");
        this.setLocationRelativeTo(codigo_listas.this);
        this.setResizable(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("package estructuralibros;\n\nimport javax.swing.JOptionPane;\n\npublic class Inicio {\n    public static String titulo, autor,isbn,opcion,posicion,menuregresar;\n    public static int op,posicionnodo,opcionwhile;\n    public static  Libro libro;\n    public static  Lista milista = new Lista();\n    //funcion que permite ingresar los datos a variables\n    public static void ingreso()\n    {\n    titulo = JOptionPane.showInputDialog(null,\"INGRESE EL TITULO DEL LIBRO\");\n    autor = JOptionPane.showInputDialog(null,\"NGRESE EL AUTOR DEL LIBRO\");\n    isbn = JOptionPane.showInputDialog(null,\"INGRESE EL CODIGO\");\n    libro = new Libro(titulo,autor,isbn);\n    }\n  public static void menup()\n  {\n    opcion = JOptionPane.showInputDialog(null,\"INGRESE LA OPCION QUE DESEA:\\n1.INGRESAR AL PRINCIPIO\\n2.INSERTAR EN POSICION\\n3.INSERTAR AL FINAL\\n4.ELIMINAR EL PRIMERO\\n5.ELIMINAR EL FINAL\\n6.ELIMINAR POSICION\"\n            + \"\\n7.BUSCAR LIBRO \\n8.VER SI LA LISTA ESTA VACIA\\n9.VER LA CANTIDAD DE NODOS\\n10.MOSTRAR\");\n    op = Integer.parseInt(opcion);  \n  }\n  public static void menuregresar()\n  {\n     menuregresar = JOptionPane.showInputDialog(null,\"¿DESEA SALIR DEL PROGRAMA?\\n1.SI\\n2.NO\");\n    opcionwhile = Integer.parseInt(menuregresar); \n  }\n   public static void main(String[] args)\n   {\n    do{\n        //menu principal de opciones\n    menup();\n    switch(op)\n    {\n        case 1:\n            //ingreso de datos a la clase libro\n           ingreso();\n           //envio de datos a la funcion de insertar al incio de la lista\n           milista.insertarPrincipio(libro);\n           JOptionPane.showMessageDialog(null,\"LOS DATOS SE GUARDARON EXITOSAMENTE\");\n            break;\n        case 2: \n            posicion = JOptionPane.showInputDialog(null,\"INGRESE LA POSICION EN LA QUE DESEA INGRESAR LOS DATOS\");\n           posicionnodo = Integer.parseInt(posicion);\n             //ingreso de datos a la clase libro\n           ingreso();\n           milista.insertarDespues(posicionnodo,libro);\n           JOptionPane.showMessageDialog(null,\"LOS DATOS SE GUARDARON EXITOSAMENTE\");\n            break;\n        case 3:\n              //ingreso de datos a la clase libro\n           ingreso();\n           milista.insertarFinal(libro);\n           JOptionPane.showMessageDialog(null,\"LOS DATOS SE GUARDARON EXITOSAMENTE\");\n            break;\n        case 4:\n            //elimina el primer dato de la lista\n           milista.eliminaPrincipio();\n           JOptionPane.showMessageDialog(null,\"LOS DATOS SE ELIMINARON EXITOSAMENTE\");\n           break;\n        case 5:\n            //elimina el ultimo dato de la lista\n           milista.eliminarUltimo();\n           JOptionPane.showMessageDialog(null,\"LOS DATOS SE ELIMINARON EXITOSAMENTE\");\n            break;\n        case 6:\n            //elimina una posicion que el usuario desee\n           posicion = JOptionPane.showInputDialog(null,\"INGRESE LA POSICION EN LA QUE DESEA ELIMINAR LOS DATOS\");\n           posicionnodo = Integer.parseInt(posicion);\n           milista.eliminarLibro(posicionnodo);\n           JOptionPane.showMessageDialog(null,\"LOS DATOS SE ELIMINARON EXITOSAMENTE\");\n            break;\n        case 7:\n            //muestra el dato buscado por el usuario\n           posicion = JOptionPane.showInputDialog(null,\"INGRESE LA POSICION EN LA QUE DESEA BUSCAR LOS DATOS\");\n           posicionnodo = Integer.parseInt(posicion);\n           JOptionPane.showMessageDialog(null,milista.obtener(posicionnodo) );\n            break;\n        case 8:\n            //MUESTRA SI LA LISTA ESTA VACIA\n            JOptionPane.showMessageDialog(null,\"LA LISTA ESTA VACIA: \"+milista.estaVacia());\n            break;\n        case 9:\n            //MUESTRA LA CANTIDAD DE DATOS DE LA LISTA\n            JOptionPane.showMessageDialog(null,\"LA LISTA TIENE : \"+milista.contar()+\" NODOS\");\n           \n            break;\n        case 10:\n            //MUESTRA LOS DATOS DE LA LISTA\n           JOptionPane.showMessageDialog(null,milista.Listar());\n            break;\n    }\n    //menu sobre si desea salir o no del programa\n    menuregresar();\n    }while(opcionwhile != 1);\n   }\n    \n}\n");
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("/*\n * To change this license header, choose License Headers in Project Properties.\n * To change this template file, choose Tools | Templates\n * and open the template in the editor.\n */\npackage estructuralibros;\n\n/**\n *\n * @author alumno\n */\npublic class Libro {\n        \n\tprivate String titulo;\n\tprivate String autor;\n\tprivate String isbn;\n\tpublic Libro(String titulo, String autor, String isbn) {\n\t\tthis.titulo=titulo;\n\t\tthis.autor=autor;\n\t\tthis.isbn=isbn;\n\t}\n\tpublic String getTitulo() {\n\t\treturn titulo;\n\t}\n\tpublic void setTitulo(String titulo) {\n\t\tthis.titulo=titulo;\n\t}\n\tpublic String getAutor() {\n\t\treturn autor;\t\n\t}\n\tpublic void setAutor(String autor) {\n\t\tthis.autor=autor;\n         \n\t}\n\tpublic String getIsbn() {\n\t\treturn isbn;\n\t}\n\tpublic void setIsbn(String isbn) {\n\t\tthis.isbn=isbn;\n           \n\t}\n    }\n");
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setText("package estructuralibros;\n\npublic class Lista {\n  \n\tprivate Nodo cabeza=null;//CREACION DE UN NODO CABEZA NULO\n\tprivate int longitud=0;\n\tprivate class Nodo {\n\t\tpublic Libro libro;//CREA UNA VARIABLE DE TIPO LIBRO\n\t\tpublic Nodo siguiente=null;//CREA UN NODO SIGUIENTE NULO\n        public Nodo(Libro libro)\n        {\n            this.libro=libro;//LA VARIABLE LIBRO TENDRA LOS DATOS DE LA CLASE LIBRO\n        }\n        }\n        public String Listar()\n\t{\n\t\tString Dato=\" \";\n\t\tNodo aux= cabeza;//CREA UN NODO QUE TIENE LA POSICION DE CABEZA\n\t\twhile (aux!=null)\n\t\t{\n                    //LA VARIABLE DATO SE IRA SUMANDO CON LOS DATOS QUE TIENE LA VARIABLE LIBRO\n\t\t\tDato +=\"TITULO : \" + aux.libro.getTitulo()+ \"\\n AUTOR : \"+aux.libro.getAutor()+\"\\n ISBN : \"+aux.libro.getIsbn()+\"\\n\";\n\t\t\taux=aux.siguiente;\n\t\t}\n\t\treturn(Dato);\n\t}\n\tpublic void insertarPrincipio(Libro libro) {\n            //CREA UN NODO QUE TENDRA LO QUE SE INGRESE\n\t\tNodo nodo=new Nodo(libro);\n                //NODO.SIGUENTES VA A TENER LA DIRECCION DEL PRIMER NODO\n\t\tnodo.siguiente=cabeza;\n                //CABEZA VA A PUNTAR AL NODO\n\t\tcabeza=nodo;\n                //SE IRAN SUMANDO CONFORME SE INGRESEN LOS DATOS\n\t\tlongitud++;\t\n\t}\n\tpublic void insertarFinal(Libro libro) {\n            //CREA UN NODO QUE TENDRA LO QUE SE LE INGRESE\n\t\tNodo nodo=new Nodo(libro);\n                //SI CABEZA ES IGUAL A NULO\n\t\tif (cabeza==null) {\n                    //LO INGRESARA EN CABEZA\n\t\t\tcabeza=nodo;\n                        //DE LO CONTRARIO LE ASIGNARA UN PUNTERO A CUAL INGRESAR LOS DATOS\n\t\t} else {\n\t\t\tNodo puntero=cabeza;\n\t\t\twhile (puntero.siguiente!=null) {\n\t\t\t\tpuntero=puntero.siguiente;\n\t\t\t}\n\t\t\tpuntero.siguiente=nodo;\n\t\t}\n\t\tlongitud++;\n\t}\n\tpublic void insertarDespues(int n, Libro libro) {\n            //CREA UN NODO QUE TENDRA LO QUE SE LE INGRESE\n\t\tNodo nodo=new Nodo(libro);\n                 //SI CABEZA ES IGUAL A NULO\n\t\tif (cabeza==null) {\n                    //LO INGRESARA EN EL PRIMER NODO\n\t\t\tcabeza=nodo;\n\t\t} else {\n                    //DE LO CONTRARIO BUSCARA LA ULTIMA POSICION Y LO INGRESARA\n\t\t\tNodo puntero=cabeza;\n\t\t\tint contador=0;\n\t\t\twhile (contador<n && puntero.siguiente!=null) {\n\t\t\t\tpuntero=puntero.siguiente;\n\t\t\t\tcontador++;\n\t\t\t}\n\t\t\tnodo.siguiente=puntero.siguiente;\n\t\t\tpuntero.siguiente=nodo;\n\t\t}\n\t\tlongitud++;\n\t}\n\tpublic String obtener(int n) {\n            \n            String datos = \"\";\n            //SI LA LISTA ESTA VACIA RETORNARA NULO\n\t\tif (cabeza==null) {\n\t\t\treturn null;\n\t\t} else {\n                    //DE LO CONTRARIO BUSCARA EL PUNTERO O LA DIRECCION QUE TIENE LA POSICION DESEADA \n\t\t\tNodo puntero=cabeza;\n\t\t\tint contador=0;\n                        //MIENTRAS CONTADOR SEA MENOR A LA POSICION BUSCADA Y EL PUNTERO SEA DISTINTO A NULO \n\t\t\twhile (contador<n && puntero.siguiente!=null) {\n                            //PUNTERO TENDRA LA POSICION DEL QUE SE BUSCA\n\t\t\t\tpuntero=puntero.siguiente;\n\t\t\t\tcontador++;\n\t\t\t}\n                        //SI NO SE ENCUENTRA LA POSICION DESEADA RETORNARA NILO\n\t\t\tif (contador!=n) {\n\t\t\t\treturn null;\n\t\t\t} else {\n                            //SI SE ENCUENTRA LA POSICION DESEADA MANDARA LA VARIABLE DATOS\n\t\t\t\tdatos +=\"TITULO : \" + puntero.libro.getTitulo()+ \"\\n AUTOR : \"+puntero.libro.getAutor()+\"\\n ISBN : \"+puntero.libro.getIsbn()+\"\\n\";\n                                return datos;\n\t\t\t}\n\t\t}\n\t}\n\tpublic int contar() {\n            //CUENTA LA CANTIDAD DE NODOS QUE TIENE LA LISTA\n\t\treturn longitud;\n\t}\n        public boolean estaVacia() {\n            //VERIFICA SI LA LISTA ESTA VACIA, SI ES ASI RETORNA NULO\n            return cabeza==null;\n        }\n        public void eliminaPrincipio() {\n            //VERIFICA SI LA DIRECCION ESTA VACIA, SI NO ESTA VACIA\n            if (cabeza!=null){\n                //NODO PRIMER TENDRA LA DIRECCION DE MEMORIA DEL PRIMER NODO\n                Nodo primer = cabeza;\n                //CEL SIGUIENTE NODO TENDRA LA DIRECCION DE NULO\n                cabeza=cabeza.siguiente=null;\n                longitud--;\n                //SE IRAN RESTANDO LOS NODOS\n            }\n        }\n        public void eliminarUltimo() {\n            //VERIFICA SI LA DIRECCION ESTA VACIA, SI NO ESTA VACIA\n            if (cabeza!= null) {\n                //SI CABEZA.SIGUENTE ES DISTINTO A NULO\n                if (cabeza.siguiente==null) {\n                    //CABEZA SERA NULO\n                    cabeza=null;  \n                    //SE IRAN RESTANDO LOS NODOS\n                    longitud--;\n                } else {\n                    //DE LO CONTRARIO EL PUNTERO SERA IGUAL A CABEZA\n                    Nodo puntero=cabeza;\n                    //MIENTRTAS EL PUNTERO SEA DISITINTO A NULO \n                    while (puntero.siguiente.siguiente!=null) {   \n                        //PUNTYERO SERA IGUAL A LA DIRECCION DEL SIGUIENTE NODO\n                        puntero=puntero.siguiente;\n                    }\n                    puntero.siguiente=null;\n                    longitud--;\n                }\n            }\n        }\n        public void eliminarLibro(int n) {\n            if (cabeza!=null){\n                //SI EL NUMERO INGRESADO POR EL USUARIO ES LA POSICION 0\n                if (n==0){\n                    //EL NODO PRIMERO TENDRA LA DIRECCION DE CABEZA\n                    Nodo primer=cabeza;\n                    //CABEZA SERA IGUAL AL LA DIRECCION DEL SIGUIENTE NODO\n                    cabeza=cabeza.siguiente;\n                    //EL NODO PRIMER. SIGUIENTE SERA IGUAL A NULO\n                    primer.siguiente=null;\n                    //SE IRAN RESTANDO LOS DATOS DE LA LISTA\n                    longitud--;\n                    //DE LO CONTRARIO SI EL DATO INGRESADO POR EL USUARIO ES MENOR A LOS DATOS QUE TIENE LA LISTA\n                } else if (n<longitud) {\n                    Nodo puntero=cabeza;\n                    int contador=0;\n                    while (contador<(n-1)){\n                        puntero=puntero.siguiente;\n                        contador++;\n                    }\n                    Nodo temp=puntero.siguiente;\n                    puntero.siguiente=temp.siguiente;\n                    temp.siguiente=null;\n                    longitud--;\n                }\n            }\n        }\n}\n");
        jScrollPane3.setViewportView(jTextArea3);

        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      listas l = new listas();
      l.show();
      dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(codigo_listas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(codigo_listas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(codigo_listas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(codigo_listas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new codigo_listas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}