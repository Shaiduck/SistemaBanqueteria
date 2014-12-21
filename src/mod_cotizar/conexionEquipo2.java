/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mod_cotizar;

import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Zaibeh
 */
public class conexionEquipo2 {
    private Banqueteconexion conn= new Banqueteconexion();
    
    public LinkedList<CotTotales> getListaFinal(int idCotizacion){
        System.out.println(idCotizacion);
        LinkedList<CotTotales> resultLista = new LinkedList<>();
        String query="SELECT cotinsumo.idcotizacion, cotinsumo.idinsumo, cotinsumo.numeroinsumos, insumos.nombreinsumo, insumos.precio FROM cotinsumo INNER JOIN insumos ON cotinsumo.idinsumo = insumos.idinsumo WHERE cotinsumo.idcotizacion = "+idCotizacion;
        ResultSet result;
        CotTotales cotizarQuery;
        try {
          result=conn.conexion().createStatement().executeQuery(query);
          while (result.next()){
              cotizarQuery = new CotTotales();
              cotizarQuery.setIdCotizacion(Integer.parseInt(result.getString("idcotizacion")));
              cotizarQuery.setIdConsumo(Integer.parseInt(result.getString("idinsumo")));
              cotizarQuery.setCantidad(Integer.parseInt(result.getString("numeroinsumos")));
              cotizarQuery.setPrecio(Float.parseFloat(result.getString("precio")));
              cotizarQuery.setNombreInsumo(result.getString("nombreinsumo"));
              System.out.println(cotizarQuery.getNombreInsumo());
              resultLista.add(cotizarQuery);
          }
      } catch (Exception e) {
          System.out.println("error en select cotizar"+e.toString());
      }
        return  resultLista;
    }
    
    public LinkedList<Cotizar> getCotizacionConsulta(int idAgenda){
       LinkedList<Cotizar> nombres = new LinkedList<Cotizar>();
      
      String query="SELECT cotizar.idcotizacion, cotizar.numpax, cotizar.totalpax, cotizar.costototal, cotizar.estado, cotizar.observaciones,cotizar.fechacotizar, cotizar.fkidagenda FROM cotizar WHERE cotizar.fkidagenda ="+idAgenda;
      ResultSet result;
      Cotizar cotizarQuery;
      
      try {
          result=conn.conexion().createStatement().executeQuery(query);
          while (result.next()){
              cotizarQuery = new Cotizar();
              cotizarQuery.setIdcotizacion(Integer.parseInt(result.getString("idcotizacion")));
              cotizarQuery.setNumpax(Integer.parseInt(result.getString("numpax")));
              cotizarQuery.setTotalpax(Float.parseFloat(result.getString("totalpax")));
              cotizarQuery.setCostototal(Float.parseFloat(result.getString("costototal")));
              cotizarQuery.setObservaciones(result.getString("observaciones"));
              nombres.add(cotizarQuery);
          }
      } catch (Exception e) {
          System.out.println("error en select cotizar"+e.toString());
      }
      return nombres;
    }
    
    public LinkedList<CotizarEvento> getTipoEventos(){
      LinkedList<CotizarEvento> tiposEvento= new LinkedList<CotizarEvento>();
      String query="SELECT agenda.idevento, agenda.tipoevento, cliente.Nombre, cliente.ApPaterno, cliente.ApMaterno FROM agenda INNER JOIN cliente ON agenda.fkidcliente = cliente.idCliente";
      ResultSet result;
      CotizarEvento agendaQuery;
      
      try {
          result=conn.conexion().createStatement().executeQuery(query);
          while (result.next()){
              agendaQuery = new CotizarEvento();
              agendaQuery.setIdEvento(Integer.parseInt(result.getString("idevento")));
              agendaQuery.setNombre(result.getString("tipoevento"));
              agendaQuery.setNombreCte(result.getString("nombre"));
              agendaQuery.setAp(result.getString("appaterno"));
              agendaQuery.setAm(result.getString("apmaterno"));
              System.out.println(agendaQuery.getNombreCte());
              tiposEvento.add(agendaQuery);
          }
      } catch (Exception e) {
          System.out.println("error en select insumos");
      }
      return tiposEvento;
    }
    
    
    public int insertCotizacion(int numax, Float totalpax, String observaciones,int idAgenda){
        int result=0;
        String query="INSERT INTO `cotizar` (`numpax`, `totalpax`, `estado`, `observaciones`, `fechacotizar`, `fkidagenda`) VALUES ('"+numax+"', '"+totalpax+"', '0', '"+observaciones+"', now(), '"+idAgenda+"')";
        try {
            conn.conexion().createStatement().execute(query);
            JOptionPane.showMessageDialog(null, "Se ha agregado correctamente.");
        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema, intente más tarde o comuniquese con el administrador del sistema.");
        }
        ResultSet resultSet;
        try {
            query="SELECT DISTINCT cotizar.idcotizacion FROM cotizar ORDER BY cotizar.idcotizacion DESC LIMIT 1";
            resultSet=conn.conexion().createStatement().executeQuery(query);
            while (resultSet.next()){
              result=Integer.parseInt(resultSet.getString("idcotizacion"));
          }
        } catch (Exception e) {
            
        }
        return result;
    }
    
