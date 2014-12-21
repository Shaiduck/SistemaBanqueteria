/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mod_catalogo;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import mod_clientes.Consultar.Consultar;
import mod_clientes.EnviarCorreo.EnviarCorreo;
import mod_clientes.Modificar.Modifica;
import mod_clientes.Registrar.regisClientes;
import mod_ventas.GUI;
import mod_ventas.GUIControlPago;
import mod_historial.VentanaDatos;
import mod_agendar.pantalla2;
import mod_tareas.consultaAG;
import mod_cotizar.regCotizacion;

/**
 *
 * @author Herminio
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        
        WinConx wc = new WinConx();
        wc.setLocationRelativeTo(null);
        wc.setVisible(true);
        JDialog d1 = new JDialog(wc, "Configuración de conexión", true);
        
        d1.setLocationRelativeTo(null);
        d1.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnu_Principal = new javax.swing.JMenuBar();
        mnu_eventos = new javax.swing.JMenu();
        eve_agendar = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnu_cotizar = new javax.swing.JMenu();
        cot_generar = new javax.swing.JMenuItem();
        mnu_ventas = new javax.swing.JMenu();
        ven_cotizacion = new javax.swing.JMenuItem();
        ven_pagos = new javax.swing.JMenuItem();
        ven_historial = new javax.swing.JMenuItem();
        mnu_clientes = new javax.swing.JMenu();
        cli_nuevo = new javax.swing.JMenuItem();
        cli_modificar = new javax.swing.JMenuItem();
        cli_consultar = new javax.swing.JMenuItem();
        cli_enviar = new javax.swing.JMenuItem();
        mnu_catalogos = new javax.swing.JMenu();
        cat_actualizar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema Banquetes México");
        setMaximumSize(new java.awt.Dimension(374, 32771));

        mnu_eventos.setText("Eventos");

        eve_agendar.setText("Agendar evento");
        eve_agendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eve_agendarActionPerformed(evt);
            }
        });
        mnu_eventos.add(eve_agendar);

        jMenuItem1.setText("Tareas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnu_eventos.add(jMenuItem1);

        mnu_Principal.add(mnu_eventos);

        mnu_cotizar.setText("Cotizar");

        cot_generar.setText("Generar y consultar");
        cot_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cot_generarActionPerformed(evt);
            }
        });
        mnu_cotizar.add(cot_generar);

        mnu_Principal.add(mnu_cotizar);

        mnu_ventas.setText("Ventas");

        ven_cotizacion.setText("Generar venta");
        ven_cotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ven_cotizacionActionPerformed(evt);
            }
        });
        mnu_ventas.add(ven_cotizacion);

        ven_pagos.setText("Control de pagos");
        ven_pagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ven_pagosActionPerformed(evt);
            }
        });
        mnu_ventas.add(ven_pagos);

        ven_historial.setText("Ver historial de ventas");
        ven_historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ven_historialActionPerformed(evt);
            }
        });
        mnu_ventas.add(ven_historial);

        mnu_Principal.add(mnu_ventas);

        mnu_clientes.setText("Clientes");

        cli_nuevo.setText("Agregar nuevo");
        cli_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cli_nuevoActionPerformed(evt);
            }
        });
        mnu_clientes.add(cli_nuevo);

        cli_modificar.setText("Modificar");
        cli_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cli_modificarActionPerformed(evt);
            }
        });
        mnu_clientes.add(cli_modificar);

        cli_consultar.setText("Consultar");
        cli_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cli_consultarActionPerformed(evt);
            }
        });
        mnu_clientes.add(cli_consultar);

        cli_enviar.setText("Enviar correo electrónico");
        cli_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cli_enviarActionPerformed(evt);
            }
        });
        mnu_clientes.add(cli_enviar);

        mnu_Principal.add(mnu_clientes);

        mnu_catalogos.setText("Catálogos");
        mnu_catalogos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_catalogosActionPerformed(evt);
            }
        });

        cat_actualizar.setText("Actualizar catálogos");
        cat_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cat_actualizarActionPerformed(evt);
            }
        });
        mnu_catalogos.add(cat_actualizar);

        mnu_Principal.add(mnu_catalogos);

        setJMenuBar(mnu_Principal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ven_cotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ven_cotizacionActionPerformed
       GUI g = new GUI();
       g.setLocationRelativeTo(null);
       g.setVisible(true);
    }//GEN-LAST:event_ven_cotizacionActionPerformed

    private void ven_pagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ven_pagosActionPerformed
       GUIControlPago gcp = new GUIControlPago();
       gcp.setLocationRelativeTo(null);
       gcp.setVisible(true);
    }//GEN-LAST:event_ven_pagosActionPerformed

    private void mnu_catalogosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_catalogosActionPerformed
           
    }//GEN-LAST:event_mnu_catalogosActionPerformed

    private void cli_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cli_nuevoActionPerformed
       regisClientes nuevo = new regisClientes();
       nuevo.setLocationRelativeTo(null);
       nuevo.setVisible(true);
    }//GEN-LAST:event_cli_nuevoActionPerformed

    private void cli_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cli_modificarActionPerformed
        Modifica modi = new Modifica();
        modi.setLocationRelativeTo(null);
        modi.setVisible(true);
    }//GEN-LAST:event_cli_modificarActionPerformed

    private void cli_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cli_enviarActionPerformed
        EnviarCorreo enviar = new EnviarCorreo();
        enviar.setLocationRelativeTo(null);
        enviar.setVisible(true);
    }//GEN-LAST:event_cli_enviarActionPerformed

    private void cat_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cat_actualizarActionPerformed
       VentanaCatalogos catalogos = new VentanaCatalogos();
        catalogos.setLocationRelativeTo(null);
        catalogos.setVisible(true);  
    }//GEN-LAST:event_cat_actualizarActionPerformed

    private void cli_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cli_consultarActionPerformed
       Consultar consul = new Consultar();
       consul.setLocationRelativeTo(null);
       consul.setVisible(true);
    }//GEN-LAST:event_cli_consultarActionPerformed

    private void ven_historialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ven_historialActionPerformed
        VentanaDatos historial = new VentanaDatos();
        historial.setLocationRelativeTo(null);
        historial.setVisible(true);
    }//GEN-LAST:event_ven_historialActionPerformed

    private void eve_agendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eve_agendarActionPerformed
        pantalla2 agendar;
        try {
            agendar = new pantalla2();
            agendar.setLocationRelativeTo(null);
            agendar.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_eve_agendarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        consultaAG consular = new consultaAG();
        consular.setLocationRelativeTo(null);
        consular.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cot_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cot_generarActionPerformed
        regCotizacion generar = new regCotizacion();
        generar.setLocationRelativeTo(null);
        generar.setVisible(true);
    }//GEN-LAST:event_cot_generarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cat_actualizar;
    private javax.swing.JMenuItem cli_consultar;
    private javax.swing.JMenuItem cli_enviar;
    private javax.swing.JMenuItem cli_modificar;
    private javax.swing.JMenuItem cli_nuevo;
    private javax.swing.JMenuItem cot_generar;
    private javax.swing.JMenuItem eve_agendar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar mnu_Principal;
    private javax.swing.JMenu mnu_catalogos;
    private javax.swing.JMenu mnu_clientes;
    private javax.swing.JMenu mnu_cotizar;
    private javax.swing.JMenu mnu_eventos;
    private javax.swing.JMenu mnu_ventas;
    private javax.swing.JMenuItem ven_cotizacion;
    private javax.swing.JMenuItem ven_historial;
    private javax.swing.JMenuItem ven_pagos;
    // End of variables declaration//GEN-END:variables
}
