/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mod_agendar;

import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Antrax
 */
public class Evento {
    private int idevento=0;
    private int fkidcliente;
    private String hora_evento;
    private String tipoevento;
    private String ciudadevento;
    private String fechaevento;

    public int getIdevento() {
        return idevento;
    }

    public int getIdcliente() {
        return fkidcliente;
    }

    public String getHora() {
        return hora_evento;
    }

    public String getEvento() {
        return tipoevento;
    }

    public String getLugar() {
        return ciudadevento;
    }

    public String getFecha() {
        return fechaevento;
    }

    public void setIdevento(int idevento) {
        this.idevento = idevento;
    }

    public void setIdcliente(int idcliente) {
        this.fkidcliente = idcliente;
    }

    public void setHora(String hora) {
        this.hora_evento = hora;
    }

    public void setEvento(String evento) {
        this.tipoevento = evento;
    }

    public void setLugar(String lugar) {
        this.ciudadevento = lugar;
    }

    public void setFecha(String fecha) {
        this.fechaevento = fecha;
    }
    
    
    public void almacenar(){
       
    conectar con=new conectar();
    try{
        Statement atm=con.conexion().createStatement();
        atm.execute("insert into bd_banquetesmexico.agenda values ('"+idevento+"','"+fkidcliente+"','"+hora_evento+"','"+tipoevento+"','"+ciudadevento+"','"+fechaevento+"')");
        JOptionPane.showMessageDialog(null, "Agendado correctamente.");
    }catch (Exception e) {
       JOptionPane.showMessageDialog(null, "Ocurrió un problema, intente más tarde.");
    }
}

    void setIdcliente(String toString) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
