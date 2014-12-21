/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mod_cotizar;

import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Zaibeh
 */
public class regCotizacion extends javax.swing.JFrame {
    private int idCotizacion;
    private conexionEquipo2 conn = new conexionEquipo2();
    private LinkedList<CotizarEvento> eventos = new LinkedList<CotizarEvento>();
    private LinkedList<Insumos> insumosMobiliario = new LinkedList<Insumos>();
    private LinkedList<Insumos> insumosBebidas = new LinkedList<Insumos>();
    private LinkedList<Insumos> insumosPlatillos = new LinkedList<Insumos>();
    private LinkedList<Insumos> insumosDecoraciones= new LinkedList<Insumos>();
    private LinkedList<Insumos> insumosBocadillos = new LinkedList<Insumos>();
    private LinkedList<Insumos> insumosPersonal = new LinkedList<Insumos>();
    private LinkedList<Insumos> insumosVariosAgregar= new LinkedList<Insumos>();
    private LinkedList<Cotizar> consultasCotizaciones = new LinkedList<Cotizar>();
    private LinkedList<CotTotales> listaResumen= new LinkedList<CotTotales>();
    
    private LinkedList<CotInsumoVarios> insumosVarios = new LinkedList<CotInsumoVarios>();
    private LinkedList<CotInsumo> cotInsumo = new LinkedList<CotInsumo>();
    
    private Consultar consultarCotizacion = new Consultar();
       
