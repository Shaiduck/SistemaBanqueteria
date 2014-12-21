/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus
 */
public class Platillo {
    
    
    
    public boolean estaPlatillo(String Nompla, String PrePla, String DesPla, String TipPla){
        try{
            //String id = idCatalogo(TipPla);
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            Statement comando=conexion.createStatement();
            ResultSet registro = comando.executeQuery("select * from insumos where nombreinsumo='"+Nompla+"' and precio='"+PrePla+"' and descripcion='"+DesPla+"' and tipocatalogo='"+TipPla+"'");
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
    
    public void registraPlatillo(String Nompla, String TipoPla, String PrePla, String DesPla){
        //String idcat = idCatalogo(TipoPla);
        //if (idcat.equals("")!=true){
            try{
                String idcat= TipoPla;
                conexion con = new conexion();
                Connection conexion = con.daConexion();
                Statement comando = conexion.createStatement();
                comando.executeUpdate("INSERT INTO `insumos` (`idinsumo`, `nombreinsumo`, `descripcion`, `precio`, `tipocatalogo`) VALUES (NULL, '"+Nompla+"', '"+DesPla+"', '"+PrePla+"', '"+idcat+"')");
                JOptionPane.showMessageDialog(null, "Registrado!!");
                conexion.close();
            } catch(SQLException ex){
                System.out.println(ex);
            }
        //}
    }
    
    public String idCatalogo(String TipoPla){
        try {
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            Statement comando = conexion.createStatement();
            String CSQL = "select idcatalogo from catalogo where nombrecatalogo='platillo' and tipocatalogo='" + TipoPla + "'";            
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
    
    public void actualizaPlatillo(String id, String Nompla, String TipoPla, String PrePla, String DesPla){
        //String idcat = idCatalogo(TipoPla);
        //if (idcat.equals("")!=true){
            try{
                conexion con = new conexion();
                Connection conexion = con.daConexion();
                Statement comando = conexion.createStatement();
                //INSERT INTO `insumos` (`idinsumo`, `nombreinsumo`, `descripcion`, `precio`, `fkidcatalogo`) VALUES (NULL, '"+Nompla+"', '"+DesPla+"', '"+PrePla+"', '"+idcat+"')"
                comando.executeUpdate("update `insumos` set `nombreinsumo`='"+Nompla+"', `descripcion`='"+DesPla+"', `precio`='"+PrePla+"', `tipocatalogo`='"+TipoPla+"' where idinsumo='"+id+"'");
                JOptionPane.showMessageDialog(null, "Actualizado!!");
                conexion.close();
            } catch(SQLException ex){
                System.out.println(ex);
            }
        //}
    }

}