    public boolean insertCosto(int idCotizacion, Double total){
        String query="UPDATE `cotizar` SET `costototal`='"+total.toString()+"' WHERE (`idcotizacion`='"+idCotizacion+"')";
      try {
          conn.conexion().createStatement().execute(query);
          return true;
      } catch (Exception e) {
          return false;
      }
    }
    
    public boolean insertCotInsumo(CotInsumo insert){
      String query = "insert into cotinsumo values ("+insert.getIdCotizacion()+","+insert.getIdInsumo()+","+insert.getNumeroInsumo()+");";
      try {
          conn.conexion().createStatement().execute(query);
          return true;
      } catch (Exception e) {
          return false;
      }
  }

    public int  insertInsumosVarios(CotInsumoVarios insert){
        String query ="INSERT INTO `insumos` (`nombreinsumo`, `precio`, `tipocatalogo`) VALUES ('"+insert.getNombre()+"', '"+insert.getPrecio()+"', '"+insert.getTipo()+"')";
        ResultSet resultSet;
        int result =0;
        try {
            conn.conexion().createStatement().execute(query);
        } catch (Exception e) {
            
        }
        try {
            query="SELECT DISTINCT insumos.idinsumo FROM insumos ORDER BY insumos.idinsumo DESC LIMIT 1";
            resultSet=conn.conexion().createStatement().executeQuery(query);
            while (resultSet.next()){
              result=Integer.parseInt(resultSet.getString("idinsumo"));
          }
        } catch (Exception e) {
            
        }
        return result;
    }
  
  public LinkedList<Cotizar> getCotizar(){
    LinkedList<Cotizar> nombres = new LinkedList<Cotizar>();
      
      String query="SELECT idcotizar from cotizar";
      ResultSet result;
      Cotizar cotizarQuery;
      
      try {
          result=conn.conexion().createStatement().executeQuery(query);
          while (result.next()){
              cotizarQuery = new Cotizar(Integer.parseInt(result.getString(0)));
              nombres.add(cotizarQuery);
          }
      } catch (Exception e) {
          System.out.println("error en select insumos");
      }
      return nombres;
  }       
  
  public LinkedList<Insumos> getNombresMobiliario(){
      LinkedList<Insumos> nombres = new LinkedList<Insumos>();
      
      String query="SELECT idinsumo, nombreinsumo,precio from insumos WHERE tipocatalogo='Mobiliario'";//where tipocatalogo
      ResultSet result;
      Insumos insumoQuery;
      
      try {
          result=conn.conexion().createStatement().executeQuery(query);
          while (result.next()){
              insumoQuery= new Insumos();
              insumoQuery.setIdinsumo(Integer.parseInt(result.getString("idinsumo")));
              insumoQuery.setNombreinsumo(result.getString("nombreinsumo"));
              insumoQuery.setPrecio(Float.parseFloat(result.getString("precio")));
              nombres.add(insumoQuery);
          }
      } catch (Exception e) {
          System.out.println("error en select insumos"+e.toString());
      }
      return nombres;
  }
  
  public LinkedList<CotTotales> getPreciosCantidades(int idCotizacion){
      LinkedList<CotTotales> nombres = new LinkedList<CotTotales>();
      
      String query="SELECT cotinsumo.idcotizacion, cotinsumo.idinsumo, cotinsumo.numeroinsumos FROM cotinsumo WHERE cotinsumo.idcotizacion = "+idCotizacion;
      ResultSet result;
      CotTotales insumoQuery;
      
      try {
          result=conn.conexion().createStatement().executeQuery(query);
          while (result.next()){
              insumoQuery= new CotTotales();
              insumoQuery.setIdCotizacion(Integer.parseInt(result.getString("idcotizacion")));
              insumoQuery.setIdConsumo(Integer.parseInt(result.getString("idinsumo")));
              insumoQuery.setCantidad(Integer.parseInt(result.getString("numeroinsumos")));
              nombres.add(insumoQuery);
          }
      } catch (Exception e) {
          System.out.println("error en select insumos"+e.toString());
      }
      return nombres;
  }
  
