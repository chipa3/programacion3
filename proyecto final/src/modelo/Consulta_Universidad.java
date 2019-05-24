package modelo;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class Consulta_Universidad extends JFrame{
        static final String CONTROLADOR_JDBC = "com.mysql.jdbc.Driver";
        private Connection conexion;
        private Statement instruccion;
        
        public Consulta_Universidad(){
            super("Consulta Tabla Universidad");
            
            try{
                Class.forName(CONTROLADOR_JDBC);
                //conexion = DriverManager.getConnection("jdbc:mysql://192.168.0.80/recursos_humanos", "admin_progra", "progra.2018");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/recursos_humanos","root","");
                instruccion = conexion.createStatement();
                
                ResultSet conjuntoResultados = instruccion.executeQuery("SELECT codigo_universidad,nombre FROM universidad WHERE 1");                
                
                StringBuffer resultados = new StringBuffer();
                ResultSetMetaData metaDatos = conjuntoResultados.getMetaData();                
                int numeroColumnas = metaDatos.getColumnCount();
                
                for(int i = 1; i <= numeroColumnas; i++){
                    resultados.append(metaDatos.getColumnName(i)+ "\t\t");
                }
                
                resultados.append("\n");
                
                while(conjuntoResultados.next()){
                    for(int i = 1; i <= numeroColumnas; i++){
                        resultados.append(conjuntoResultados.getObject(i)+ "\t\t");
                    }
                    resultados.append("\n");
                }
                
                JTextArea areaTexto = new JTextArea(resultados.toString());
                Container contenedor = getContentPane();
                contenedor.add(new JScrollPane (areaTexto)); 
                this.setDefaultCloseOperation(HIDE_ON_CLOSE);
                setSize(500, 300);
                setVisible(true);  
                
            }//final try 
            catch (SQLException excepcionSql){
                JOptionPane.showMessageDialog(null, excepcionSql.getMessage(),"Error en la base de datos", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }//Final catch
            
            catch (ClassNotFoundException claseNoEncontrada){
                JOptionPane.showMessageDialog(null, claseNoEncontrada.getMessage(),"Error en la base de datos", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
            
            finally{
                try{
                    instruccion.close();
                    conexion.close();
                }
                catch(SQLException excepcionSql) {
                    JOptionPane.showMessageDialog(null, excepcionSql.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
                }
            } //Final finally
            
        } //Final Public ConexionBD
        
        
}