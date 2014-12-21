/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import javax.swing.JOptionPane;
import sql.*;

/**
 *
 * @author Jesus
 */
public class Actualiza {
    
    private Platillo platillo;
    private Bebida bebida;
    private Mobiliario mobiliario;
    private Decoracion decoracion;
    private Bocadillos bocadillo;
    private Personal personal;
    
    public Actualiza(){
        platillo = new Platillo();
        bebida = new Bebida();
        mobiliario = new Mobiliario();
        decoracion = new Decoracion();
        bocadillo = new Bocadillos();
        personal = new Personal();
    }
    
    public void actualizaPlatillos(String id, String Nompla, String TipoPla, String PrePla, String DesPla){
        if(id.equals("")){
            JOptionPane.showMessageDialog(null, "Insumo mal elegido!!");
        }else if(Nompla.equals("")){
            JOptionPane.showMessageDialog(null, "El nombre del platillo esta vacio!!");
        }else if(TipoPla.equals("")){
            JOptionPane.showMessageDialog(null, "El tipo del platillo esta vacio!!");
        }else if(PrePla.equals("")){
            JOptionPane.showMessageDialog(null, "El precio del platillo esta vacio!!");
        }else if(DesPla.equals("")){
            JOptionPane.showMessageDialog(null, "La descripcion del platillo esta vacio!!");
        }else if(platillo.estaPlatillo(Nompla, PrePla, DesPla,TipoPla)){
            JOptionPane.showMessageDialog(null, "No se cambio ningun campo del platillo!!");
        }else{
            platillo.actualizaPlatillo(id, Nompla, TipoPla, PrePla, DesPla);
        }
    }
    
    public void actualizaBebidas(String id, String ModNomBeb, String ModPreBeb, String ModDesBeb, String ModTipBeb){
        if(id.equals("")){
            JOptionPane.showMessageDialog(null, "Insumo mal elegido!!");
        }else if(ModNomBeb.equals("")){
            JOptionPane.showMessageDialog(null, "El nombre de la bebida esta vacio!!");
        }else if(ModPreBeb.equals("")){
            JOptionPane.showMessageDialog(null, "El precio de la bebida esta vacio!!");
        }else if(ModDesBeb.equals("")){
            JOptionPane.showMessageDialog(null, "La descripcion de la bebida esta vacia!!");
        }else if(bebida.estaBebida(ModNomBeb, ModPreBeb, ModDesBeb, ModTipBeb)){
            JOptionPane.showMessageDialog(null, "No se modifico ningun campo de la bebida!!");
        }else{
            //String id,String Nompla, String TipoPla, String PrePla, String DesPla
            bebida.actualizaBebida(id, ModNomBeb, ModTipBeb, ModPreBeb , ModDesBeb);
        }
    }
    
    public void actualizaMobiliario(String id, String ModNomMob, String ModPreMob, String CheckCintilla1, String ModColMob, String ModForMob, String ModDesMob){
        if(id.equals("")){
            JOptionPane.showMessageDialog(null, "Insumo mal elegido!!");
        }else if(ModNomMob.equals("")){
            JOptionPane.showMessageDialog(null, "El nombre del mobiliario esta vacio!!");
        }else if(ModPreMob.equals("")){
            JOptionPane.showMessageDialog(null, "El precio del mobiliario esta vacio!!");
        }else if(ModDesMob.equals("")){
            JOptionPane.showMessageDialog(null, "La descripcion del mobiliario esta vacia!!");
            //String Nompla, String PrePla, String DesPla, String ModColMob, String ModForMob, String cinta
        }else if(mobiliario.estaMoviliario(ModNomMob, ModPreMob, ModDesMob, ModColMob, ModForMob, CheckCintilla1)){
            JOptionPane.showMessageDialog(null, "No se realizo ningun cambio en el mobiliario!!");
        }else{
            mobiliario.actualizaMoviliario(id, ModNomMob, ModPreMob, ModDesMob, ModColMob, ModForMob, CheckCintilla1);
        }
    }
    
    public void actualizaDecoraciones(String id, String ModNomDec, String RegCombo6, String ModPreDec, String RegTamDec1, String RegColDec1, String ModDesDec){
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(null, "Insumo mal elegido!!");
        }else if(ModNomDec.isEmpty()){
            JOptionPane.showMessageDialog(null, "El nombre de la decoracion esta vacio!!");
        }else if(ModPreDec.isEmpty()){
            JOptionPane.showMessageDialog(null, "El precio de la decoracion esta vacio!!");
        }else if(ModDesDec.isEmpty()){
            JOptionPane.showMessageDialog(null, "La descripcion de la decoracion esta vacia!!");
        }else if(decoracion.estaDecoracion(ModNomDec, ModPreDec, ModDesDec, RegTamDec1, RegColDec1, RegCombo6)){
            JOptionPane.showMessageDialog(null, "No se realizo ningun cambio en la decoracion!!");
        }else{
            decoracion.actualizaDecoracion(id, ModNomDec, RegCombo6, ModPreDec, RegTamDec1, RegColDec1, ModDesDec);
        }
    }
    
    public void actualizaBocadillos(String id, String ModNomBoc, String ModPreBoc, String RegTipBoc1, String ModDesBoc){
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(null, "Insumo mal elegido!!");
        }else if(ModNomBoc.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nombre del bocadillo esta vacio!!");
        }else if(ModPreBoc.isEmpty()){
            JOptionPane.showMessageDialog(null, "Precio del bocadillo esta vacio!!");
        }else if(ModDesBoc.isEmpty()){
            JOptionPane.showMessageDialog(null, "Descripcion del bocadillo esta vacio!!");
        }else if(bocadillo.estaBocadillo(ModNomBoc, ModPreBoc, ModDesBoc, RegTipBoc1)){
            JOptionPane.showMessageDialog(null, "Este bocadillo ya esta registrado!!");
        }else{
            bocadillo.actualizaBocadillo(id, ModNomBoc, ModPreBoc, ModDesBoc, RegTipBoc1);
        }
    }
    
    public void actualizaPersonal(String id, String ModNomPer, String ModSuelPer, String ModDesPer){
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(null, "Insumo mal elegido!!");
        }else if(ModNomPer.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nombre del personal vacio!!");
        }else if(ModSuelPer.isEmpty()){
            JOptionPane.showMessageDialog(null, "Sueldo del personal vacio!!");
        }else if(ModDesPer.isEmpty()){
            JOptionPane.showMessageDialog(null, "Descripcion del personal vacio!!");
        }else if(personal.estaPersonal(ModNomPer, ModSuelPer, ModDesPer)){
            JOptionPane.showMessageDialog(null, "No se ha realizado ningun cambio!!");
        }else{
            personal.actualizaPersonal(id, ModNomPer, ModSuelPer, ModDesPer);
        }
    }
}
