/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mod_clientes;

//AGREGAR RFC DEL CLIENTE
//CLIENTE REFERENCIADO POR ALGUIEN MÁS?
//

import mod_clientes.Consultar.Consultar;
import mod_clientes.EnviarCorreo.EnviarCorreo;
import mod_clientes.Modificar.Modifica;
import mod_clientes.Registrar.regisClientes;
import sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Shaiduck
 */
public class ManejoClientes {

    /**
     * @param args the command line arguments
    
    */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Consultar a = new Consultar();
        EnviarCorreo b = new EnviarCorreo();
        Modifica c = new Modifica();
        regisClientes d = new regisClientes();
        a.setVisible(true);
        b.setVisible(true);
        c.setVisible(true);
        d.setVisible(true);
        
    }
    
}