  public LinkedList<Insumos> getNombresBebidas(){
      LinkedList<Insumos> bebidas = new LinkedList<Insumos>();
      
      String query="SELECT idinsumo, nombreinsumo,precio from insumos WHERE tipocatalogo='Bebidas'";//where tipocatalogo
      ResultSet result;
      Insumos insumoQuery;
      
      try {
          result=conn.conexion().createStatement().executeQuery(query);
          while (result.next()){
              insumoQuery= new Insumos();
              insumoQuery.setIdinsumo(Integer.parseInt(result.getString("idinsumo")));
              insumoQuery.setNombreinsumo(result.getString("nombreinsumo"));
              insumoQuery.setPrecio(Float.parseFloat(result.getString("precio")));
              bebidas.add(insumoQuery);
          }
      } catch (Exception e) {
          System.out.println("error en select insumos"+e.toString());
      }
      return bebidas;
  }  
  public LinkedList<Insumos> getNombresPlatillos(){
      LinkedList<Insumos> platillos = new LinkedList<Insumos>();
      
      String query="SELECT idinsumo, nombreinsumo,precio from insumos WHERE tipocatalogo='Platillos'";//where tipocatalogo
      ResultSet result;
      Insumos insumoQuery;
      
      try {
          result=conn.conexion().createStatement().executeQuery(query);
          while (result.next()){
              insumoQuery= new Insumos();
              insumoQuery.setIdinsumo(Integer.parseInt(result.getString("idinsumo")));
              insumoQuery.setNombreinsumo(result.getString("nombreinsumo"));
              insumoQuery.setPrecio(Float.parseFloat(result.getString("precio")));
              platillos.add(insumoQuery);
          }
      } catch (Exception e) {
          System.out.println("error en select insumos"+e.toString());
      }
      return platillos;
  } 
  public LinkedList<Insumos> getNombresDecoraciones(){
      LinkedList<Insumos> decoraciones = new LinkedList<Insumos>();
      
      String query="SELECT idinsumo, nombreinsumo,precio from insumos WHERE tipocatalogo='Decoraciones'";//where tipocatalogo
      ResultSet result;
      Insumos insumoQuery;
      
      try {
          result=conn.conexion().createStatement().executeQuery(query);
          while (result.next()){
              insumoQuery= new Insumos();
              insumoQuery.setIdinsumo(Integer.parseInt(result.getString("idinsumo")));
              insumoQuery.setNombreinsumo(result.getString("nombreinsumo"));
              insumoQuery.setPrecio(Float.parseFloat(result.getString("precio")));
              decoraciones.add(insumoQuery);
          }
      } catch (Exception e) {
          System.out.println("error en select insumos"+e.toString());
      }
      return decoraciones;
  } 
  public LinkedList<Insumos> getNombresBocadillos(){
      LinkedList<Insumos> bocadillos = new LinkedList<Insumos>();
      
      String query="SELECT idinsumo, nombreinsumo,precio from insumos WHERE tipocatalogo='Bocadillos'";//where tipocatalogo
      ResultSet result;
      Insumos insumoQuery;
      
      try {
          result=conn.conexion().createStatement().executeQuery(query);
          while (result.next()){
              insumoQuery= new Insumos();
              insumoQuery.setIdinsumo(Integer.parseInt(result.getString("idinsumo")));
              insumoQuery.setNombreinsumo(result.getString("nombreinsumo"));
              insumoQuery.setPrecio(Float.parseFloat(result.getString("precio")));
              bocadillos.add(insumoQuery);
          }
      } catch (Exception e) {
          System.out.println("error en select insumos"+e.toString());
      }
      return bocadillos;
  } 
  public LinkedList<Insumos> getNombresPersonal(){
      LinkedList<Insumos> personal = new LinkedList<Insumos>();
      
      String query="SELECT idinsumo, nombreinsumo,precio from insumos WHERE tipocatalogo='Personal'";//where tipocatalogo
      ResultSet result;
      Insumos insumoQuery;
      
      try {
          result=conn.conexion().createStatement().executeQuery(query);
          while (result.next()){
              insumoQuery= new Insumos();
              insumoQuery.setIdinsumo(Integer.parseInt(result.getString("idinsumo")));
              insumoQuery.setNombreinsumo(result.getString("nombreinsumo"));
              insumoQuery.setPrecio(Float.parseFloat(result.getString("precio")));
              personal.add(insumoQuery);
          }
      } catch (Exception e) {
          System.out.println("error en select insumos"+e.toString());
      }
      return personal;
  } 
  public LinkedList<Insumos> getNombresVarios(){
      LinkedList<Insumos> varios = new LinkedList<Insumos>();
      
      String query="SELECT idinsumo, nombreinsumo,precio from insumos WHERE tipocatalogo='varios'";//
      ResultSet result;
      Insumos insumoQuery;
      
      try {
          result=conn.conexion().createStatement().executeQuery(query);
          while (result.next()){
              insumoQuery= new Insumos();
              insumoQuery.setIdinsumo(Integer.parseInt(result.getString("idinsumo")));
              insumoQuery.setNombreinsumo(result.getString("nombreinsumo"));
              insumoQuery.setPrecio(Float.parseFloat(result.getString("precio")));
              varios.add(insumoQuery);
          }
      } catch (Exception e) {
          System.out.println("error en select insumos"+e.toString());
      }
      return varios;
  } 
}
