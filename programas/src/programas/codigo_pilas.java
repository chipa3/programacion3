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
public class codigo_pilas extends javax.swing.JFrame {

    /**
     * Creates new form codigo_pilas
     */
    public codigo_pilas() {
        initComponents();
         this.setTitle("CODIGO PILAS");
        this.setLocationRelativeTo(codigo_pilas.this);
        this.setResizable(false);
         File archivo= new File("C:\\Users\\jose lopez\\Documents\\programas\\codigos\\pilas\\datos.java");
          try {
           BufferedReader leer = new BufferedReader(new FileReader(archivo));
           String linea = leer.readLine();
           while(linea != null){
               jTextArea1.append(linea+"\n");
              linea = leer.readLine();
           }
          } catch (Exception ex) {
          System.err.println("no se abrio bien el archivo"+ex.toString());
        
        }
           File archivo1= new File("C:\\Users\\jose lopez\\Documents\\programas\\codigos\\pilas\\Pilas.java");
          try {
           BufferedReader leer = new BufferedReader(new FileReader(archivo1));
           String linea = leer.readLine();
           while(linea != null){
               jTextArea2.append(linea+"\n");
              linea = leer.readLine();
           }
          } catch (Exception ex) {
          System.err.println("no se abrio bien el archivo"+ex.toString());
        
        }
           File archivo2= new File("C:\\Users\\jose lopez\\Documents\\programas\\codigos\\pilas\\procesos.java");
          try {
           BufferedReader leer = new BufferedReader(new FileReader(archivo2));
           String linea = leer.readLine();
           while(linea != null){
               jTextArea3.append(linea+"\n");
              linea = leer.readLine();
           }
          } catch (Exception ex) {
          System.err.println("no se abrio bien el archivo"+ex.toString());
        
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setText("package pilas;\n\npublic class datos{\n        \n\tprivate String titulo;\n\tprivate String autor;\n\tprivate String isbn;\n\tpublic datos(String titulo, String autor, String isbn) {\n\t\tthis.titulo=titulo;\n\t\tthis.autor=autor;\n\t\tthis.isbn=isbn;\n\t}\n\tpublic String getTitulo() {\n\t\treturn titulo;\n\t}\n\tpublic void setTitulo(String titulo) {\n\t\tthis.titulo=titulo;\n\t}\n\tpublic String getAutor() {\n\t\treturn autor;\t\n\t}\n\tpublic void setAutor(String autor) {\n\t\tthis.autor=autor;\n         \n\t}\n\tpublic String getIsbn() {\n\t\treturn isbn;\n\t}\n\tpublic void setIsbn(String isbn) {\n\t\tthis.isbn=isbn;\n           \n\t}\n    }\n\n");
        jScrollPane3.setViewportView(jTextArea3);

        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("/*\nNOMBRE: JOSE ESTANISLAO LOPEZ TUBAC\nCARNET: 0901-17-12\n*/\n\npackage pilas;\n\npublic class procesos {\n  \n\tprivate Nodo cabeza=null;//CREACION DE UN NODO CABEZA NULO\n\tprivate int longitud=0;\n\tprivate class Nodo {\n\t\tpublic datos libro;//CREA UNA VARIABLE DE TIPO LIBRO\n\t\tpublic Nodo siguiente=null;//CREA UN NODO SIGUIENTE NULO\n        public Nodo(datos libro)\n        {\n            this.libro=libro;//LA VARIABLE LIBRO TENDRA LOS DATOS DE LA CLASE LIBRO\n        }\n        }\n        public String Mostrar()\n\t{\n\t\tString Dato=\" \";\n\t\tNodo aux= cabeza;//CREA UN NODO QUE TIENE LA POSICION DE CABEZA\n\t\twhile (aux!=null)\n\t\t{\n                    //LA VARIABLE DATO SE IRA SUMANDO CON LOS DATOS QUE TIENE LA VARIABLE LIBRO\n\t\t\tDato +=\"TITULO : \" + aux.libro.getTitulo()+ \"\\n AUTOR : \"+aux.libro.getAutor()+\"\\n ISBN : \"+aux.libro.getIsbn()+\"\\n\";\n\t\t\taux=aux.siguiente;\n\t\t}\n\t\treturn(Dato);\n\t}\n\t    public String top() {\n             String datos = \" \";\n            if (cabeza!= null) {\n                //SI CABEZA.SIGUENTE ES DISTINTO A NULO\n                if (cabeza.siguiente==null) {\n                   datos +=\"TITULO : \" + cabeza.libro.getTitulo()+ \"\\n AUTOR : \"+cabeza.libro.getAutor()+\"\\n ISBN : \"+cabeza.libro.getIsbn()+\"\\n\";\n\t\t\t\n                } else {\n                    //DE LO CONTRARIO EL PUNTERO SERA IGUAL A CABEZA\n                    Nodo puntero=cabeza;\n                    //MIENTRTAS EL PUNTERO SEA DISITINTO A NULO \n                    while (puntero.siguiente!=null) {   \n                       \n                        puntero=puntero.siguiente;\n                    }\n                   datos +=\"TITULO : \" + puntero.libro.getTitulo()+ \"\\n AUTOR : \"+ puntero.libro.getAutor()+\"\\n ISBN : \"+ puntero.libro.getIsbn()+\"\\n\";\n\t\t\n                }\n            }\n            return(datos);\n        }\n        \n\tpublic void push(datos libro) {\n            //CREA UN NODO QUE TENDRA LO QUE SE LE INGRESE\n\t\tNodo nodo=new Nodo(libro);\n                //SI CABEZA ES IGUAL A NULO\n\t\tif (cabeza==null) {\n                    //LO INGRESARA EN CABEZA\n\t\t\tcabeza=nodo;\n                        //DE LO CONTRARIO LE ASIGNARA UN PUNTERO A CUAL INGRESAR LOS DATOS\n\t\t} else {\n\t\t\tNodo puntero=cabeza;\n\t\t\twhile (puntero.siguiente!=null) {\n\t\t\t\tpuntero=puntero.siguiente;\n\t\t\t}\n\t\t\tpuntero.siguiente=nodo;\n\t\t}\n\t\tlongitud++;\n\t}\n\n        public void pop() {\n            //VERIFICA SI LA DIRECCION ESTA VACIA, SI NO ESTA VACIA\n            if (cabeza!= null) {\n                //SI CABEZA.SIGUENTE ES DISTINTO A NULO\n                if (cabeza.siguiente==null) {\n                    //CABEZA SERA NULO\n                    cabeza=null;  \n                    //SE IRAN RESTANDO LOS NODOS\n                    longitud--;\n                } else {\n                    //DE LO CONTRARIO EL PUNTERO SERA IGUAL A CABEZA\n                    Nodo puntero=cabeza;\n                    //MIENTRTAS EL PUNTERO SEA DISITINTO A NULO \n                    while (puntero.siguiente.siguiente!=null) {   \n                        //PUNTYERO SERA IGUAL A LA DIRECCION DEL SIGUIENTE NODO\n                        puntero=puntero.siguiente;\n                    }\n                    puntero.siguiente=null;\n                    longitud--;\n                }\n            }\n        }\n       public String vacia () {\n            if (cabeza == null ) {\n                return (\"La pila esta vacia \");\n            } else {\n                return \" La pila no esta vacia \" ;\n            }\n           \n        }\n          public void Vaciar() {\n          \n            if (cabeza != null) {\n              \n                Nodo primer = cabeza;\n              \n                cabeza = cabeza . siguiente = null ;\n              \n                cabeza = null ;\n               \n                longitud = 0 ;\n            }\n        }\n}\n");
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("/*\nNOMBRE: JOSE ESTANISLAO LOPEZ TUBAC\nCARNET: 0901-17-12\n*/\n\npackage pilas;\n\nimport javax.swing.JOptionPane;\n\npublic class Pilas {\n    public static String titulo, autor,isbn,opcion,posicion,menuregresar;\n    public static int op,posicionnodo,opcionwhile;\n    public static  datos libro;\n    public static  procesos milista = new procesos();\n    public static void ingreso()\n    {\n    titulo = JOptionPane.showInputDialog(null,\"INGRESE EL TITULO DEL LIBRO\");\n    autor = JOptionPane.showInputDialog(null,\"NGRESE EL AUTOR DEL LIBRO\");\n    isbn = JOptionPane.showInputDialog(null,\"INGRESE EL CODIGO\");\n    libro = new datos(titulo,autor,isbn);\n    }\n  public static void menup()\n  {\n    opcion = JOptionPane.showInputDialog(null,\",MENU DE OPCIONES:\\n1.INGRESAR DATOS\\n2.ELIMINAR DATOS\\n3.MOSTRAR DATOS\\n4.ULTIMO DATO\\n5.VER SI ESTA VACIA LA PILA\\n6.VACIAR PILA\");\n    op = Integer.parseInt(opcion);  \n  }\n  public static void menuregresar()\n  {\n     menuregresar = JOptionPane.showInputDialog(null,\"¿DESEA SALIR DEL PROGRAMA?\\n1.SI\\n2.NO\");\n    opcionwhile = Integer.parseInt(menuregresar); \n  }\n   public static void main(String[] args)\n   {\n    do{\n    menup();\n    switch(op)\n    {\n        case 1:\n           ingreso();\n           milista.push(libro);\n           JOptionPane.showMessageDialog(null,\"LOS DATOS SE GUARDARON EXITOSAMENTE\");\n            break;\n        case 2: \n           milista.pop();\n           JOptionPane.showMessageDialog(null,\"EL DATO SE ELIMINO CORRECTAMENTE\");\n            break;\n         case 3: \n           JOptionPane.showMessageDialog(null,milista.Mostrar());\n            break;\n              case 4: \n           JOptionPane.showMessageDialog(null,milista.top());\n            break;\n              case 5: \n           JOptionPane.showMessageDialog(null,milista.vacia());\n            break;\n              case 6: \n                  milista.Vaciar();\n           JOptionPane.showMessageDialog(null,\"SE HA VACIADO LA PILA CORRECTAMENTE\");\n            break;\n    }\n    menuregresar();\n    }while(opcionwhile != 1);\n   }\n    \n}\n");
        jScrollPane2.setViewportView(jTextArea2);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pilas l = new pilas();
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
            java.util.logging.Logger.getLogger(codigo_pilas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(codigo_pilas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(codigo_pilas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(codigo_pilas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new codigo_pilas().setVisible(true);
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
