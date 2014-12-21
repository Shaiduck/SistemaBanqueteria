/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mod_agendar;
import java.sql.*;
/**
 *
 * @author claudia
 */
public class conectar{
    Connection con=null;
    public Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/bd_banquetesmexico","root","");
          System.out.println("Conexion Establecida");
        }catch(Exception e){
             System.out.println("Error de Conexion ");
        }
        
        return con;
    
    
    
    }
}
