/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mod_cotizar;

/**
 *
 * @author Zaibeh
 */
public class CotInsumo {
    private int idCotizacion;

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public int getNumeroInsumo() {
        return numeroInsumo;
    }

    public void setNumeroInsumo(int numeroInsumo) {
        this.numeroInsumo = numeroInsumo;
    }
    private int idInsumo;
    private int numeroInsumo;
    
}
