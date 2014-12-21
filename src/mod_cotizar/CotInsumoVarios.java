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
public class CotInsumoVarios {
    
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    private int idCotInsumoVarios;

    public int getIdCotInsumoVarios() {
        return idCotInsumoVarios;
    }

    public void setIdCotInsumoVarios(int idCotInsumoVarios) {
        this.idCotInsumoVarios = idCotInsumoVarios;
    }
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    private float precio;
    private int cantidad;
}
