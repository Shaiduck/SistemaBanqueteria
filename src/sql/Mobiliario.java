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
public class Mobiliario {
    public String idCatalogo(String TipoPla){
        try {
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            Statement comando = conexion.createStatement();
            String CSQL = "select idcatalogo from catalogo where nombrecatalogo='mobiliario' and tipocatalogo='mobiliario'";            
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
    
    public boolean estaMoviliario(String Nompla, String PrePla, String DesPla, String ModColMob, String ModForMob, String cinta) {
        try{
            //String idcat = idCatalogo("mobiliario");
            String valor = "mobiliario";
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            Statement comando=conexion.createStatement();
            ResultSet registro = comando.executeQuery("select * from insumos where nombreinsumo='"+Nompla+"' and precio='"+PrePla+"' and descripcion='"+DesPla+"' and tipocatalogo='"+valor+"' and color='"+ModColMob+"' and forma='"+ModForMob+"'");
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
    
    public void registraMoviliario(String Nompla, String PrePla, String DesPla, String RegCol, String RegForMob, String Cintilla){
        //String idcat = idCatalogo("mobiliario");
        String idcat= "mobiliario";
        if (idcat.equals("")!=true){
            try{
                conexion con = new conexion();
                Connection conexion = con.daConexion();
                Statement comando = conexion.createStatement();
                String QSQL = "INSERT INTO `bd_banquetesmexico`.`insumos` (`idinsumo`, `nombreinsumo`, `descripcion`, `forma`, `tamaño`, `color`, `diseño`, `cintilla`, `precio`, `tipocatalogo`) VALUES (NULL, '"+Nompla+"', '"+DesPla+"', '"+RegForMob+"', NULL, '"+RegCol+"', NULL, '"+Cintilla+"', '"+PrePla+"', '"+idcat+"');";
                comando.executeUpdate(QSQL);
                JOptionPane.showMessageDialog(null, "Registrado!!");
            } catch(SQLException ex){
                System.out.println(ex);
            }
        }
    }
    
    public void actualizaMoviliario(String id, String Nompla, String PrePla, String DesPla, String RegCol, String RegForMob, String Cintilla){
        //String idcat = idCatalogo("mobiliario");
        String idcat= "mobiliario";
        if (idcat.equals("")!=true){
            try{
                conexion con = new conexion();
                Connection conexion = con.daConexion();
                Statement comando = conexion.createStatement();
                String QSQL = "update `insumos` set  nombreinsumo='"+Nompla+"', descripcion='"+DesPla+"', forma='"+RegForMob+"', color='"+RegCol+"', cintilla='"+Cintilla+"', precio='"+PrePla+"', tipocatalogo='"+idcat+"' where idinsumo='"+id+"'";
                comando.executeUpdate(QSQL);
                JOptionPane.showMessageDialog(null, "Actualizado!!");
            } catch(SQLException ex){
                System.out.println(ex);
            }
        }
    }
    
}
