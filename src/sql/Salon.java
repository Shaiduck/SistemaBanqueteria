/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus
 */
public class Salon {
    public boolean estaSalon(String NomSal, String PreSal){
        try{
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            Statement comando=conexion.createStatement();
            ResultSet registro = comando.executeQuery("select * from insumos where nombreinsumo='"+NomSal+"' and precio='"+PreSal+"' and descripcion='salon'");
            if(registro.next()){
                conexion.close();
                return true;
            }else{
                conexion.close();
                return false;
            } 
        } catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
    
    public String idCatalogo(String TipoPla){
        try {
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            Statement comando = conexion.createStatement();
            String CSQL = "select idcatalogo from catalogo where nombrecatalogo='salon' and tipocatalogo='" + TipoPla + "'";            
            ResultSet registro = comando.executeQuery(CSQL);
            if (registro.next()) {
                String resultado = registro.getString("idcatalogo");
                conexion.close();
                return resultado;
            } else {
                conexion.close();
                return "";
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return "";
        }
    }
    
    public void registraSalon(String NomSal, String PreSal){
        //String idcat = idCatalogo("salon");
        //if (idcat.equals("")!=true){
            try{
                String idcat="salon";
                conexion con = new conexion();
                Connection conexion = con.daConexion();
                Statement comando = conexion.createStatement();
                comando.executeUpdate("INSERT INTO `insumos` (`idinsumo`, `nombreinsumo`, `descripcion`, `precio`, `tipocatalogo`) VALUES (NULL, '"+NomSal+"', 'salon', '"+PreSal+"', '"+idcat+"')");
                JOptionPane.showMessageDialog(null, "Registrado!!");
                conexion.close();
            } catch(SQLException ex){
                System.out.println(ex);
            }
        //}
    }
    
}
