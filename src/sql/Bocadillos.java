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
public class Bocadillos {
    public String idCatalogo(String TipoPla){
        try {
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            Statement comando = conexion.createStatement();
            String CSQL = "select idcatalogo from catalogo where nombrecatalogo='Bocadillos' and tipocatalogo='"+TipoPla+"'";            
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
    
    public boolean estaBocadillo(String RegBocNom, String RegPreBoc, String RegDesBoc, String tipo) {
        try{
            String idcat = idCatalogo(tipo);
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            Statement comando=conexion.createStatement();
            ResultSet registro = comando.executeQuery("select * from insumos where nombreinsumo='"+RegBocNom+"' and precio='"+RegPreBoc+"' and descripcion='"+RegDesBoc+"' and fkidcatalogo='"+idcat+"'");
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
    
    public void registraBocadillo(String RegBocNom, String RegPreBoc, String RegDesBoc, String RegTipBoc){
        //String idcat = idCatalogo(RegTipBoc);
        //if (idcat.equals("")!=true){
            try{
                conexion con = new conexion();
                Connection conexion = con.daConexion();
                Statement comando = conexion.createStatement();
                String QSQL = "INSERT INTO `bd_banquetesmexico`.`insumos` (`idinsumo`, `nombreinsumo`, `descripcion`, `forma`, `tamaño`, `color`, `diseño`, `precio`, `tipocatalogo`) VALUES (NULL, '"+RegBocNom+"', '"+RegDesBoc+"', NULL, NULL, 'NULL', NULL, '"+RegPreBoc+"', '"+RegTipBoc+"');";
                System.out.println("llego");
                comando.executeUpdate(QSQL);
                JOptionPane.showMessageDialog(null, "Registrado!!");
            } catch(SQLException ex){
                System.out.println(ex);
            }
        //}
    }
    
    public void actualizaBocadillo(String id, String RegBocNom, String RegPreBoc, String RegDesBoc, String RegTipBoc){
        //String idcat = idCatalogo(RegTipBoc);
        //if (idcat.equals("")!=true){
            try{
                conexion con = new conexion();
                Connection conexion = con.daConexion();
                Statement comando = conexion.createStatement();
                String QSQL = "update `insumos` set  nombreinsumo='"+RegBocNom+"', descripcion='"+RegDesBoc+"', precio='"+RegPreBoc+"', tipocatalogo='"+RegTipBoc+"' where idinsumo='"+id+"'";
                System.out.println("llego");
                comando.executeUpdate(QSQL);
                JOptionPane.showMessageDialog(null, "Registrado!!");
            } catch(SQLException ex){
                System.out.println(ex);
            }
        //}
    }
    
}
