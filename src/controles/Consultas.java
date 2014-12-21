/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sql.conexion;

/**
 *
 * @author Jesus
 */
public class Consultas {
    public DefaultTableModel llenaPlatillos(){
        DefaultTableModel dfm = new DefaultTableModel(null, new Object[]{"id","nombre","Precio","descripcion"});
        try {
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            PreparedStatement consulta = conexion.prepareStatement("SELECT `idinsumo`, `nombreinsumo`, `precio`, `descripcion` FROM `insumos` WHERE tipocatalogo='Platillos';");
            ResultSet read = consulta.executeQuery();
            while(read.next()){
                dfm.addRow(new Object [] {read.getString("idinsumo"),read.getString("nombreinsumo"),read.getString("precio"),read.getString("descripcion")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return dfm;
    }
    
    public DefaultTableModel llenaBebidas(){
        DefaultTableModel dfm = new DefaultTableModel(null, new Object[]{"id","nombre","Precio","descripcion"});
        try {
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            PreparedStatement consulta = conexion.prepareStatement("SELECT `idinsumo`, `nombreinsumo`, `precio`, `descripcion` FROM `insumos` WHERE `tipocatalogo`='Bebidas';");
            ResultSet read = consulta.executeQuery();
            while(read.next()){
                dfm.addRow(new Object [] {read.getString("idinsumo"),read.getString("nombreinsumo"),read.getString("precio"),read.getString("descripcion")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dfm;
    }
    
    public DefaultTableModel llenaMobiliario(){
        DefaultTableModel dfm = new DefaultTableModel(null, new Object[]{"id","nombre","Precio","descripcion","forma","color","cintilla"});
        try {
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            PreparedStatement consulta = conexion.prepareStatement("SELECT `idinsumo`, `nombreinsumo`, `precio`, `descripcion`, `forma`, `color`, `cintilla` FROM `insumos` WHERE `tipocatalogo`='mobiliario';");
            ResultSet read = consulta.executeQuery();
            while(read.next()){
                dfm.addRow(new Object [] {read.getString("idinsumo"),read.getString("nombreinsumo"),read.getString("precio"),read.getString("descripcion"),read.getString("forma"),read.getString("color"),read.getString("cintilla")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dfm;
    }
    
    public DefaultTableModel llenaDecoraciones(){
        DefaultTableModel dfm = new DefaultTableModel(null, new Object[]{"id","Nombre","Precio","Descripcion","Tamaño","Color"});
        try {
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            PreparedStatement consulta = conexion.prepareStatement("SELECT `idinsumo`, `nombreinsumo`, `precio`, `descripcion`, 'tamaño', 'color' FROM `insumos` WHERE `tipocatalogo`='Decoraciones';");
            ResultSet read = consulta.executeQuery();
            while(read.next()){
                dfm.addRow(new Object [] {read.getString("idinsumo"),read.getString("nombreinsumo"),read.getString("precio"),read.getString("descripcion"),read.getString("tamaño"),read.getString("color")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dfm;
    }
    
    public DefaultTableModel llenaBocadillos(){
        DefaultTableModel dfm = new DefaultTableModel(null, new Object[]{"id","Nombre","Precio","Descripcion"});
        try {
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            PreparedStatement consulta = conexion.prepareStatement("SELECT `idinsumo`, `nombreinsumo`, `precio`, `descripcion` FROM `insumos` WHERE `tipocatalogo`='Bocadillos';");
            ResultSet read = consulta.executeQuery();
            while(read.next()){
                dfm.addRow(new Object [] {read.getString("idinsumo"),read.getString("nombreinsumo"),read.getString("precio"),read.getString("descripcion")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dfm;
    }
    
    public DefaultTableModel llenaPersonal(){
        DefaultTableModel dfm = new DefaultTableModel(null, new Object[]{"id","Nombre","Precio","Descripcion"});
        try {
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            PreparedStatement consulta = conexion.prepareStatement("SELECT `idinsumo`, `nombreinsumo`, `precio`, `descripcion` FROM `insumos` WHERE `tipocatalogo`='personal';");
            ResultSet read = consulta.executeQuery();
            while(read.next()){
                dfm.addRow(new Object [] {read.getString("idinsumo"),read.getString("nombreinsumo"),read.getString("precio"),read.getString("descripcion")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dfm;
    }
    
    public void RegresaDatos(String id, JTextField NomPla2, JTextField ModPrePla, JTextArea ModDesPla){
        try {
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            PreparedStatement consulta = conexion.prepareStatement("SELECT `idinsumo`, `nombreinsumo`, `precio`, `descripcion` FROM `insumos` WHERE `idinsumo`='"+id+"'");
            ResultSet read = consulta.executeQuery();
            while(read.next()){
                NomPla2.setText(read.getString("nombreinsumo"));
                ModPrePla.setText(read.getString("precio"));
                ModDesPla.setText(read.getString("descripcion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel llenaSalon(){
        DefaultTableModel dfm = new DefaultTableModel(null, new Object[]{"id","Nombre","Precio"});
        try {
            conexion con = new conexion();
            Connection conexion = con.daConexion();
            PreparedStatement consulta = conexion.prepareStatement("SELECT `idinsumo`, `nombreinsumo`, `precio`, `descripcion` FROM `insumos` WHERE `descripcion`='salon'");
            ResultSet read = consulta.executeQuery();
            while(read.next()){
                dfm.addRow(new Object [] {read.getString("idinsumo"),read.getString("nombreinsumo"),read.getString("precio")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dfm;
    }
    
}
