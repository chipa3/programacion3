package excel;

public class GestionExcel {
    
    public static void main(String[] args) {
        ModeloExcel modeloE = new ModeloExcel();
        hoja vistaE = new hoja();
        ControladorExcel contraControladorExcel = new ControladorExcel(vistaE, modeloE);
        vistaE.setVisible(true);

    }
    
}
