package sql;

/**
 *
 * @author Shaiduck
 */

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;

public class SQL {
    
    static Statement s;
    
    public static ResultSet query(String sQuery) throws SQLException
    {
        Connection conn = new conexion().daConexion();
        try
        {
            s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return s.executeQuery(sQuery);
        }
        catch(SQLException e)
        {
            System.err.println("Error: "+e.getMessage() + "\n"+ e.getErrorCode());
        }
        finally
        {
            
        }
        return null;
    }
    
    public static int update(String sentencia) throws SQLException
    {
        Connection conn = new conexion().daConexion();
        try
        {
            Statement s = conn.createStatement();
            return s.executeUpdate(sentencia);
        }
        catch (SQLException e)
        {
            System.err.println("Error: "+e.getMessage() + "\n"+ e.getErrorCode());
        }
        finally
        {
            conn.close();;
        }
        return -1;
    }
    
    public static int lastID(String tabla) throws SQLException
    {
        Connection conn = new conexion().daConexion();
        try
        {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery("SELECT LAST_INSERT_ID() FROM "+tabla);
            if(rs!=null && rs.next())
            {
                return rs.getInt(1);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error: "+e.getMessage()+"\n"+e.getErrorCode());
        }
        finally
        {
            conn.close();
        }
        return -1;
    }
    
    public void close(Statement s)
    {
        try
        {
            s.close();
        }
        catch (SQLException e)
        {
            System.err.println("Error: "+e.getMessage()+"\n"+e.getErrorCode());
        }
    }
    
}
