package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Bryan estuardo mazariegos Davila
 * Carnet: 09001-17-1001
 */
public class SqlUsuarios extends Conexion {

    public boolean registrar(usuarios usr) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO usuario (NombreUsuario,password,Usuario) VALUES (?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getPassword());
            ps.setString(3, usr.getNombre());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean login(usuarios usr) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT ID_Usuario,NombreUsuario,Password,Usuario FROM usuario WHERE NombreUsuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (usr.getPassword().equals(rs.getString(3))) {

                    String sqlUpdate = "UPDATE usuario SET last_session = ? WHERE ID_Usuario = ?";
                    ps = con.prepareStatement(sqlUpdate);
                    ps.setString(1, usr.getLast_session());
                    ps.setInt(2, rs.getInt(1));
                    ps.execute();

                    usr.setId(rs.getInt(1));
                    usr.setNombre(rs.getString(2));
                    
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int existeUsuario(String usuario) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT count(ID_Usuario) FROM usuario WHERE NombreUsuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);

            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }

    }

    public boolean esEmail(String correo) {

        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        return mather.find();

    }

}
