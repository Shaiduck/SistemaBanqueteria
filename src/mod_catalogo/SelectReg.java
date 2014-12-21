/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mod_catalogo;

import controles.Consultas;

/**
 *
 * @author Jesus
 */
public class SelectReg extends javax.swing.JDialog {

    private Consultas con;
    
    public SelectReg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        con = new Consultas();
    }

    public void muestraPla(){
        this.jTable1.setModel(con.llenaPlatillos());
        this.setVisible(true);
    }
    
    public void muestraBeb(){
        this.jTable1.setModel(con.llenaBebidas());
        this.setVisible(true);
    }
    
    public void muestraMob(){
        this.jTable1.setModel(con.llenaMobiliario());
        this.setVisible(true);
    }
    
    public void muestraDec(){
        this.jTable1.setModel(con.llenaDecoraciones());
        this.setVisible(true);
    }
    
    public void muestraBoc(){
        this.jTable1.setModel(con.llenaBocadillos());
        this.setVisible(true);
    }
    
    public void muestraPer(){
        this.jTable1.setModel(con.llenaPersonal());
        this.setVisible(true);
    }
    
    public void muestraSal(){
        this.jTable1.setModel(con.llenaSalon());
        this.setVisible(true);
    }
    
    public String getid(){
        String id;
        try{
            id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        }catch(Exception ex){
            id="";
        }
        return id;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setName("tabla1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
