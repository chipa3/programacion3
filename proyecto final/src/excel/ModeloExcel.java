package excel;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.*;

public class ModeloExcel {
    Workbook wb;//Se abre un nuevo libro
    
    public String Importar(File archivo, JTable tablaD){//Se hace una funcion tipo string donde se pediran un archivo y una tabla.
        String respuesta="No se pudo realizar la importación.";//Una variable con un mensaje 
        DefaultTableModel modeloT = new DefaultTableModel();//Se hace una variable de tipo modelo para la tabla
        tablaD.setModel(modeloT);//a la tabla se le coloca el nuevo modelo.
        tablaD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//se apaga el auto redimensionador.
        try {
            wb = WorkbookFactory.create(new FileInputStream(archivo));//Se crea una entrada para el archivo
            Sheet hoja = wb.getSheetAt(0);//Se cra una nueva hoja que estara en el libro wb
            Iterator filaIterator = hoja.rowIterator();//Se hace una variable para iterar las filas de la nueva hoja.
            int indiceFila=-1;//Se abre una nueva variable tipo entero  para llevar un contador
            while (filaIterator.hasNext()) {//se hace una condicion que dice  si la variable del archivo iterado llega no leer mas datos del archivo          
                indiceFila++;//Se suma a la variable contador.
                Row fila = (Row) filaIterator.next();//Se declara una fila que tenga el dato del archivo iterado
                Iterator columnaIterator = fila.cellIterator();//Se hace un nuevo iterador, esta vez para las celdas.
                Object[] listaColumna = new Object[1000];//se hac eun nuevo objeto que con tenga 1000 espacios
                int indiceColumna=-1;// nuevo contador
                while (columnaIterator.hasNext()) {    //condicion hasta que este vacio el iterador de la columna                
                    indiceColumna++;//se suma al contador
                    Cell celda = (Cell) columnaIterator.next();//se hace una variable celda la cual estara para leer el iteradort de la columna
                    if(indiceFila==0){//si el indice esta vacio entonces
                        modeloT.addColumn(celda.getStringCellValue());// se colocara el modeloT
                    }else{
                        if(celda != null){//si celda no es nula
                            switch(celda.getCellType()){//Se tomara el tipo dato con un switch 
                                case Cell.CELL_TYPE_NUMERIC://si es de tipo numerico entonces se tomara de manera numerica para la celda 
                                    listaColumna[indiceColumna]= (int)Math.round(celda.getNumericCellValue());
                                    break;
                                case Cell.CELL_TYPE_STRING://si es de tipo string entonces se tomara de manera string para la celda 
                                    listaColumna[indiceColumna]= celda.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_BOOLEAN://si es de tipo booleana entonces se tomara de boolena para la celda 
                                    listaColumna[indiceColumna]= celda.getBooleanCellValue();
                                    break;
                                   
                                default://si no es ninguna de las de arriba se tomara de tipo date
                                    listaColumna[indiceColumna]=celda.getDateCellValue();
                                    break;
                            }//se ¿muestra en consola el contador
                            System.out.println("col"+indiceColumna+" valor: true - "+celda+".");
                        }
                        
                    }
                }
                if(indiceFila!=0)modeloT.addRow(listaColumna);//si el contador es diferente a 0 entonces modelot se acomplara las filas para el objeto listacolumna
            }
            respuesta="Importación exitosa";// se da un nuevo mensaje a la variable string 
        } catch (IOException | InvalidFormatException | EncryptedDocumentException e) {
            System.err.println(e.getMessage());//De lo contrario no se cumpli nada de arriba se mostrara el mensaje antes colocado 
        }
        return respuesta;//se envia la variable string
    }
    
    public String Exportar(File archivo, JTable tablaD){//se hace una funcion la cual pedira un archivo y una tabla
        String respuesta="No se realizo con exito la exportación.";//Una variable con un mensaje 
        int numFila=tablaD.getRowCount(), numColumna=tablaD.getColumnCount();//se hacen variables tipo int para tener los contadores de los numeroes de fuilas uy columnas
        if(archivo.getName().endsWith("xls")){//si el archivo tiene nombre y termina con xls
            wb = new HSSFWorkbook();//el libro sera un nuevo HSSF
        }else{
            wb = new XSSFWorkbook();//sino el libro sera un nuevo XSSF
        }
        Sheet hoja = wb.createSheet("Prueba");//Se crea una nueva hoja la cual se donminara prueba
        
        try {
            for (int i = -1; i < numFila; i++) {//ciclo para ir atravez de las filas
                Row fila = hoja.createRow(i+1);//se hara una nueva 
                for (int j = 0; j < numColumna; j++) {//ciclo para ir atravez de las columnas
                    Cell celda = fila.createCell(j);//se crear una celda conforme para la nueva fila
                    if(i==-1){// si el contador del primer for es igual a 1 
                        celda.setCellValue(String.valueOf(tablaD.getColumnName(j)));//Celda se evalua para tomar su columna
                    }else{
                        celda.setCellValue(String.valueOf(tablaD.getValueAt(i, j)));//Celda se evaula y se toma el valor de i y j
                    }
                    wb.write(new FileOutputStream(archivo));//S escribe en el libro.
                }
            }
            respuesta="Exportación exitosa.";//se cambia el mensaje de la variable
        } catch (Exception e) {
            System.err.println(e.getMessage());//De lo contrario no se cumpli nada de arriba se mostrara el mensaje antes colocado 
        }
        return respuesta;//se envia la variable string
    }
}
