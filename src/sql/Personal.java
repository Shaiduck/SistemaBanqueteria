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
public class Personal {
    public String idCatalogo(String TipoPla){
        try {
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            Statement comando = conexion.createStatement();
            String CSQL = "select idcatalogo from catalogo where nombrecatalogo='personal' and tipocatalogo='" + TipoPla + "'";            
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
       
    public void registraPersonal(String RegBocNom, String RegPreBoc, String RegDesBoc){
        //String idcat = idCatalogo("personal");
        String idcat="personal";
        if (idcat.equals("")!=true){
            try{
                conexion con = new conexion();
                Connection conexion = con.daConexion();
                Statement comando = conexion.createStatement();
                String QSQL = "INSERT INTO `bd_banquetesmexico`.`insumos` (`idinsumo`, `nombreinsumo`, `descripcion`, `forma`, `tamaño`, `color`, `diseño`, `precio`, `tipocatalogo`) VALUES (NULL, '"+RegBocNom+"', '"+RegDesBoc+"', NULL, NULL, 'NULL', NULL, '"+RegPreBoc+"', '"+idcat+"');";
                comando.executeUpdate(QSQL);
                JOptionPane.showMessageDialog(null, "Registrado!!");
                conexion.close();
            } catch(SQLException ex){
                System.out.println(ex);
            }
        }
    }
    
    public boolean estaPersonal(String RegBocNom, String RegPreBoc, String RegDesBoc) {
        try{
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            Statement comando=conexion.createStatement();
            ResultSet registro = comando.executeQuery("select * from insumos where nombreinsumo='"+RegBocNom+"' and precio='"+RegPreBoc+"' and descripcion='"+RegDesBoc+"'");
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
    
    public void actualizaPersonal(String id, String RegBocNom, String RegPreBoc, String RegDesBoc){
        String idcat = idCatalogo("personal");
        if (idcat.equals("")!=true){
            try{
                conexion con = new conexion();
                Connection conexion = con.daConexion();
                Statement comando = conexion.createStatement();
                String QSQL = "update `insumos` set  nombreinsumo='"+RegBocNom+"', descripcion='"+RegDesBoc+"', precio='"+RegPreBoc+"' where idinsumo='"+id+"'";
                comando.executeUpdate(QSQL);
                JOptionPane.showMessageDialog(null, "Actualizado!!");
                conexion.close();
            } catch(SQLException ex){
                System.out.println(ex);
            }
        }
    }
    
}
