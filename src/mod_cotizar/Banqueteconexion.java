
package mod_cotizar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Aoki
 */
public class Banqueteconexion {
   private static Connection con=null;
  public Connection conexion(){
  try{
      //cargar dee driver
      Class.forName("com.mysql.jdbc.Driver");
      con=DriverManager.getConnection("jdbc:mysql://localhost/bd_banquetesmexico","root","");
     // System.out.printf("conexion establecida");
   //  JOptionPane.showMessageDialog(null, "conexion establecida ");
  }catch(Exception e ){
    
     // JOptionPane.showMessageDialog(null, "error de conexion "+e);
      System.out.printf("error de conexion");
  } 
      return con;
  }
}
