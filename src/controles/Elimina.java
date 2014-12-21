/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sql.*;

/**
 *
 * @author Jesus
 */
public class Elimina {
    
    private Platillo platillo;
    private Bebida bebida;
    private Mobiliario mobiliario;
    private Decoracion decoracion;
    private Bocadillos bocadillo;
    private Personal personal;
    
    public Elimina(){
        platillo = new Platillo();
        bebida = new Bebida();
        mobiliario = new Mobiliario();
        decoracion = new Decoracion();
        bocadillo = new Bocadillos();
        personal = new Personal();
    }
    
    public void validaEliminacion(String id){
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(null, "Error no se eligio insumo!!");
        }else{
            eliminaInsumo(id);
        }
    }
        
    public void eliminaInsumo(String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_banquetesmexico", "root", "");
            Statement comando = conexion.createStatement();
            comando.executeUpdate("DELETE FROM `bd_banquetesmexico`.`insumos` WHERE `insumos`.`idinsumo` = " + id + "");
            JOptionPane.showMessageDialog(null, "Eliminado!!");
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Platillo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
