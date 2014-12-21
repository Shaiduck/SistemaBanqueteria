/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod_historial;

import java.sql.*;

public class conectar {
Connection con = null;
public Connection conexion(){
try {
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost/bd_banquetesmexico","root","");
    
}catch(Exception e){
}

return con;

} 

}