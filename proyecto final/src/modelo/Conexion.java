

package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Bryan estuardo mazariegos Davila
 * JORGE SOSA 0901-16-4067
 * Carnet: 09001-17-1001
 */
public class Conexion {
    public static final String url = "jdbc:mysql://localhost:3306/excel?SSL=true";
    public static final String user = "root";
    public static final String password = "";
    private Connection con = null;
    
    public Connection getConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url,user,password);
           // JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