    /**
     * Creates new form regCotizacion
     */
    public regCotizacion() {
        initComponents();
        cargarInformacionMobiliario();
        cargarInformacionbebidas();
        cargarInformacionplatillos();
        cargarInformaciondecoraciones();
        cargarInformacionbocadillos();
        cargarInformacionpersonal();
        eventos= conn.getTipoEventos();
        Object[]datos = new Object[eventos.size()];
        
        for (int i =0; i<eventos.size();i++){
            datos[i]=eventos.get(i).getNombreCte()+" "+eventos.get(i).getAp()+" "+eventos.get(i).getAm();
        }
        
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(datos));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(datos));
    }

    //regCotizacion() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    public void cargarInformacionMobiliario(){
        insumosMobiliario = conn.getNombresMobiliario();
        Object[][] datos = new Object[insumosMobiliario.size()][3];
        for (int i = 0; i<insumosMobiliario.size();i++){
            datos[i][0]=insumosMobiliario.get(i).getNombreinsumo();
            datos[i][1]=insumosMobiliario.get(i).getPrecio().toString();
            datos[i][2]="0";
        }
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            datos,
            new String [] {
                "Nombre", "Precio", "Cantidad"
                    
            }
            
        ));
    }
    public void cargarInformacionbebidas(){
        insumosBebidas = conn.getNombresBebidas();
        Object[][] datos = new Object[insumosBebidas.size()][3];
        for (int i = 0; i<insumosBebidas.size();i++){
            datos[i][0]=insumosBebidas.get(i).getNombreinsumo();
            datos[i][1]=insumosBebidas.get(i).getPrecio().toString();
            datos[i][2]="0";
        }
        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            datos,
            new String [] {
                "Nombre", "Precio", "Cantidad"
                    
            }
                
            
        ));
    }
     public void cargarInformacionplatillos(){
        insumosPlatillos = conn.getNombresPlatillos();
        Object[][] datos = new Object[insumosPlatillos.size()][3];
        for (int i = 0; i<insumosPlatillos.size();i++){
            datos[i][0]=insumosPlatillos.get(i).getNombreinsumo();
            datos[i][1]=insumosPlatillos.get(i).getPrecio().toString();
            datos[i][2]="0";
        }
        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            datos,
            new String [] {
                "Nombre", "Precio", "Cantidad"
                    
            }
            
        ));
    }
      public void cargarInformaciondecoraciones(){
        insumosDecoraciones = conn.getNombresDecoraciones();
        Object[][] datos = new Object[insumosDecoraciones.size()][3];
        for (int i = 0; i<insumosDecoraciones.size();i++){
            datos[i][0]=insumosDecoraciones.get(i).getNombreinsumo();
            datos[i][1]=insumosDecoraciones.get(i).getPrecio().toString();
            datos[i][2]="0";
        }
        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            datos,
            new String [] {
                "Nombre", "Precio", "Cantidad"
                    
            }
            
        ));
    }
    public void cargarInformacionbocadillos(){
        insumosBocadillos = conn.getNombresBocadillos();
        Object[][] datos = new Object[insumosBocadillos.size()][3];
        for (int i = 0; i<insumosBocadillos.size();i++){
            datos[i][0]=insumosBocadillos.get(i).getNombreinsumo();
            datos[i][1]=insumosBocadillos.get(i).getPrecio().toString();
            datos[i][2]="0";
        }
        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            datos,
            new String [] {
                "Nombre", "Precio", "Cantidad"
                    
            }
            
        ));
    }
    public void cargarInformacionpersonal(){
        insumosPersonal = conn.getNombresPersonal();
        Object[][] datos = new Object[insumosPersonal.size()][3];
        for (int i = 0; i<insumosPersonal.size();i++){
            datos[i][0]=insumosPersonal.get(i).getNombreinsumo();
            datos[i][1]=insumosPersonal.get(i).getPrecio().toString();
            datos[i][2]="0";
        }
        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            datos,
            new String [] {
                "Nombre", "Precio", "Cantidad"
                    
            }
            
        ));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cotizara = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        agregarmobiliario = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        agregarbebidas = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable14 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generar cotización");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1024, 443));
        setResizable(false);

        cotizara.setPreferredSize(new java.awt.Dimension(700, 421));
        cotizara.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cotizaraMouseClicked(evt);
            }
        });

        jPanel2.setLayout(null);

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(170, 250, 250, 40);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(70, 10, 380, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Evento:");
        jLabel2.setToolTipText("Cliente:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 50, 440, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Cliente:");
        jLabel11.setToolTipText("Cliente:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(10, 10, 450, 30);
        jPanel2.add(jTextField9);
        jTextField9.setBounds(190, 90, 220, 28);
        jPanel2.add(jTextField10);
        jTextField10.setBounds(190, 120, 220, 28);

        jLabel12.setText("Total de Personas");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(80, 120, 120, 16);

        jLabel13.setText("Número de Personas por Mesa");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(10, 90, 190, 16);

        jLabel14.setText("Observaciones");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(50, 150, 120, 16);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(150, 150, 260, 80);

        cotizara.addTab("Cotizar", jPanel2);

        jPanel3.setLayout(null);

        agregarmobiliario.setText("Agregar");
        agregarmobiliario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarmobiliarioActionPerformed(evt);
            }
        });
        jPanel3.add(agregarmobiliario);
        agregarmobiliario.setBounds(340, 320, 260, 28);

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable7 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {

                if (colIndex!=2) {
                    return false; // la columna cero no es editable
                }
                return true;  //El resto de las columnas son editables.
            }

        };
        jScrollPane5.setViewportView(jTable7);

        jPanel3.add(jScrollPane5);
        jScrollPane5.setBounds(0, 0, 600, 290);

        cotizara.addTab("Mobiliario", jPanel3);

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Cantidad"
            }
        ));
        jTable8 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {

                if (colIndex!=2) {
                    return false; // la columna cero no es editable
                }
                return true;  //El resto de las columnas son editables.
            }

        };
        jScrollPane6.setViewportView(jTable8);

        agregarbebidas.setText("Agregar");
        agregarbebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarbebidasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarbebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 399, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(agregarbebidas)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        cotizara.addTab("Bebidas", jPanel1);

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Cantidad"
            }
        ));
        jTable9 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {

                if (colIndex!=2) {
                    return false; // la columna cero no es editable
                }
                return true;  //El resto de las columnas son editables.
            }

        };
        jScrollPane7.setViewportView(jTable9);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 399, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(0, 62, Short.MAX_VALUE))
        );

        cotizara.addTab("Platillos", jPanel4);

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Cantidad"
            }
        ));
        jTable10 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {

                if (colIndex!=2) {
                    return false; // la columna cero no es editable
                }
                return true;  //El resto de las columnas son editables.
            }

        };
        jScrollPane8.setViewportView(jTable10);

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 399, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(0, 62, Short.MAX_VALUE))
        );

        cotizara.addTab("Decoraciones", jPanel5);

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Cantidad"
            }
        ));
        jTable11 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {

                if (colIndex!=2) {
                    return false; // la columna cero no es editable
                }
                return true;  //El resto de las columnas son editables.
            }

        };
        jScrollPane9.setViewportView(jTable11);

        jButton5.setText("Agregar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 399, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addGap(0, 69, Short.MAX_VALUE))
        );

        cotizara.addTab("Bocadillos", jPanel6);

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Cantidad"
            }
        ));
        jTable12 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {

                if (colIndex!=2) {
                    return false; // la columna cero no es editable
                }
                return true;  //El resto de las columnas son editables.
            }

        };
        jScrollPane10.setViewportView(jTable12);

        jButton6.setText("Agregar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 399, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(0, 62, Short.MAX_VALUE))
        );

        cotizara.addTab("Personal", jPanel7);

        jTable13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {" ", "0", "0"},
                {" ", "0", "0"},
                {" ", "0", "0"},
                {" ", "0", "0"},
                {" ", "0", "0"},
                {" ", "0", "0"},
                {" ", "0", "0"},
                {" ", "0", "0"},
                {" ", "0", "0"},
                {" ", "0", "0"}
            },
            new String [] {
                "Nombre", "Precio", "Cantidad"
            }
        ));
        jScrollPane11.setViewportView(jTable13);

        jButton4.setText("Agregar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(389, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton4)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        cotizara.addTab("Varios", jPanel8);

        jLabel3.setText("Total de Mobiliario");

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel4.setText("Total de Bebidas");

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel5.setText("Total de Platillos");

        jLabel6.setText("Total de Decoraciones");

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel7.setText("Total de Bocadillos");

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setText("Total de Varios");

        jLabel9.setText("Total de Personal");

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel10.setText("Total Cotización:");

        jButton7.setText("Generar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(62, 62, 62)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(584, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        cotizara.addTab("Generar Cotización", jPanel9);

        jPanel12.setLayout(null);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel12.add(jComboBox3);
        jComboBox3.setBounds(70, 10, 240, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Evento:");
        jLabel17.setToolTipText("Cliente:");
        jPanel12.add(jLabel17);
        jLabel17.setBounds(10, 40, 440, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Cliente:");
        jLabel18.setToolTipText("Cliente:");
        jPanel12.add(jLabel18);
        jLabel18.setBounds(10, 10, 450, 30);

        jLabel19.setText("Total de Personas:");
        jPanel12.add(jLabel19);
        jLabel19.setBounds(80, 90, 120, 16);

        jLabel20.setText("Número de Personas por Mesa:");
        jPanel12.add(jLabel20);
        jLabel20.setBounds(10, 70, 190, 16);

        jLabel21.setText("Observaciones:");
        jPanel12.add(jLabel21);
        jLabel21.setBounds(10, 120, 120, 16);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel12.add(jScrollPane2);
        jScrollPane2.setBounds(10, 140, 330, 220);

        jTextField11.setEditable(false);
        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel12.add(jTextField11);
        jTextField11.setBounds(190, 60, 150, 27);

        jTextField12.setEditable(false);
        jTextField12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel12.add(jTextField12);
        jTextField12.setBounds(190, 90, 150, 27);

        jTable14.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable14 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jScrollPane12.setViewportView(jTable14);

        jPanel12.add(jScrollPane12);
        jScrollPane12.setBounds(350, 0, 640, 380);

        cotizara.addTab("Consultar Cotización", jPanel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cotizara, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cotizara, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarmobiliarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarmobiliarioActionPerformed
        cotInsumo= new LinkedList<CotInsumo>();
        //recorrer la tabla para obtener cantidades
        CotInsumo cotTabla;
        for (int i =0 ; i< insumosMobiliario.size();i++){
            cotTabla= new CotInsumo();
            

            //obtener a partir de la primera pestaña...
            cotTabla.setIdCotizacion(idCotizacion);
            
            
            
            cotTabla.setIdInsumo(insumosMobiliario.get(i).getIdinsumo());
            cotTabla.setNumeroInsumo(Integer.parseInt(((jTable7.getValueAt(i, 2).toString()))));
            if (cotTabla.getNumeroInsumo()>0)
            cotInsumo.add(cotTabla);
        }
        boolean ban =true;
        for (Iterator<CotInsumo> it = cotInsumo.iterator(); it.hasNext();) {
            CotInsumo cantidad = it.next();
            try {
                if (!conn.insertCotInsumo(cantidad)){ 
                    JOptionPane.showMessageDialog(null, "Error al ingresar Insumo: "+cantidad.getIdInsumo());
                    ban=false;
                }
            } catch (Exception e) {
            }
        }
        if (ban){
            JOptionPane.showMessageDialog(null, "MOBILIARIO agregado correctamente");
        }
        else {
            JOptionPane.showMessageDialog(null, "No se agregaron correctamente todos los insumos");
        }
    }//GEN-LAST:event_agregarmobiliarioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        idCotizacion=conn.insertCotizacion(Integer.parseInt(jTextField9.getText()),Float.parseFloat(jTextField10.getText()),jTextArea1.getText(),eventos.get(jComboBox1.getSelectedIndex()).getIdEvento());
        System.out.println(idCotizacion);
        
        cargarInformacionMobiliario();
        cargarInformacionbebidas();
        cargarInformacionplatillos();
        cargarInformaciondecoraciones();
        cargarInformacionbocadillos();
        cargarInformacionpersonal();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void agregarbebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarbebidasActionPerformed
        cotInsumo= new LinkedList<CotInsumo>();
        //recorrer la tabla para obtener cantidades
        CotInsumo cotTabla;
        for (int i =0 ; i< insumosBebidas.size();i++){
            cotTabla= new CotInsumo();
            //obtener a partir de la primera pestaña...
            cotTabla.setIdCotizacion(idCotizacion);
            cotTabla.setIdInsumo(insumosBebidas.get(i).getIdinsumo());
            cotTabla.setNumeroInsumo(Integer.parseInt(((jTable8.getValueAt(i, 2).toString()))));
            if (cotTabla.getNumeroInsumo()>0)
            cotInsumo.add(cotTabla);
        }
        boolean ban =true;
        for (Iterator<CotInsumo> it = cotInsumo.iterator(); it.hasNext();) {
            CotInsumo cantidad = it.next();
            try {
                if (!conn.insertCotInsumo(cantidad)){ 
                    JOptionPane.showMessageDialog(null, "Error al ingresar Insumo: "+cantidad.getIdInsumo());
                    ban=false;
                }
            } catch (Exception e) {
            }
        }
        if (ban){
            JOptionPane.showMessageDialog(null, "BEBIDAS agregadas correctamente");
        }
        else {
            JOptionPane.showMessageDialog(null, "No se agregaron correctamente todos los insumos");
        }     // TODO add your handling code here:
    }//GEN-LAST:event_agregarbebidasActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        jLabel2.setText("Evento: "+eventos.get(jComboBox1.getSelectedIndex()).getNombre());
        System.out.println("Evento: "+eventos.get(jComboBox1.getSelectedIndex()).getNombre()+"Evento: "+eventos.get(jComboBox1.getSelectedIndex()).getIdEvento());
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        insumosVarios= new LinkedList<CotInsumoVarios>();
        cotInsumo= new LinkedList<CotInsumo>();
        //recorrer la tabla para obtener cantidades
        CotInsumoVarios cotTabla;
        
        for (int i =0 ; i< jTable13.getRowCount()-1;i++){
            cotTabla= new CotInsumoVarios();
            //obtener a partir de la primera pestaña..
            cotTabla.setNombre(jTable13.getValueAt(i, 0).toString());
            cotTabla.setPrecio(Float.parseFloat(jTable13.getValueAt(i, 1).toString()));
            cotTabla.setTipo("varios");
            cotTabla.setCantidad(Integer.parseInt(jTable13.getValueAt(i, 2).toString()));
            
            if (cotTabla.getCantidad()>0)
                insumosVarios.add(cotTabla);
        }
        
        for (Iterator<CotInsumoVarios> it = insumosVarios.iterator(); it.hasNext();) {
            CotInsumoVarios nuevoInsumo = it.next();
            nuevoInsumo.setIdCotInsumoVarios(conn.insertInsumosVarios(nuevoInsumo));
        }

        CotInsumo cotListaVarios;
        for (int i =0 ; i< insumosVarios.size();i++){
            cotListaVarios= new CotInsumo();
            cotListaVarios.setIdCotizacion(idCotizacion);
            cotListaVarios.setIdInsumo(insumosVarios.get(i).getIdCotInsumoVarios());
            cotListaVarios.setNumeroInsumo(insumosVarios.get(i).getCantidad());
            
            if (cotListaVarios.getNumeroInsumo()>0)
                cotInsumo.add(cotListaVarios);
        }
        
        boolean ban =true;
        for (Iterator<CotInsumo> it = cotInsumo.iterator(); it.hasNext();) {
            CotInsumo cantidad = it.next();
            try {
                if (!conn.insertCotInsumo(cantidad)){ 
                    JOptionPane.showMessageDialog(null, "Error al ingresar Insumo: "+cantidad.getIdInsumo());
                    ban=false;
                }
            } catch (Exception e) {
            }
        }
        if (ban){
            JOptionPane.showMessageDialog(null, "VARIOS agregados correctamente");
        }
        else {
            JOptionPane.showMessageDialog(null, "No se agregaron correctamente todos los insumos");
        }     // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cotizaraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cotizaraMouseClicked

    }//GEN-LAST:event_cotizaraMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
             cotInsumo= new LinkedList<CotInsumo>();
        //recorrer la tabla para obtener cantidades
        CotInsumo cotTabla;
        for (int i =0 ; i< insumosPlatillos.size();i++){
            cotTabla= new CotInsumo();
            

            //obtener a partir de la primera pestaña...
            cotTabla.setIdCotizacion(idCotizacion);
            
            
            
            cotTabla.setIdInsumo(insumosPlatillos.get(i).getIdinsumo());
            cotTabla.setNumeroInsumo(Integer.parseInt(((jTable9.getValueAt(i, 2).toString()))));
            if (cotTabla.getNumeroInsumo()>0)
            cotInsumo.add(cotTabla);
        }
        boolean ban =true;
        for (Iterator<CotInsumo> it = cotInsumo.iterator(); it.hasNext();) {
            CotInsumo cantidad = it.next();
            try {
                if (!conn.insertCotInsumo(cantidad)){ 
                    JOptionPane.showMessageDialog(null, "Error al ingresar Insumo: "+cantidad.getIdInsumo());
                    ban=false;
                }
            } catch (Exception e) {
            }
        }
        if (ban){
            JOptionPane.showMessageDialog(null, "PLATILLOS agregados correctamente");
        }
        else {
             JOptionPane.showMessageDialog(null, "No se agregaron correctamente todos los insumos");
        }    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
              cotInsumo= new LinkedList<CotInsumo>();
        //recorrer la tabla para obtener cantidades
        CotInsumo cotTabla;
        for (int i =0 ; i< insumosDecoraciones.size();i++){
            cotTabla= new CotInsumo();
            

            //obtener a partir de la primera pestaña...
            cotTabla.setIdCotizacion(idCotizacion);
            
            
            
            cotTabla.setIdInsumo(insumosDecoraciones.get(i).getIdinsumo());
            cotTabla.setNumeroInsumo(Integer.parseInt(((jTable10.getValueAt(i, 2).toString()))));
            if (cotTabla.getNumeroInsumo()>0)
            cotInsumo.add(cotTabla);
        }
        boolean ban =true;
        for (Iterator<CotInsumo> it = cotInsumo.iterator(); it.hasNext();) {
            CotInsumo cantidad = it.next();
            try {
                if (!conn.insertCotInsumo(cantidad)){ 
                    JOptionPane.showMessageDialog(null, "Error al ingresar Insumo: "+cantidad.getIdInsumo());
                    ban=false;
                }
            } catch (Exception e) {
            }
        }
        if (ban){
            JOptionPane.showMessageDialog(null, "DECORACIONES agregadas correctamente");
        }
        else {
             JOptionPane.showMessageDialog(null, "No se agregaron correctamente todos los insumos");
        }    // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            cotInsumo= new LinkedList<CotInsumo>();
        //recorrer la tabla para obtener cantidades
        CotInsumo cotTabla;
        for (int i =0 ; i< insumosBocadillos.size();i++){
            cotTabla= new CotInsumo();
            

            //obtener a partir de la primera pestaña...
            cotTabla.setIdCotizacion(idCotizacion);
            
            
            
            cotTabla.setIdInsumo(insumosBocadillos.get(i).getIdinsumo());
            cotTabla.setNumeroInsumo(Integer.parseInt(((jTable11.getValueAt(i, 2).toString()))));
            if (cotTabla.getNumeroInsumo()>0)
            cotInsumo.add(cotTabla);
        }
        boolean ban =true;
        for (Iterator<CotInsumo> it = cotInsumo.iterator(); it.hasNext();) {
            CotInsumo cantidad = it.next();
            try {
                if (!conn.insertCotInsumo(cantidad)){ 
                    JOptionPane.showMessageDialog(null, "Error al ingresar Insumo: "+cantidad.getIdInsumo());
                    ban=false;
                }
            } catch (Exception e) {
            }
        }
        if (ban){
            JOptionPane.showMessageDialog(null, "BOCADILLOS agregados correctamente");
        }
        else {
             JOptionPane.showMessageDialog(null, "No se agregaron correctamente todos los insumos");
        }    // TODO add your handling code here:

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
               cotInsumo= new LinkedList<CotInsumo>();
        //recorrer la tabla para obtener cantidades
        CotInsumo cotTabla;
        for (int i =0 ; i< insumosPersonal.size();i++){
            cotTabla= new CotInsumo();
            

            //obtener a partir de la primera pestaña...
            cotTabla.setIdCotizacion(idCotizacion);
            
            
            
            cotTabla.setIdInsumo(insumosPersonal.get(i).getIdinsumo());
            cotTabla.setNumeroInsumo(Integer.parseInt(((jTable12.getValueAt(i, 2).toString()))));
            if (cotTabla.getNumeroInsumo()>0)
            cotInsumo.add(cotTabla);
        }
        boolean ban =true;
        for (Iterator<CotInsumo> it = cotInsumo.iterator(); it.hasNext();) {
            CotInsumo cantidad = it.next();
            try {
                if (!conn.insertCotInsumo(cantidad)){ 
                    JOptionPane.showMessageDialog(null, "Error al ingresar Insumo: "+cantidad.getIdInsumo());
                    ban=false;
                }
            } catch (Exception e) {
            }
        }
        if (ban){
            JOptionPane.showMessageDialog(null, "PERSONAL agregado correctamente");
        }
        else {
             JOptionPane.showMessageDialog(null, "No se agregaron correctamente todos los insumos");
        }     // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        insumosMobiliario = conn.getNombresMobiliario();
        insumosBebidas= conn.getNombresBebidas();
        insumosBocadillos= conn.getNombresBocadillos();
        insumosDecoraciones= conn.getNombresDecoraciones();
        insumosPersonal= conn.getNombresPersonal();
        insumosPlatillos= conn.getNombresPlatillos();
        insumosVariosAgregar = conn.getNombresVarios();
        
        LinkedList<CotTotales> precios = new LinkedList<CotTotales>();
        precios=conn.getPreciosCantidades(idCotizacion);
        
        for (Iterator<CotTotales> it = precios.iterator(); it.hasNext();) {
            CotTotales cotTotales = it.next();
            System.out.println(cotTotales.getIdCotizacion());
            System.out.println(cotTotales.getIdConsumo());
        }
        
        for (Iterator<CotTotales> it = precios.iterator(); it.hasNext();) {
            CotTotales cotTotales = it.next();
            for (Iterator<Insumos> it1 = insumosMobiliario.iterator() ; it1.hasNext();) {
                Insumos insumos = it1.next();
                if (cotTotales.getIdConsumo()==insumos.getIdinsumo()){
                    cotTotales.setPrecio(insumos.getPrecio());
                    cotTotales.setTipo("mobiliario");
                }
            }
        }
        
        for (Iterator<CotTotales> it = precios.iterator(); it.hasNext();) {
            CotTotales cotTotales = it.next();
            for (Iterator<Insumos> it1 = insumosBebidas.iterator() ; it1.hasNext();) {
                Insumos insumos = it1.next();
                if (cotTotales.getIdConsumo()==insumos.getIdinsumo()){
                    cotTotales.setPrecio(insumos.getPrecio());
                    cotTotales.setTipo("bebidas");
                }
            }
        }
        
        for (Iterator<CotTotales> it = precios.iterator(); it.hasNext();) {
            CotTotales cotTotales = it.next();
            for (Iterator<Insumos> it1 = insumosBocadillos.iterator() ; it1.hasNext();) {
                Insumos insumos = it1.next();
                if (cotTotales.getIdConsumo()==insumos.getIdinsumo()){
                    cotTotales.setPrecio(insumos.getPrecio());
                    cotTotales.setTipo("bocadillos");
                }
            }
        }
        
        for (Iterator<CotTotales> it = precios.iterator(); it.hasNext();) {
            CotTotales cotTotales = it.next();
            for (Iterator<Insumos> it1 = insumosDecoraciones.iterator() ; it1.hasNext();) {
                Insumos insumos = it1.next();
                if (cotTotales.getIdConsumo()==insumos.getIdinsumo()){
                    cotTotales.setPrecio(insumos.getPrecio());
                    cotTotales.setTipo("decoraciones");
                }
            }
        }
        
        for (Iterator<CotTotales> it = precios.iterator(); it.hasNext();) {
            CotTotales cotTotales = it.next();
            for (Iterator<Insumos> it1 = insumosPersonal.iterator() ; it1.hasNext();) {
                Insumos insumos = it1.next();
                if (cotTotales.getIdConsumo()==insumos.getIdinsumo()){
                    cotTotales.setPrecio(insumos.getPrecio());
                    cotTotales.setTipo("personal");
                }
            }
        }
        
        for (Iterator<CotTotales> it = precios.iterator(); it.hasNext();) {
            CotTotales cotTotales = it.next();
            for (Iterator<Insumos> it1 = insumosPlatillos.iterator() ; it1.hasNext();) {
                Insumos insumos = it1.next();
                if (cotTotales.getIdConsumo()==insumos.getIdinsumo()){
                    cotTotales.setPrecio(insumos.getPrecio());
                    cotTotales.setTipo("platillos");
                }
            }
        }
        
        for (Iterator<CotTotales> it = precios.iterator(); it.hasNext();) {
            CotTotales cotTotales = it.next();
            for (Iterator<Insumos> it1 = insumosVariosAgregar.iterator() ; it1.hasNext();) {
                Insumos insumos = it1.next();
                if (cotTotales.getIdConsumo()==insumos.getIdinsumo()){
                    cotTotales.setPrecio(insumos.getPrecio());
                    cotTotales.setTipo("varios");
                }
            }
        }
        
        Double totalMobiliario=0.0,totalBebidas=0.0, totalDecoraciones=0.0, totalPlatillos=0.0, totalBocadillos=0.0, totalPersonal=0.0, totalVarios=0.0;
        
        for (Iterator<CotTotales> it = precios.iterator(); it.hasNext();) {
            CotTotales cotTotales = it.next();
            if (cotTotales.getTipo()=="mobiliario"){
                totalMobiliario+=(cotTotales.getPrecio()*cotTotales.getCantidad());
            }
            if (cotTotales.getTipo()=="bebidas"){
                totalBebidas+=(cotTotales.getPrecio()*cotTotales.getCantidad());
            }
            if (cotTotales.getTipo()=="platillos"){
                totalPlatillos+=(cotTotales.getPrecio()*cotTotales.getCantidad());
            }
            if (cotTotales.getTipo()=="decoraciones"){
                totalDecoraciones+=(cotTotales.getPrecio()*cotTotales.getCantidad());
            }
            if (cotTotales.getTipo()=="bocadillos"){
                totalBocadillos+=(cotTotales.getPrecio()*cotTotales.getCantidad());
            }
            if (cotTotales.getTipo()=="personal"){
                totalPersonal+=(cotTotales.getPrecio()*cotTotales.getCantidad());
            }
            if (cotTotales.getTipo()=="varios"){
                totalVarios+=(cotTotales.getPrecio()*cotTotales.getCantidad());
            }
        }
        jTextField1.setText(totalMobiliario.toString());
        jTextField2.setText(totalBebidas.toString());
        jTextField3.setText(totalPlatillos.toString());
        jTextField4.setText(totalDecoraciones.toString());
        jTextField5.setText(totalBocadillos.toString());
        jTextField6.setText(totalPersonal.toString());
        jTextField7.setText(totalVarios.toString());
        Double total=0.0;
        total=totalBebidas+totalMobiliario+totalPlatillos+totalDecoraciones+totalPlatillos+totalPersonal+totalVarios;
        jTextField8.setText(total.toString());
        
        conn.insertCosto(idCotizacion, total);
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        jLabel17.setText("Evento: "+eventos.get(jComboBox3.getSelectedIndex()).getNombre());
        //cargar informacion de agenda
        consultasCotizaciones= conn.getCotizacionConsulta(eventos.get(jComboBox3.getSelectedIndex()).getIdEvento());
        
        jTextField11.setText(String.valueOf(consultasCotizaciones.getFirst().getNumpax()));
        jTextField12.setText(String.valueOf(consultasCotizaciones.getFirst().getTotalpax()));
        jTextArea2.setText(String.valueOf(consultasCotizaciones.getFirst().getObservaciones()));
        
        listaResumen = conn.getListaFinal(consultasCotizaciones.getFirst().getIdcotizacion());
        Object[][] datos = new Object[listaResumen.size()][3];
        for (int i = 0; i<listaResumen.size();i++){
            datos[i][0]=listaResumen.get(i).getNombreInsumo();
            datos[i][1]=listaResumen.get(i).getPrecio().toString();
            datos[i][2]=listaResumen.get(i).getCantidad();
        }
        jTable14.setModel(new javax.swing.table.DefaultTableModel(
            datos,
            new String [] {
                "Nombre", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed
    
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
            java.util.logging.Logger.getLogger(regCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(regCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(regCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(regCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new regCotizacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarbebidas;
    private javax.swing.JButton agregarmobiliario;
    private javax.swing.JTabbedPane cotizara;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    public javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable14;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
