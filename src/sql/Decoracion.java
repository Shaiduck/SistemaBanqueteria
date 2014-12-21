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
public class Decoracion {
    public String idCatalogo(String TipoPla){
        try {
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_banquetesmexico", "root", "");
            Statement comando = conexion.createStatement();
            String CSQL = "select idcatalogo from catalogo where nombrecatalogo='decoraciones' and tipocatalogo='"+TipoPla+"'";            
            ResultSet registro = comando.executeQuery(CSQL);
            if (registro.next()) {
                String resultado = registro.getString("idcatalogo");
                conexion.close();
                return resultado;
            } else {
                conexion.close();
                return "";
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Platillo.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        } catch (SQLException ex) {
            System.out.println(ex);
            return "";
        }
    }
    
    public boolean estaDecoracion(String Nompla, String PrePla, String DesPla, String RegTamDec, String RegColDec, String tipo) {
        try{
            //String idcat = idCatalogo(tipo);
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            Statement comando=conexion.createStatement();
            ResultSet registro = comando.executeQuery("select * from insumos where nombreinsumo='"+Nompla+"' and precio='"+PrePla+"' and descripcion='"+DesPla+"' and tamaño='"+RegTamDec+"' and color='"+RegColDec+"' and tipocatalogo='"+tipo+"'");
            if(registro.next()){
                conexion.close();
                return true;
            }else{
                conexion.close();
                return false;
            } 
        
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
    
    public void registraDecoracion(String RegDeco, String RegTipDec, String RegPreDec, String RegTamDec, String RegColDec, String RegDesDec){
        //String idcat = idCatalogo(RegTipDec);
        //if (idcat.equals("")!=true){
            try{
                conexion con = new conexion();
                Connection conexion = con.daConexion();
                Statement comando = conexion.createStatement();
                String QSQL = "INSERT INTO `bd_banquetesmexico`.`insumos` (`idinsumo`, `nombreinsumo`, `descripcion`, `forma`, `tamaño`, `color`, `diseño`, `precio`, `tipocatalogo`) VALUES (NULL, '"+RegDeco+"', '"+RegDesDec+"', 'NULL', '"+RegTamDec+"', '"+RegColDec+"', NULL, '"+RegPreDec+"', '"+RegTipDec+"');";
                comando.executeUpdate(QSQL);
                JOptionPane.showMessageDialog(null, "Registrado!!");
                conexion.close();
            }catch(SQLException ex){
                System.out.println(ex);
            }
        //}else {
          //  System.out.println("no se registro");
        //}
    }
    
    public void actualizaDecoracion(String id, String ModNomDec, String RegCombo6, String ModPreDec, String RegTamDec1, String RegColDec1, String ModDesDec){
        //String idcat = idCatalogo(RegCombo6);
        //if (idcat.equals("")!=true){
            try{
                conexion con = new conexion();
                Connection conexion = con.daConexion();
                Statement comando = conexion.createStatement();
                String QSQL = "update `insumos` set  nombreinsumo='"+ModNomDec+"', descripcion='"+ModDesDec+"', precio='"+ModPreDec+"', tamaño='"+RegTamDec1+"', color='"+RegColDec1+"', tipocatalogo='"+RegCombo6+"' where idinsumo='"+id+"'";
                comando.executeUpdate(QSQL);
                JOptionPane.showMessageDialog(null, "Actualizado!!");
                conexion.close();
            }catch(SQLException ex){
                System.out.println(ex);
            }
        //}else {
          //  System.out.println("no se registro");
        //}
    }
    
}
