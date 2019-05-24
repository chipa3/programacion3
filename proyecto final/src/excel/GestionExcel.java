/**
 * Bryan estuardo mazariegos Davila
 * Carnet: 09001-17-1001
 */
package excel;


public class GestionExcel {
    
    public static void main(String[] args) {
        ModeloExcel modeloE = new ModeloExcel();//Se crea una variable de tipo ModeloExcel
        hoja vistaE = new hoja();//se hace una variable de tipo Hoja
        ControladorExcel contraControladorExcel = new ControladorExcel(vistaE, modeloE);//Se hace una variable tipo controlador y en dicha se envia la variable de  Hoja y Modelo Excel
        vistaE.setVisible(true);//se muestra el jframe de hoja.

    }
    
}
