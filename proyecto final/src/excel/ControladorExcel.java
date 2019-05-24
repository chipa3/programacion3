package excel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import excel.hoja;
import excel.ModeloExcel;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ControladorExcel implements ActionListener{//se hace una clase que implemnta el actionlistener
    ModeloExcel modeloE = new ModeloExcel();//Se  hace una variable tipo ModeloExcel
    hoja vistaE= new hoja();//Se hace una variable tipo Hoja
    JFileChooser selecArchivo = new JFileChooser();//Se hace una varible de tipo seleccionador de archivo
    File archivo;//Una variable tipo archivo
    int contAccion=0;//Se hace un contador
    
    public ControladorExcel(hoja vistaE, ModeloExcel modeloE){//se hace una funcion la cual pide una variable tipo Hoja y ModeloExcel
        this.vistaE= vistaE;//Se empieza a refenrenciar las variables asi mismas y a los acction Listener 
        this.modeloE=modeloE;
        this.vistaE.opcionAbrir.addActionListener(this);
        this.vistaE.opcionGuardar.addActionListener(this);
    }
    
    public void AgregarFiltro(){//Una nueva funcion para poder colocar  los filtors de tipo de archivo 
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.csv)", "csv"));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {//se decalra una funcion para accion del evento
        contAccion++;//se suma al contador
        if(contAccion==1)AgregarFiltro();//si el contador es igual a 1 entonces habre el agregarfiltro
        
        if(e.getSource() == vistaE.opcionAbrir){//si en Hoja se toco en el menu la opcion abrir
            if(selecArchivo.showDialog(null, "Seleccionar archivo")==JFileChooser.APPROVE_OPTION){//si el archivo seleccionado se da por aprovado 
                archivo=selecArchivo.getSelectedFile();//el archivo se toma
                if(archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx") || archivo.getName().endsWith("csv")){//si se toma el archivo y tiee nombre y alguna de los tipos de archivo especificados
                    JOptionPane.showMessageDialog(null, 
                            modeloE.Importar(archivo, vistaE.jTable) + "\n Formato ."+ archivo.getName().substring(archivo.getName().lastIndexOf(".")+1), 
                            "IMPORTAR EXCEL", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Elija un formato valido.");
                }
            }
        }
        
        if(e.getSource() == vistaE.opcionGuardar){//Si se selecciona la opcion guardar en el jframe Hoja
            if(selecArchivo.showDialog(null, "Exportar")==JFileChooser.APPROVE_OPTION){//si se selecciona un archivo y se pone la opccion de aprovacion
                archivo=selecArchivo.getSelectedFile();//se guarda el archivo el archivo seleccionado en la variable archivo
                if(archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")|| archivo.getName().endsWith("csv")){///si tiene nombre y tiene una de las extenciones 
                    JOptionPane.showMessageDialog(null, modeloE.Exportar(archivo, vistaE.jTable) + "\n Formato ."+ archivo.getName().substring(archivo.getName().lastIndexOf(".")+1));
                }else{
                    JOptionPane.showMessageDialog(null, "Elija un formato valido.");
                }
            }
        }
    }
    
}

