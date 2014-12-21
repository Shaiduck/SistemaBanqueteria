/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Bebida {
    public String idCatalogo(String TipoPla){
        try {
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            Statement comando = conexion.createStatement();
            String CSQL = "select idcatalogo from catalogo where nombrecatalogo='bebidas' and tipocatalogo='" + TipoPla + "'";            
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
    
    public void registraBebida(String Nompla, String TipoPla, String PrePla, String DesPla){
        //String idcat = idCatalogo(TipoPla);
        //if (idcat.equals("")!=true){
            try{
                conexion con = new conexion();
                Connection conexion = con.daConexion();
                Statement comando = conexion.createStatement();
                comando.executeUpdate("INSERT INTO `insumos` (`idinsumo`, `nombreinsumo`, `descripcion`, `precio`, `tipocatalogo`) VALUES (NULL, '"+Nompla+"', '"+DesPla+"', '"+PrePla+"', '"+TipoPla+"')");
                JOptionPane.showMessageDialog(null, "Registrado!!");
                conexion.close();
            } catch(SQLException ex){
                System.out.println(ex);
            }
        //}
    }
    
    public boolean estaBebida(String Nompla, String PrePla, String DesPla, String TipBeb) {
        try{
            String id = idCatalogo(TipBeb);
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            Statement comando=conexion.createStatement();
            ResultSet registro = comando.executeQuery("select * from insumos where nombreinsumo='"+Nompla+"' and precio='"+PrePla+"' and descripcion='"+DesPla+"'");
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
    
    public void actualizaBebida(String id,String Nompla, String TipoPla, String PrePla, String DesPla){
        //String idcat = idCatalogo(TipoPla);
        //if (idcat.equals("")!=true){
            try{
                conexion con = new conexion();
                Connection conexion = con.daConexion();
                Statement comando = conexion.createStatement();
                comando.executeUpdate("update `insumos` set  nombreinsumo='"+Nompla+"', descripcion='"+DesPla+"', precio='"+PrePla+"', tipocatalogo='"+TipoPla+"' where idinsumo='"+id+"'");
                JOptionPane.showMessageDialog(null, "Actualizado!!");
                conexion.close();
            } catch(SQLException ex){
                System.out.println(ex);
            }
        //}
    }
    
}
