/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import mod_catalogo.WinConx;

/**
 *
 * @author Jesus
 */
public class conexion {
    public static String user;
    public static String password;
    
    public Connection daConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bd_banquetesMexico", this.getUser(), this.password);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(WinConx.getFrames()[0], ex.getMessage(), "Atención", JOptionPane.WARNING_MESSAGE);
        }
        return con;
    }
    
    public boolean validConnection(String usr, String pass) {
        Connection con = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bd_banquetesMexico", usr, pass);
            
            if (con != null)
                return true;
            else
                return false;
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(WinConx.getFrames()[0], ex.getMessage(), "Atención", JOptionPane.WARNING_MESSAGE);
        }
        
        return false;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
