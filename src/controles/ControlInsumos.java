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
public class ControlInsumos {
    
    private Platillo platillo;
    private Bebida bebida;
    private Mobiliario mobiliario;
    private Decoracion decoracion;
    private Bocadillos bocadillo;
    private Personal personal;
    private Salon salon;
    
    public ControlInsumos(){
        platillo = new Platillo();
        bebida = new Bebida();
        mobiliario = new Mobiliario();
        decoracion = new Decoracion();
        bocadillo = new Bocadillos();
        personal = new Personal();
        salon = new Salon();
    }
    
    public void validaPlatillo(String Nompla, String TipoPla, String PrePla, String DesPla) {
        //System.out.println(""+Nompla+"\n"+TipoPla+"\n"+PrePla+"\n"+DesPla);
        if(Nompla.equals("")){
            JOptionPane.showMessageDialog(null, "Nombre del platillo esta vacio!!");
        }else if((PrePla.equals(""))||(PrePla.equals("00"))){
            JOptionPane.showMessageDialog(null, "Precio del platillo esta vacio o no puede ser $0!!");
        }else if(DesPla.equals("")){
            JOptionPane.showMessageDialog(null, "Descripcion del platillo se encuentra vacio!!");
        }else if(platillo.estaPlatillo(Nompla, PrePla, DesPla, TipoPla)){
            JOptionPane.showMessageDialog(null, "Ese platillo ya esta registrado!!");
        }else{
            platillo.registraPlatillo(Nompla, TipoPla, PrePla, DesPla);
        }
    }
    
    public void validaBebida(String NomBeb, String TipoBeb, String PreBeb, String DesPla){
        if(NomBeb.equals("")){
            JOptionPane.showMessageDialog(null, "Nombre de la bebida esta vacio!!");
        }else if(PreBeb.equals("")||PreBeb.equals("00")){
            JOptionPane.showMessageDialog(null, "Precio de la bebida esta vacio!!");
        }else if(DesPla.equals("")){
            JOptionPane.showMessageDialog(null, "Descripcion de la bebida esta vacio!!");
        }else if(bebida.estaBebida(NomBeb, PreBeb, DesPla,TipoBeb)){
            JOptionPane.showMessageDialog(null, "Esta bebida ya esta registrada!!");
        }else{
            bebida.registraBebida(NomBeb, TipoBeb, PreBeb, DesPla);
        }
    }
    
    public void validaMobiliario(String nomMob, String PreMob, String DesMob, String color, String forma, String cinta){
        if(nomMob.equals("")){
            JOptionPane.showMessageDialog(null, "Nombre del mobiliario esta vacio!!");
        }else if(PreMob.equals("")||PreMob.equals("00")){
            JOptionPane.showMessageDialog(null, "Precio del mobiliario esta vacio!!");
        }else if(DesMob.equals("")){
            JOptionPane.showMessageDialog(null, "Descripcion del mobiliario esta vacio!!");
        }else if(mobiliario.estaMoviliario(nomMob, PreMob, DesMob, color,forma,cinta)){
            JOptionPane.showMessageDialog(null, "Esta moviliario ya esta registrada!!");
        }else {
            mobiliario.registraMoviliario(nomMob, PreMob, DesMob,color,forma,cinta);
        }
    }
    
    public void validaDecoraciones(String RegDeco, String RegTipDec, String RegPreDec, String RegTamDec, String RegColDec, String RegDesDec){
        if (RegDeco.equals("")){
            JOptionPane.showMessageDialog(null, "El nombre de la decoracion esta vacio!!");
        }else if(RegTipDec.equals("")){
            JOptionPane.showMessageDialog(null, "El Tipo de decoracion es invalido!!");
        }else if((RegPreDec.equals("")||(RegPreDec.equals("00")))){
            JOptionPane.showMessageDialog(null, "El precio de la decoracion esta vacio!!");
        }else if(RegTamDec.equals("")){
            JOptionPane.showMessageDialog(null, "El tamaño de la decoracion esta vacio!!");
        }else if(RegColDec.equals("")){
            JOptionPane.showMessageDialog(null, "El color de la decoracion esta vacio!!");
        }else if(RegDesDec.equals("")){
            JOptionPane.showMessageDialog(null, "La descripcion de la decoracion esta vacio!!");
        }else if(decoracion.estaDecoracion(RegDeco, RegPreDec, RegDesDec, RegTamDec, RegColDec, RegTipDec)){
            JOptionPane.showMessageDialog(null, "Esta decoracion ya esta registrada");
        }else {
            decoracion.registraDecoracion(RegDeco, RegTipDec, RegPreDec, RegTamDec, RegColDec, RegDesDec);
        }
    }
    
    public void validaBocadillos(String RegBocNom, String RegPreBoc, String RegTipBoc, String RegDesBoc){
        if(RegBocNom.equals("")){
            JOptionPane.showMessageDialog(null, "Nombre del bocadillo esta vacio");
        }else if((RegPreBoc.equals(""))||(RegPreBoc.equals(00))){
            JOptionPane.showMessageDialog(null, "Precio del bocadillo esta vacio");
        }else if(RegDesBoc.equals("")){
            JOptionPane.showMessageDialog(null, "Descripcion del bocadillo esta vacio");
        }else if(bocadillo.estaBocadillo(RegBocNom, RegPreBoc, RegDesBoc, RegTipBoc)){
            JOptionPane.showMessageDialog(null, "El bocadillo ya esta registrado");
        }else{
            bocadillo.registraBocadillo(RegBocNom, RegPreBoc, RegDesBoc, RegTipBoc);
        }
    }
    
    public void validaPersonal(String RegNomPer, String RegPrePer, String RegDesPer){
        if(RegNomPer.equals("")){
            JOptionPane.showMessageDialog(null, "El nombre del personal esta vacio");
        }else if((RegPrePer.equals(""))||(RegPrePer.equals("00"))){
            JOptionPane.showMessageDialog(null, "El Precio esta vacio");
        }else if(RegDesPer.equals("")){
            JOptionPane.showMessageDialog(null, "La descripcion del personal esta vacia");
        }else if(personal.estaPersonal(RegNomPer, RegPrePer, RegDesPer)){
            JOptionPane.showMessageDialog(null, "Este personal ya esta registrado");
        }else{
            personal.registraPersonal(RegNomPer, RegPrePer, RegDesPer);
        }
    }
    
    public void validaSalon(String RegNomSal, String RegPreSal){
        if(RegNomSal.isEmpty()){
            JOptionPane.showMessageDialog(null, "El nombre del salon esta vacio");
        }else if(RegPreSal.isEmpty()){
            JOptionPane.showMessageDialog(null, "El precio del salon esta vacio");
        }else if(salon.estaSalon(RegNomSal, RegPreSal)){
            JOptionPane.showMessageDialog(null, "Este salon ya esta registrado");
        }else{
            salon.registraSalon(RegNomSal, RegPreSal);
        }
    }
    
}
