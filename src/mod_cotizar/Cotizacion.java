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
public class Cotizacion {
    private static final regCotizacion ventanaCotizaciones= new regCotizacion();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        initGUI();
    }
    
    public static void initGUI(){
        ventanaCotizaciones.setVisible(true);
        ventanaCotizaciones.setEnabled(true);
    }
}
