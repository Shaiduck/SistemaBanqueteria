
package mod_historial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class VentanaDatos extends javax.swing.JFrame {

  
    public VentanaDatos() {
        initComponents();
        this.setTitle("Historial de Ventas");
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        buscar = new javax.swing.JButton();

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Historial de ventas");

        jLabel1.setText("Mes:");

        jLabel2.setText("Año:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ninguno", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla1);

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(284, 284, 284)
                                .addComponent(jLabel1)
                                .addGap(174, 174, 174)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(364, 364, 364)
                                .addComponent(buscar)))
                        .addGap(0, 276, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
    JTable tabla;
    int seleccionCombo1 = jComboBox1.getSelectedIndex();
    //int seleccionCombo2 = jComboBox2.getSelectedIndex();
    String seleccionCombo2 = jComboBox2.getSelectedItem().toString();
    DefaultTableModel modelo = new DefaultTableModel();
    tabla = this.tabla1;
    tabla.setModel(modelo);
    modelo.setColumnIdentifiers(new Object[]{"Tipo Evento", "Nombre Cliente", "Correo", "Telefono", "Ciudad", "Cantidad de Asistentes", "Costo Total"}); 
    
    conectar con = new conectar();
    Connection cn = con.conexion();
    String []eventos = new String [100];
    
    try{
         Statement stNombreEvento = cn.createStatement();
         String query;
         
         if (seleccionCombo1 == 0)
           query = "SELECT \n" +
            "		a.tipoEvento as Evento,\n" +
            "		cl.Nombre,\n" +
            "		cl.Correo_Electronico,\n" +
            "		cl.telCasa,\n" +
            "		cl.telCel,\n" +
            "		cl.Ciudad,\n" +
            "		c.totalpax as TotalPersonas,\n" +
            "		v.costototal as Total\n" +
            "FROM venta v\n" +
            "INNER JOIN cotizar c ON v.Cotizacion_idCotizacion = c.idcotizacion\n" +
            "INNER JOIN agenda a ON c.fkidagenda = a.idevento\n" +
            "INNER JOIN cliente cl ON a.fkidcliente = cl.idCliente\n" +
            "WHERE YEAR(v.fechaVenta) = '" + seleccionCombo2 + "';";
         else
            query = "SELECT \n" +
            "		a.tipoEvento as Evento,\n" +
            "		cl.Nombre,\n" +
            "		cl.Correo_Electronico,\n" +
            "		cl.telCasa,\n" +
            "		cl.telCel,\n" +
            "		cl.Ciudad,\n" +
            "		c.totalpax as TotalPersonas,\n" +
            "		v.costototal as Total\n" +
            "FROM venta v\n" +
            "INNER JOIN cotizar c ON v.Cotizacion_idCotizacion = c.idcotizacion\n" +
            "INNER JOIN agenda a ON c.fkidagenda = a.idevento\n" +
            "INNER JOIN cliente cl ON a.fkidcliente = cl.idCliente\n" +
            "WHERE MONTH(v.fechaVenta) = '" + seleccionCombo1 + "' AND YEAR(v.fechaVenta) = '" + seleccionCombo2 + "';";
         
         
         ResultSet rsNombreEvento = stNombreEvento.executeQuery(query);
            
         while(rsNombreEvento.next()){
               eventos [0] = rsNombreEvento.getString(1);
               eventos [1] = rsNombreEvento.getString(2);
               eventos [2] = rsNombreEvento.getString(3);
               eventos [3] = rsNombreEvento.getString(4);
               eventos [4] = rsNombreEvento.getString(6);
               eventos [5] = rsNombreEvento.getString(7);
               eventos [6] = rsNombreEvento.getString(8);
               modelo.addRow(eventos);
            } 
        }catch(Exception e){

        }
    }//GEN-LAST:event_buscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables

}
